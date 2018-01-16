package entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="users")
public class User implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codeUser;
	
	@Column(length=20, unique=true)
	private String login;
	
	@Column(length=20)
	private String pass;
	
	public User() {}

	public User(String login, String pass) {
		super();
		this.login = login;
		this.pass = pass;
	}

	public int getCodeUser() {
		return codeUser;
	}

	public void setCodeUser(int codeUser) {
		this.codeUser = codeUser;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
	
	
}
