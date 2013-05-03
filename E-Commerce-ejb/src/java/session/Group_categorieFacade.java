/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.Group_categorie;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author epdaw
 */
@Stateless
@LocalBean
public class Group_categorieFacade extends AbstractFacade<Group_categorie> {
    @PersistenceContext(unitName = "E-Commerce-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public Group_categorieFacade() {
        super(Group_categorie.class);
    }
    
}
