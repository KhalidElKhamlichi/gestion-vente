package entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.Type;

@Entity(name="commandes")
public class Commande implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codeCmd;
	
	@Column(length=20)
	private String client;
	
	private int codePdt;
	
	private int qteCmd;
	
	@Type(type="date")
	private Date dateCmd;
	
	public Commande() {}

	public Commande(String client, int codePdt, int qteCmd, Date dateCmd) {
		super();
		this.client = client;
		this.codePdt = codePdt;
		this.qteCmd = qteCmd;
		this.dateCmd = dateCmd;
	}

	public int getCodeCmd() {
		return codeCmd;
	}

	public void setCodeCmd(int codeCmd) {
		this.codeCmd = codeCmd;
	}

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	public int getCodePdt() {
		return codePdt;
	}

	public void setCodePdt(int codePdt) {
		this.codePdt = codePdt;
	}

	public int getQteCmd() {
		return qteCmd;
	}

	public void setQteCmd(int qteCmd) {
		this.qteCmd = qteCmd;
	}

	public Date getDateCmd() {
		return dateCmd;
	}

	public void setDateCmd(Date dateCmd) {
		this.dateCmd = dateCmd;
	}

	@Override
	public String toString() {
		return "Commande [codeCmd=" + codeCmd + ", client=" + client + ", codePdt=" + codePdt + ", qteCmd=" + qteCmd
				+ ", dateCmd=" + dateCmd + "]";
	}
	
	
}
