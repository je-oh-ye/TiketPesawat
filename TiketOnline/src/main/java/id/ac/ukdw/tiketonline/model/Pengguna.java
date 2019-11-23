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
public class Pengguna {

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

    public int getId_pengguna() {
        return id_pengguna.get();
    }

  
    public void setId_pengguna(int id_pengguna) {
        this.id_pengguna = new SimpleIntegerProperty(id_pengguna);
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


    private SimpleIntegerProperty id_pengguna;
    private SimpleStringProperty username;
    private SimpleStringProperty password;
    private SimpleStringProperty email;
    
    public Pengguna(){
        
    }
    public Pengguna(int id_pengguna, String username, String password, String email){
        this.id_pengguna = new SimpleIntegerProperty(id_pengguna);
        this.username = new SimpleStringProperty(username);
        this.password = new SimpleStringProperty(password);
        this.email = new SimpleStringProperty(email);

    }
}



