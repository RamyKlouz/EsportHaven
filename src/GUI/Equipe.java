package GUI;

public class Equipe {
    private int id;
    private String nom ;
    private String nbrJoueur;


    public Equipe(int id, String nom, String nbrJoueur) {
        this.id = id;
        this.nom = nom;
        this.nbrJoueur = nbrJoueur;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNbrJoueur() {
        return nbrJoueur;
    }

    public void setNbrJoueur(String nbrJoueur) {
        this.nbrJoueur = nbrJoueur;
    }
}
