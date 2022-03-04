/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esports.entities;

import java.util.List;
import javafx.collections.ObservableList;

/**
 *
 * @author ASUS
 */
public interface IService <t>{
    void ajouter(t entity);
    void supprimer(int id);
    void modifier(t entity);
    List<t> afficher();
    Tournois retrieveTournoisByNom(String nom);
}
