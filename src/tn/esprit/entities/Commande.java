/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tn.esprit.entities;

/**
 *
 * @author PDG
 */
public class Commande {
    private int orderID;
    private String client; 
    private int productID;
    private int quantite;

    public Commande(int orderID, String client, int productID, int quantite) {
        this.orderID = orderID;
        this.client = client;
        this.productID = productID;
        this.quantite = quantite;
        
        
    }

    public Commande() {
    }

    public Commande(String client, int productID, int quantite) {
        this.client = client;
        this.productID = productID;
        this.quantite = quantite;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    @Override
    public String toString() {
        return "Commande{" + "orderID=" + orderID + ", client=" + client + ", productID=" + productID + ", quantite=" + quantite + '}';
    }

   



}
