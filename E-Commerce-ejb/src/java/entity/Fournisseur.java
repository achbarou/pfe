/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author epdaw
 */
@Entity
public class Fournisseur implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nom_fourni ;
    private String adresse_fourni ;
    private String email_fourni ;
    private String tel_fourni ;
    private String fax_fourni ;
    private String ville_fourni ;
    private String pays_fourni ;
    @ManyToOne
    private Employe createdBy ;

    public Employe getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Employe CreatedBye) {
        this.createdBy = CreatedBye;
    }

    public String getNom_fourni() {
        return nom_fourni;
    }

    public void setNom_fourni(String nom_fourni) {
        this.nom_fourni = nom_fourni;
    }

    public String getAdresse_fourni() {
        return adresse_fourni;
    }

    public void setAdresse_fourni(String adresse_fourni) {
        this.adresse_fourni = adresse_fourni;
    }

    public String getEmail_fourni() {
        return email_fourni;
    }

    public void setEmail_fourni(String email_fourni) {
        this.email_fourni = email_fourni;
    }

    public String getTel_fourni() {
        return tel_fourni;
    }

    public void setTel_fourni(String tel_fourni) {
        this.tel_fourni = tel_fourni;
    }

    public String getFax_fourni() {
        return fax_fourni;
    }

    public void setFax_fourni(String fax_fourni) {
        this.fax_fourni = fax_fourni;
    }

    public String getVille_fourni() {
        return ville_fourni;
    }

    public void setVille_fourni(String ville_fourni) {
        this.ville_fourni = ville_fourni;
    }

    public String getPays_fourni() {
        return pays_fourni;
    }

    public void setPays_fourni(String pays_fourni) {
        this.pays_fourni = pays_fourni;
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
        if (!(object instanceof Fournisseur)) {
            return false;
        }
        Fournisseur other = (Fournisseur) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Fournisseur[ id=" + id + " ]";
    }
    
}
