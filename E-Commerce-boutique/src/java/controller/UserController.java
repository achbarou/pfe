package controller;

import controller.util.JsfUtil;
import controller.util.UtilitaireSession ;
import entity.Client;
import java.io.Serializable;
import java.util.Iterator;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "userController")
@SessionScoped
public class UserController implements Serializable {

    private Client current;
    private Client loggedUser;
    @EJB
    private session.ClientFacade ejbFacade;

    public Client getLoggedUser() {
        return loggedUser;
    }

    public void setLoggedUser(Client loggedUser) {
        this.loggedUser = loggedUser;
    }

    public UserController() {
    }

    public Client getSelected() {
        if (current == null) {
            current = new Client();
        }
        return current;
    }
    
    public String login(){
        boolean trouve = false;
        for (Iterator it = ejbFacade.findAll().iterator(); it.hasNext();) {
            Client u = (Client) it.next();
            System.out.println("this: "+u.getEmail()+"  --> "+u.getPassword());
            System.out.println("current: "+current.getEmail()+"  --> "+current.getPassword());
            if (u.equals(current)) {
                current = u;
                setLoggedUser(u);
                UtilitaireSession us = UtilitaireSession.getInstance();
                us.set("auth", current);
                trouve = true;
                break;
            }
        }
        if (trouve) {
               System.out.println("trouve");
            return "index";
        } else {
            System.out.println("non trouve");
            JsfUtil.addErrorMessage("L'email ou le mot de passe que vous avez saisi est incorrect");
            return null;
        }
    }
    
    public String logout() {
        UtilitaireSession us = UtilitaireSession.getInstance();
        us.set("auth", null);
        setLoggedUser(null);
        current = null;
        return "index";
    }

    
}
