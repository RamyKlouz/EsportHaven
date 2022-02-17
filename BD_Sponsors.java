/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd_sponsors;

import edu.esprit.crud.BudgetCRUD;
import edu.esprit.crud.SponsorsCRUD;
import edu.esprit.entities.Sponsors;
import edu.esprit.entities.budget;
import edu.esprit.utils.MyConnexion;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sk4nd
 */
public class BD_Sponsors {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    
        //try {
            MyConnexion mc = MyConnexion.getInstance();
            //MyConnexion mc2 = MyConnexion.getInstance();
            //System.out.println(mc.hashCode()+ " - " +mc2.hashCode());
            SponsorsCRUD pcd = new SponsorsCRUD();
            Sponsors Sp = new Sponsors(1,"Dupont","Julien",120,152);
            Sponsors Sp2 = new Sponsors(2,"Jerbi","Skander",150,189);
            pcd.modifierUser(Sp,Sp2);
            
            //pcd.SupprimerUser(Sp);
            //System.out.println(pcd.AfficherSponsor());
            //BudgetCRUD bd = new BudgetCRUD();
            //budget b = new budget(150,"Jeux");
            //bd.ajouterBudget();
                    //} catch (SQLException ex) {
            //Logger.getLogger(BD_Sponsors.class.getName()).log(Level.SEVERE, null, ex);
        //}
    }
    
}
