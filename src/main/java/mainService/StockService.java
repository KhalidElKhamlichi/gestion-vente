package mainService;

import java.util.Hashtable;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.springframework.stereotype.Service;

import entity.StockProduit;
import service.StockRemote;

@Service
public class StockService {
	
	private StockRemote stock;
	
	public StockService() {
		
		
		try {
			System.out.println("stock constructor called");
			final Hashtable<String, String> jndiProperties = new Hashtable<String, String>();
	        jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");
	        jndiProperties.put(Context.PROVIDER_URL,"remote+http://localhost:8080");
	        jndiProperties.put(Context.SECURITY_PRINCIPAL, System.getProperty("username", "khalid"));
	        jndiProperties.put(Context.SECURITY_CREDENTIALS, System.getProperty("password", "1234abcd"));
	        Context context;
			context = new InitialContext(jndiProperties);
			stock = (StockRemote) context.lookup("ejb:/gestion_stock/Stock!"+StockRemote.class.getName());
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        
	}

	
	public List<StockProduit> getProduitsStock() {
		System.out.println("is stock null: "+stock == null);
		return stock.getProduits();
	}
	
	public boolean updateQteStock(int codePdt, int qteCmd) {
		return stock.updateQte(codePdt, qteCmd);
	}

	public StockRemote getStock() {
		return stock;
	}

	public void setStock(StockRemote stock) {
		this.stock = stock;
	}
	
	
}
