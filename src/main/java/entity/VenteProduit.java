package entity;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class VenteProduit implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int codePdt;
	private String nomPdt;
	private int prixPdt;
	private int qtePdt;
	
	public VenteProduit() {}
	
	public VenteProduit(int codePdt, String nomPdt, int prixPdt, int qtePdt) {
		super();
		this.codePdt = codePdt;
		this.nomPdt = nomPdt;
		this.prixPdt = prixPdt;
		this.qtePdt = qtePdt;
	}

	public int getCodePdt() {
		return codePdt;
	}

	public void setCodePdt(int codePdt) {
		this.codePdt = codePdt;
	}

	public String getNomPdt() {
		return nomPdt;
	}

	public void setNomPdt(String nomPdt) {
		this.nomPdt = nomPdt;
	}

	public int getPrixPdt() {
		return prixPdt;
	}

	public void setPrixPdt(int prixPdt) {
		this.prixPdt = prixPdt;
	}

	public int getQtePdt() {
		return qtePdt;
	}

	public void setQtePdt(int qtePdt) {
		this.qtePdt = qtePdt;
	}

	@Override
	public String toString() {
		return "VenteProduit [codePdt=" + codePdt + ", nomPdt=" + nomPdt + ", prixPdt=" + prixPdt + ", qtePdt=" + qtePdt
				+ "]";
	}

	
	
}
