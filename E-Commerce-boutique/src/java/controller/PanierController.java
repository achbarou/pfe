/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Produit;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author epdaw
 */
@ManagedBean(name = "panierController")
@SessionScoped
public class PanierController implements Serializable {

    private List<Produit> products = new ArrayList<Produit>();
    private double total = 0;
    private Integer NumberOfelement =0 ;
   

    public double getTotal() {
        total = 0;
        for (Produit item : products) {
            total += (item.getPrixApresSolde() * item.getQuantiteSelect());
        }
        return total;
    }
     public Integer getNumberOfelement() {
        
        NumberOfelement = 0;

        for (Produit scItem : products) {

            NumberOfelement += scItem.getQuantiteSelect();
        }

        return NumberOfelement;
    }

    public void setNumberOfelement(Integer NumberOfelement) {
        this.NumberOfelement = NumberOfelement;
    }
     

    public void setTotal(double total) {
        this.total = total;
    }

    public void add(Produit product,Integer quantite) {
        Produit prd =  new Produit();
        prd.setId(product.getId());
        prd.setUnite_prix(product.getUnite_prix());
        prd.setLibelle(product.getLibelle());
        prd.setQuantiteSelect(quantite);
        prd.setSolde_prod(product.getSolde_prod());
        prd.setPrixApresSolde(prd.getUnite_prix() - (prd.getUnite_prix()*prd.getSolde_prod()/100));
        Produit itm = null;
        boolean found = false;
        for (Produit item : products) {
            if(prd.getId().equals(item.getId())){
                System.out.println("item: "+item.getQuantiteSelect());
                System.out.println("product: "+quantite);
                prd.setQuantiteSelect(quantite+item.getQuantiteSelect());
                itm = item;
                found = true;
            }
        }
       System.out.println("qte: "+product.getQuantiteSelect());
        if(!found){
            products.add(prd);
        }else{
            products.remove(itm);
            products.add(prd);
        }
    }

    public void remove(Produit product) {
        products.remove(product);
    }

    public List<Produit> getProducts() {
        return products;
    }

    public void setProducts(List<Produit> products) {
        this.products = products;
    }
}
