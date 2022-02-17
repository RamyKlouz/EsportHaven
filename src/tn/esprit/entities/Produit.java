/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tn.esprit.entities;

/**
 *
 * @author remo
 */
public class Produit {
    private int productID;
    private String nom; 
    private String type;
    private String marque;
    private int quantite;

    public Produit(int productID, String nom, String type,String marque, int quantite) {
        this.productID = productID;
        this.nom = nom;
        this.type = type;
        this.marque = marque;
        this.quantite = quantite;
    }

    public Produit() {
    }

    public Produit(String nom, String type) {
        this.nom = nom;
        this.type = type;
    }

    public Produit(String nom, String marque, String type, int quantite) {
        this.nom = nom;
        this.marque = marque;
        this.type = type;
        this.quantite = quantite;
    }
    
    public int getId() {
        return productID;
    }

    public void setId(int productID) {
        this.productID = productID;
    }

    @Override
    public String toString() {
        return "Produit{" + "id=" + productID + ", nom=" + nom +
                ", type=" + type + ", marque=" + marque + ", quantite=" + quantite + '}';
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public String getMarque() {
        return marque;
    }

    public int getQuantite() {
        return quantite;
    }
    
    
}
