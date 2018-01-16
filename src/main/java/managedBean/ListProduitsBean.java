package managedBean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import dao.CommandeDAO;
import entity.Commande;
import entity.CommercialProduit;
import entity.Facture;
import entity.StockProduit;
import entity.VenteProduit;
import mainService.CommercialService;
import mainService.StockService;

@Component
@SessionScoped
public class ListProduitsBean implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<VenteProduit> produits;
	private VenteProduit selectedProduit;
	private int cmdQte = 1;
	private Commande cmd;
	
	@Autowired
	private CommercialService commercialService;
	@Autowired
	private CommandeDAO commandeDAO;
	
	@Autowired
	private StockService stockService;
	
	
	@PostConstruct
	public void init() {
		
		produits = new ArrayList<VenteProduit>();
		
		List<StockProduit> stockProduits = stockService.getProduitsStock();
		List<CommercialProduit> commProduits = commercialService.getProduitsCommercial();
		
		for (CommercialProduit commercialProduit : commProduits) {
			for (StockProduit stockProduit : stockProduits) {
				if(commercialProduit.getCodePdt() == stockProduit.getCodePdt()) {
					produits.add(new VenteProduit(stockProduit.getCodePdt(), commercialProduit.getNomPdt(), commercialProduit.getPrixPdt(), stockProduit.getQtePdt()));
				}
			}
		}
		// set default selection
		selectedProduit = produits.get(0);
	}
	
	public void commander() {
		FacesContext context = FacesContext.getCurrentInstance();
		String client = (String) context.getExternalContext().getSessionMap().get("username");
		if(client == null)
			client = "tester";
		if(stockService.updateQteStock(selectedProduit.getCodePdt(), cmdQte)) {
			selectedProduit.setQtePdt(selectedProduit.getQtePdt()-cmdQte);
			cmd = new Commande(client, selectedProduit.getCodePdt(), cmdQte, new Date());
			if(commandeDAO.save(cmd))
				if(commercialService.ajouterCommande(cmd.getCodeCmd(), client, selectedProduit.getCodePdt(), cmdQte, new Date())) {
					cmdMessage(context);
					new Facture(cmd, selectedProduit).generate();
					factureMessage(context);
				}
		}
	
	}
	
	public void cmdMessage(FacesContext context) {
         
        context.addMessage(null, new FacesMessage("Réussi",  "Commande effectuée.") );
    }
	
	public void factureMessage(FacesContext context) {
         
        context.addMessage(null, new FacesMessage("Réussi",  "Facture générée.") );
     
    }
	
	public List<VenteProduit> getProduits() {
		return produits;
	}

	public void setProduits(List<VenteProduit> produits) {
		this.produits = produits;
	}

	public VenteProduit getSelectedProduit() {
		return selectedProduit;
	}

	public void setSelectedProduit(VenteProduit selectedProduit) {
		this.selectedProduit = selectedProduit;
	}

	public int getCmdQte() {
		return cmdQte;
	}

	public void setCmdQte(int cmdQte) {
		this.cmdQte = cmdQte;
	}

	public Commande getCmd() {
		return cmd;
	}

	public void setCmd(Commande cmd) {
		this.cmd = cmd;
	}

	public CommercialService getCmService() {
		return commercialService;
	}

	public void setCmService(CommercialService cmService) {
		this.commercialService = cmService;
	}

	public StockService getStService() {
		return stockService;
	}

	public void setStService(StockService stService) {
		this.stockService = stService;
	}
	
	
}
