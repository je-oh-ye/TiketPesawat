/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.ukdw.tiketonline.model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author asus
 */
public class User {

    /**
     * @return the email
     */
    public String getEmail() {
        return email.get();
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = new SimpleStringProperty(email);
    }

    /**
     * @return the berat
     */
    public int getBerat() {
        return berat.get();
    }

    /**
     * @param berat the berat to set
     */
    public void setBerat(int berat) {
        this.berat = new SimpleIntegerProperty(berat);
    }

    public int getId_user() {
        return id_user.get();
    }

  
    public void setId_user(int id_user) {
        this.id_user = new SimpleIntegerProperty(id_user);
    }

    public String getUsername() {
        return username.get();
    }

  
    public void setUsername(String username) {
        this.username = new SimpleStringProperty(username);
    }

    
    public String getPassword() {
        return password.get();
    }

  
    public void setPassword(String password) {
        this.password = new SimpleStringProperty(password);
    }


    private SimpleIntegerProperty id_user;
    private SimpleStringProperty username;
    private SimpleStringProperty password;
    private SimpleStringProperty email;
    private SimpleIntegerProperty berat;
    
    public User(){
        
    }
    public User(int id_user, String username, String password, String email, int berat){
        this.id_user = new SimpleIntegerProperty(id_user);
        this.username = new SimpleStringProperty(username);
        this.password = new SimpleStringProperty(password);
        this.email = new SimpleStringProperty(email);
        this.berat = new SimpleIntegerProperty(berat);
    }
}



