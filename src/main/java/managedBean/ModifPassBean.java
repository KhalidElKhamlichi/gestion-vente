package managedBean;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import dao.UserDAO;

@Component
@SessionScoped
public class ModifPassBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String oldPass;
	private String newPass;
	
	@Autowired
    private UserDAO userDAO;
	
	public String getOldPass() {
		return oldPass;
	}
	public void setOldPass(String oldPass) {
		this.oldPass = oldPass;
	}
	public String getNewPass() {
		return newPass;
	}
	public void setNewPass(String newPass) {
		this.newPass = newPass;
	}
	
	
	public void modifierPass() {
		FacesContext context = FacesContext.getCurrentInstance();
		boolean result = userDAO.modifier((String) context.getExternalContext().getSessionMap().get("username"), oldPass, newPass);
        
        if (result) {
        	context.addMessage(null, new FacesMessage("Réussi",  "Mot de passe modifié."));
        } else {
        	context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"mot de passe invalid!", "Veuillez réessayer"));
            
        }
	}
}
