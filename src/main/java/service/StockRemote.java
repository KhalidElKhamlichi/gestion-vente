package service;

import java.util.List;

import javax.ejb.Remote;

import entity.StockProduit;

@Remote
public interface StockRemote {
	
	public List<StockProduit> getProduits();
	
	public boolean updateQte(int codePdt, int qteCmd);
	
	
}
