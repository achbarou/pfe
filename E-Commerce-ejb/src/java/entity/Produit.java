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
import javax.persistence.Transient;

/**
 *
 * @author epdaw
 */
@Entity
public class Produit implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String Libelle ;
    private String Description;
    private String photo ;
    private String Nouveaute_prod ;
    private Integer solde_prod = 0;
    private Double quantite ;
    private Double poids ;
    private Boolean etat ;
    private Boolean disponibilité ;
    private Double prix_livraison ;
    private String unite ;
    @Transient
    private Integer quantiteSelect = 1 ;
    @Transient 
    private Double prixApresSolde = (double) 0 ;
    private Double unite_prix ;
    @ManyToOne
    private Employe createdBy ;
    @ManyToOne
    private Categorie categorie ;
    @ManyToOne
    private Fournisseur fournisseur;
    
    public Double getQuantite() {
        return quantite;
    }

    public void setQuantite(Double quantite) {
        this.quantite = quantite;
    }

    public Double getPrixApresSolde() {
        
        return  getUnite_prix() - ( getUnite_prix() * getSolde_prod()/100);
    }

    public void setPrixApresSolde(Double PrixApresSolde) {
        this.prixApresSolde = PrixApresSolde;
    }
    
    public Double getPoids() {
        return poids;
    }

    public void setPoids(Double poids) {
        this.poids = poids;
    }

    public Boolean getEtat() {
        return etat;
    }

    public void setEtat(Boolean etat) {
        this.etat = etat;
    }

    public Boolean getDisponibilité() {
        return disponibilité;
    }

    public void setDisponibilité(Boolean disponibilité) {
        this.disponibilité = disponibilité;
    }

    public Fournisseur getFournisseur() {
        return fournisseur;
    }

    public void setFournisseur(Fournisseur fournisseur) {
        this.fournisseur = fournisseur;
    }

    public Integer getQuantiteSelect() {
        return quantiteSelect;
    }

    public void setQuantiteSelect(Integer quantiteSelect) {
        this.quantiteSelect = quantiteSelect;
    }
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLibelle() {
        return Libelle;
    }

    public void setLibelle(String Libelle) {
        this.Libelle = Libelle;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getNouveaute_prod() {
        return Nouveaute_prod;
    }

    public void setNouveaute_prod(String Nouveaute_prod) {
        this.Nouveaute_prod = Nouveaute_prod;
    }

    public Integer getSolde_prod() {
        return solde_prod;
    }

    public void setSolde_prod(Integer solde_prod) {
        this.solde_prod = solde_prod;
    }

    public Double getPrix_livraison() {
        return prix_livraison;
    }

    public void setPrix_livraison(Double prix_livraison) {
        this.prix_livraison = prix_livraison;
    }

    public String getUnite() {
        return unite;
    }

    public void setUnite(String unite) {
        this.unite = unite;
    }

    public Double getUnite_prix() {
        return unite_prix;
    }

    public void setUnite_prix(Double unite_prix) {
        this.unite_prix = unite_prix;
    }

    public Employe getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Employe createdBy) {
        this.createdBy = createdBy;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
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
        if (!(object instanceof Produit)) {
            return false;
        }
        Produit other = (Produit) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Produit[ id=" + id + " ]";
    }
    
}
