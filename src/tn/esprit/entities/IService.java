/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package tn.esprit.entities;

import java.util.List;

/**
 *
 * @author remo
 */
public interface IService<T> {
    
    void ajouter(T entity);
    void supprimer(int entity);
    void modifier(T entity, int i);
    List<T> afficher();
    
}
