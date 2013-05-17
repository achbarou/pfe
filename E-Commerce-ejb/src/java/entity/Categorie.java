/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author epdaw
 */
@Entity
public class Categorie implements Serializable {
    @OneToMany(mappedBy = "categorie")
    private List<Produit> produits;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String libelle_cat;
    private String description ;
    private Boolean etat ;

    @ManyToOne
    private Group_categorie super_cat ;
    
    @ManyToOne
    private Employe createdBye;

    public Group_categorie getSuper_cat() {
        return super_cat;
    }

    public void setSuper_cat(Group_categorie super_cat) {
        this.super_cat = super_cat;
    }

    public Employe getCreatedBye() {
        return createdBye;
    }

    public void setCreatedBye(Employe createdBye) {
        this.createdBye = createdBye;
    }

    public String getLibelle_cat() {
        return libelle_cat;
    }

    public void setLibelle_cat(String libelle_cat) {
        this.libelle_cat = libelle_cat;
    }
      public List<Produit> getProduits() {
        return produits;
    }

    public void setProduits(List<Produit> produits) {
        this.produits = produits;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String desription) {
        this.description = desription;
    }

    public Boolean getEtat() {
        return etat;
    }

    public void setEtat(Boolean etat) {
        this.etat = etat;
    }
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Categorie)) {
            return false;
        }
        Categorie other = (Categorie) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Categorie[ id=" + id + " ]";
    }
    
}
