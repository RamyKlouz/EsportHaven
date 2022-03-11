package GUI;

import java.util.Date;

public class Joueur {
    private int id;
    private String name;
    private String lastname;
    private String email;
    private String number;
    private String gender;
    private int phone;
    private String birthday;

    public Joueur(){

}

    public Joueur(int id, String name, String lastname, String email, String password, String gender, int phone, String birthday) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.number = password;
        this.gender = gender;
        this.phone = phone;
        this.birthday = birthday;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return number;
    }

    public void setPassword(String password) {
        this.number = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
}
