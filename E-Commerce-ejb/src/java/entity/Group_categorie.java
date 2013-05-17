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
public class Group_categorie implements Serializable {
    @OneToMany(mappedBy = "super_cat")
    private List<Categorie> categories;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String libelle_GroupCat;
    private Boolean etat ;
    private String Description ;
    @ManyToOne
    private Employe createdBy ;
    

    public Employe getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Employe createdBye) {
        this.createdBy = createdBye;
    }

    public String getLibelle_GroupCat() {
        return libelle_GroupCat;
    }

    public void setLibelle_GroupCat(String libelle_GroupCat) {
        this.libelle_GroupCat = libelle_GroupCat;
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
        if (!(object instanceof Group_categorie)) {
            return false;
        }
        Group_categorie other = (Group_categorie) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Group_categorie[ id=" + id + " ]";
    }
    
    public List<Categorie> getCategories() {
        return categories;
    }

    public void setCategories(List<Categorie> categories) {
        this.categories = categories;
    }

    public Boolean getEtat() {
        return etat;
    }

    public void setEtat(Boolean etat) {
        this.etat = etat;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }
    
}
