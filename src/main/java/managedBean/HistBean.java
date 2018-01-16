package managedBean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import dao.CommandeDAO;
import entity.Commande;

@Component
@SessionScoped
public class HistBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<Commande> cmds;
	
	@Autowired
	private CommandeDAO commandeDAO;
	

	public List<Commande> getCmds() {
		return cmds;
	}

	public void setCmds(List<Commande> cmds) {
		this.cmds = cmds;
	}
	
	public void loadCmds() {
		FacesContext context = FacesContext.getCurrentInstance();
		cmds = commandeDAO.getCmdsByClient((String) context.getExternalContext().getSessionMap().get("username"));
	}
	
}
