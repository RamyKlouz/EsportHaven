/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.entities;

/**
 *
 * @author sk4nd
 */
public class budget {
    
    public int ID_Budget;
    public int Montant;
    public String Activite;

    public budget() {
    }

    public budget(int ID_Budget, int Montant, String Activite) {
        this.ID_Budget = ID_Budget;
        this.Montant = Montant;
        this.Activite = Activite;
    }

    public budget(int Montant, String Activite) {
        this.Montant = Montant;
        this.Activite = Activite;
    }

    public int getID_Budget() {
        return ID_Budget;
    }

    public void setID_Budget(int ID_Budget) {
        this.ID_Budget = ID_Budget;
    }

    public int getMontant() {
        return Montant;
    }

    public void setMontant(int Montant) {
        this.Montant = Montant;
    }

    public String getActivite() {
        return Activite;
    }

    public void setActivite(String Activite) {
        this.Activite = Activite;
    }

    @Override
    public String toString() {
        return "budget{" + "ID_Budget=" + ID_Budget + ", Montant=" + Montant + ", Activite=" + Activite + '}';
    }
    
}
