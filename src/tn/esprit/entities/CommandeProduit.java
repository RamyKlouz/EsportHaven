/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tn.esprit.entities;

/**
 *
 * @author ramyc
 */
public class CommandeProduit {
    private int cpID;
    private int productID; 
    private int orderID;
    private int quantite;
    private int sommePrix;

    public CommandeProduit() {
    }

    public CommandeProduit(int productID, int orderID, int quantite, int sommePrix) {
        this.productID = productID;
        this.orderID = orderID;
        this.quantite = quantite;
        this.sommePrix = sommePrix;
    }

    public CommandeProduit(int cpID, int productID, int orderID, int quantite, int sommePrix) {
        this.cpID = cpID;
        this.productID = productID;
        this.orderID = orderID;
        this.quantite = quantite;
        this.sommePrix = sommePrix;
    }

    public int getCpID() {
        return cpID;
    }

    public void setCpID(int cpID) {
        this.cpID = cpID;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public int getSommePrix() {
        return sommePrix;
    }

    public void setSommePrix(int sommePrix) {
        this.sommePrix = sommePrix;
    }

    @Override
    public String toString() {
        return "CommandeProduit{" + "cpID=" + cpID + ", productID="
                + productID + ", orderID=" + orderID + ", quantite="
                + quantite + ", sommePrix=" + sommePrix + '}';
    }
    
    
    
    
    
    
}
