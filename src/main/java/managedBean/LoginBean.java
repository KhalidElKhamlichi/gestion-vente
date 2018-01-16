package managedBean;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import dao.UserDAO;
import entity.User;

@Component
@SessionScoped
public class LoginBean implements Serializable {
 
    private static final long serialVersionUID = 1L;
    
    private String password;
    private String message;
    private String username;
    
    @Autowired
    private UserDAO userDAO;
 
    public String getMessage() {
        return message;
    }
 
    public void setMessage(String message) {
        this.message = message;
    }
 
    public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }
 
    public String getUsername() {
        return username;
    }
 
    public void setUsername(String username) {
        this.username = username;
    }
 
    public String loginApp() {
        boolean result = userDAO.login(username, password);
        FacesContext context = FacesContext.getCurrentInstance();
        if (result) {

            // get Session and store username
            context.getExternalContext().getSessionMap().put("username", username);
          
            return "ListProduits";
        } else {
        	context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
                    "Authentification invalide!",
                    "Veuillez réessayer!"));
            

            return "Login";
        }
    }
 
    public String logout() {
      
    	FacesContext context = FacesContext.getCurrentInstance();
    	context.getExternalContext().getSessionMap().clear();
    	return "Login";
   }
    
 
}