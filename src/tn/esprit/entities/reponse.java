/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.entities;

/**
 *
 * @author waela
 */
public class reponse {
    private int idr ;
    private String content;

    public reponse(int idr, String content) {
        this.idr = idr;
        this.content = content;
    }
    public reponse() {
    }

    public int getIdr() {
        return idr;
    }

    public void setIdr(int idr) {
        this.idr = idr;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
<<<<<<< HEAD

    public String getDescription() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
=======
>>>>>>> 2369386a953b614a7e7a1b661b6d06aa78c263ca
    
    
}
