/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.ukdw.tiketonline;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class UserController implements Initializable {
    private final String username;
	private final String password;
	private final String email;
	private final String nama_Lengkap;
	private final String jenis_Kelamin;
	private final String tanggal_Lahir;
	private final String noTelepon;

	public UserController(String username, String email, String password, String nama_Lengkap, 
				String jenis_Kelamin, String tanggal_Lahir, 
				String noTelepon){
		this.username = username;
		this.email = email;
		this.nama_Lengkap = nama_Lengkap;
		this.noTelepon = noTelepon;
		this.jenis_Kelamin = jenis_Kelamin;
		this.tanggal_Lahir = tanggal_Lahir;
		this.password = password;
	}

	public String getUsername(){
		return this.username;
	}

	public String getEmail(){
		return this.email;
	}

	public String getPassword(){
		return this.password;
	}

	public String getNama_Lengkap(){
		return this.nama_Lengkap;
	}

	public String getJenis_Kelamin(){
		return this.jenis_Kelamin;
	}

	public String getTanggal_Lahir(){
		return this.tanggal_Lahir;
	}
 
	public String getNoTelepon(){
		return this.noTelepon;
	}
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
