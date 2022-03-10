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


    public Commande(int orderID, String client) {
        this.orderID = orderID;
        this.client = client;

        
        
    }

    public Commande() {
    }

    public Commande(String client) {
        this.client = client;

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

    
    @Override
    public String toString() {
        return "Commande{" + "orderID=" + orderID + ", client=" + client + '}';
    }

   



}
