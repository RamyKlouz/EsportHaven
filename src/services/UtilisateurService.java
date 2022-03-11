/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import utils.Datasource;
import entities.utilisateur;
import java.util.Base64.*;
import java.util.Properties;
import javax.mail.*;
import javax.activation.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


/**
 *
 * @author 21654
 */
public class UtilisateurService {
    private final Connection conn;
    private PreparedStatement pst;
    private Statement ste;

    public UtilisateurService() {
        conn = Datasource.getInstance().getCnx();
    }

    /**
     * @param p
     */

    public String ajouterPst(utilisateur p) {
        String req = "INSERT INTO `utilisateur` (`id`,`login`,`mdp`,`nom`, `prenom`,`email`,`num_tel`,`pays`,`role`,`etat`,`banne`) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
        String sql = "SELECT login from `utilisateur` where login = '" + p.getLogin() + "'";
        String sql1 = "SELECT login from `utilisateur` where email = '" + p.getEmail() + "'";
        String sql2 = "SELECT MAX(id) FROM `utilisateur`";
        String msg = "";


        try {
            pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            pst = conn.prepareStatement(sql1);
            ResultSet ns = pst.executeQuery();
            pst = conn.prepareStatement(sql2);
            ResultSet xs = pst.executeQuery();


            if (rs.next()) {
                System.out.println("cette login existe");
                msg = "cette login existe";
            } else if (ns.next()) {
                System.out.println("cette email existe deja");
                msg = "cette email existe deja";
            } else if (xs.next()) {
                int id1 = p.setId(xs.getInt(1));
                int id2 = id1 + 1;

                try {
                    pst = conn.prepareStatement(req);
                    ResultSet ms = pst.executeQuery();
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
                pst.setInt(1, id2);
                pst.setString(2, p.getLogin());
                pst.setString(3, p.getMdp());
                pst.setString(4, p.getNom());
                pst.setString(5, p.getPrenom());
                pst.setString(6, p.getEmail());
                pst.setInt(7, p.getNumtel());
                pst.setString(8, p.getPays());
                pst.setString(9, p.getRole());
                pst.setBoolean(10, p.getEtat());
                pst.setBoolean(11, p.isBanne());
                pst.executeUpdate();
                System.out.println("compte ajouter");
                String sql3 = "SELECT mdp from `utilisateur` WHERE id =" + id2;

                try {
                    pst = conn.prepareStatement(sql3);
                    ResultSet ss = pst.executeQuery();
                    if (ss.next()) {
                        String pw = p.setMdp(ss.getString(1));
                        String pwd = crypt(pw);
                        String sql4 = "UPDATE utilisateur SET mdp = '" + pwd + "' WHERE id =" + id2;
                        try {

                            pst = conn.prepareStatement(sql4);
                            pst.executeUpdate();

                        } catch (SQLException ex) {
                            System.out.println(ex.getMessage());
                        }
                    }
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());

                }

            }
        }
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return msg;
    }


    public String cration_compte(utilisateur p) {
        String req = "INSERT INTO `utilisateur` (`id`,`login`,`mdp`,`nom`, `prenom`,`email`,`num_tel`,`pays`,`role`,`etat`,`banne`) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
        String sql = "SELECT login from `utilisateur` where login = '" + p.getLogin() + "'";
        String sql1 = "SELECT login from `utilisateur` where email = '" + p.getEmail() + "'";
        String sql2 = "SELECT MAX(id) FROM `utilisateur`";
        String msg = "";
        String login = "";
        String email = "";


        try {
            pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            pst = conn.prepareStatement(sql1);
            ResultSet ns = pst.executeQuery();
            pst = conn.prepareStatement(sql2);
            ResultSet xs = pst.executeQuery();


            if (rs.next()) {
                System.out.println("cette login existe");
                msg = "cette login existe";
            } else if (ns.next()) {
                System.out.println("cette email existe deja");
                msg = "cette email existe deja";
            } else if (xs.next()) {
                int id1 = p.setId(xs.getInt(1));
                int id2 = id1 + 1;

                try {
                    pst = conn.prepareStatement(req);
                    ResultSet ms = pst.executeQuery();
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }

                pst.setInt(1, id2);
                pst.setString(2, p.getLogin());
                pst.setString(3, p.getMdp());
                pst.setString(4, p.getNom());
                pst.setString(5, p.getPrenom());
                pst.setString(6, p.getEmail());
                pst.setInt(7, p.getNumtel());
                pst.setString(8, p.getPays());
                pst.setString(9, p.getRole());
                pst.setBoolean(10, p.getEtat());
                pst.setBoolean(11, p.isBanne());
                pst.executeUpdate();
                System.out.println("compte cree");
                String sql5 = "SELECT mdp from `utilisateur` WHERE id =" + id2;
                try {
                    pst = conn.prepareStatement(sql5);
                    ResultSet ss = pst.executeQuery();
                    String pw = p.setMdp(ss.getString(2));
                    System.out.println(pw);
                }catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return msg;
    }


    public List<utilisateur> afficher() {
        List<utilisateur> utilisateurs = new ArrayList<>();

        String req = "SELECT id,login,nom,prenom,email,num_tel,pays,role,etat,banne from `utilisateur`";


        try {
            pst = conn.prepareStatement(req);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                utilisateur p = new utilisateur();
                p.setId(rs.getInt(1));
                p.setLogin(rs.getString(2));
                p.setNom(rs.getString(3));
                p.setPrenom(rs.getString(4));
                p.setEmail(rs.getString(5));
                p.setNumtel(rs.getInt(6));
                p.setPays(rs.getString(7));
                p.setRole(rs.getString(8));
                p.setEtat(rs.getBoolean(9));
                p.setBanne(rs.getBoolean(10));
                utilisateurs.add(p);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }


        return utilisateurs;
    }

    public int supprimer(int id) {

        String query = "DELETE FROM `utilisateur` WHERE id = " + id;
        String sql = "SELECT id from `utilisateur` WHERE id =" + id;
        int existe = 0;

        try {
            pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                try {
                    pst = conn.prepareStatement(query);
                    pst.executeUpdate();
                    System.out.println("suppression avec succes");
                    existe = 1;

                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }

            } else {
                System.out.println("cette id n'existe pas");
                existe = 0;

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }


        return existe;
    }

    public int modifier(String role, int id) {
        String sql = "UPDATE utilisateur SET role = '" + role + "' WHERE id =" + id;
        String sql1 = "SELECT id from `utilisateur` WHERE id =" + id;
        int existe = 0;
        try {
            pst = conn.prepareStatement(sql1);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                try {

                    pst = conn.prepareStatement(sql);
                    pst.executeUpdate();
                    System.out.println("role modifier");
                    existe = 1;
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            } else {
                System.out.println("verifier l'ID");
                existe = 0;
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return existe;
    }

    private static class utilistaeur {

        public utilistaeur() {
        }
    }

    public String authentifier(utilisateur p) {
        String sql = "select * from utilisateur WHERE  login = '" + p.getLogin() + "'";
        String sql1 = "select mdp from utilisateur WHERE  login ='" + p.getLogin() + "'";
        Boolean etat;
        String resultat = "";
        Boolean banne;


        //String sql1 = "SELECT etat FROM utilisateur";

        try {
            pst = conn.prepareStatement(sql);
            ResultSet ns = pst.executeQuery();


            if (ns.next()) {
                etat = ns.getBoolean(10);
                banne = ns.getBoolean(11);
                p.setId(ns.getInt(1));
                p.setLogin(ns.getString(2));
                p.setMdp(ns.getString(3));
                p.setNom(ns.getString(4));
                p.setPrenom(ns.getString(5));
                p.setEmail(ns.getString(6));
                p.setNumtel(ns.getInt(7));
                p.setPays(ns.getString(8));
                p.setRole(ns.getString(9));
                p.setEtat(ns.getBoolean(10));
                p.setBanne(ns.getBoolean(11));


                if (etat.equals(true)) {
                        System.out.println("Votre compte est desactiver ");
                        resultat = "Votre compte est desactiver ";
                    } else if (banne.equals(true)) {
                        System.out.println("Votre compte est banner ");
                        resultat = "Votre compte est banner ";
                    } else {
                        System.out.println("Connexion réussie !");
                        resultat = "Connexion réussie !";
                    }
                }else{
                System.out.println("Mot de passe incorrect !");
                resultat = "Login ou Mot de passe incorrect !";
            }
            } catch(SQLException ex){
            System.out.println(ex.getMessage());
        }

    return resultat;}

    public String crypt(String pw) {
        Encoder encoder = Base64.getEncoder();
        String encodedString = encoder.encodeToString(pw.getBytes(StandardCharsets.UTF_8));
        return encodedString;
    }
    public String decode(String pw) {

        Decoder decoder = Base64.getDecoder();
        byte[] bytes = decoder.decode(pw);
        String pwd = new String(bytes);
        System.out.println("decripter : " + new String(bytes));
        return pwd;

    }


    public int banned(int id) {
        String sql = "UPDATE utilisateur SET banne = TRUE WHERE id =" + id;
        String sql1 = "SELECT id from `utilisateur` WHERE id =" + id;
        int existe = 0;
        try {
            pst = conn.prepareStatement(sql1);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                try {
                    pst = conn.prepareStatement(sql);
                    pst.executeUpdate();
                    System.out.println("personne banner");
                    existe = 1;
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            } else {
                System.out.println("ID incorrecte");
                existe = 0;
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return existe;
    }

    public int debanner(int id) {
        String sql = "UPDATE utilisateur SET banne = FALSE WHERE id =" + id;
        String sql1 = "SELECT id from `utilisateur` WHERE id =" + id;
        int existe = 0;
        try {
            pst = conn.prepareStatement(sql1);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                try {
                    pst = conn.prepareStatement(sql);
                    pst.executeUpdate();
                    System.out.println("personne debanner");
                    existe = 1;
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            } else {
                System.out.println("ID incorrecte");
                existe = 0;
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return existe;
    }

    public void desactiver(int id) {
        String sql = "UPDATE utilisateur SET etat = TRUE WHERE id =" + id;

        try {

            pst = conn.prepareStatement(sql);
            pst.executeUpdate();
            System.out.println("votre compte a ete desactiver");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void reactiver(int id) {
        String sql = "UPDATE utilisateur SET etat = FALSE WHERE id =" + id;

        try {

            pst = conn.prepareStatement(sql);
            pst.executeUpdate();
            System.out.println("votre compte a ete reactiver");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void envoyer(String recepient) throws MessagingException {

        String host = "smtp.google.com";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        //Set TLS encryption enabled
        props.put("mail.smtp.starttls.enable", "true");
        //Set SMTP host
        props.put("mail.smtp.host", "smtp.gmail.com");
        //Set smtp port
        props.put("mail.smtp.port", "587");


        final String user = "bochkech.24@gmail.com";//change accordingly
        final String password = "eb3edzebiya5ra";//change accordingly


        String to = "ahmedbachir.mejri@esprit.tn";//change accordingly

        //Get the session object


        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(user, password);
            }
        });
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(user));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
            message.setSubject("javatpoint");
            message.setText("This is simple program of sending email using JavaMail API");
            message.saveChanges();
            Transport.send(message);
            System.out.println("message envoyé");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
    public void oubliemdp(String recepient) throws MessagingException {
         
String host = "smtp.google.com";
            Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        //Set TLS encryption enabled
        props.put("mail.smtp.starttls.enable", "true");
        //Set SMTP host
        props.put("mail.smtp.host", "smtp.gmail.com");
        //Set smtp port
        props.put("mail.smtp.port", "587");


        final String user = "bochkech.24@gmail.com";//change accordingly
        final String password = "eb3edzebiya5ra";//change accordingly


        String to = "ahmedbachir.mejri@esprit.tn";//change accordingly

        //Get the session object


        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(user, password);
            }
        });
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(user));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
            message.setSubject("Forget password");
            message.setText("This is ypur password : ");
            message.saveChanges();
            Transport.send(message);
            System.out.println("message envoyé");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    } 
        
    public String getpassword (String mdp)
    {
        utilisateur p = new utilisateur();
        String email = "ahmedbachir.mejri@esprit.tn";
        String sql = "Select * FROM utilisateur Where email = '" + email ;
        
        
        try {
            pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
         
            if(rs.next())
            {
                mdp = rs.getString(3);
            }
    }catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.print(mdp);
        return mdp;
}
}





