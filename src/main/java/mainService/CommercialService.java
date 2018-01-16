package mainService;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;


import javax.naming.NamingException;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.springframework.stereotype.Service;

import entity.CommercialProduit;
import service.GCWS;
import service.GestionCommercialServiceService;

@Service
public class CommercialService {

	private GCWS gcService;
	
	public CommercialService() {
		gcService = new GestionCommercialServiceService().getGCWSPort();
	}

	public List<CommercialProduit> getProduitsCommercial() {
		return gcService.getProduits();
	}
	
	public boolean ajouterCommande(int codeCmd, String client, int codePdt, int qteCmd, Date dateCmd) {
		
		GregorianCalendar c = new GregorianCalendar();
		c.setTime(dateCmd);
		XMLGregorianCalendar date2 = null;
		try {
			date2 = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
		} catch (DatatypeConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return gcService.ajouterCommande(codeCmd, client, codePdt, qteCmd, date2);
	}

}
