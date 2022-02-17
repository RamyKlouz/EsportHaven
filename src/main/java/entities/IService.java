/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.List;

/**
 *
 * @author 21654
 * @param <T>
 */
public interface IService<T> {
    void ajouter(T entity);
    void supprimer(T entity);
    void modifier(T entity);
    List<T> afficher();
    
}
