/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.ukdw.tiketonline;

import id.ac.ukdw.tiketonline.db.DBUtil;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class InvoiceController implements Initializable {
    DBUtil db = new DBUtil();
    private String nama_depan;
    private String code1;
    private int harga;
    private String kota_asal;
    private String kota_tujuan;
    private String jam_berangkat ;
    private String jam_tiba ;
    @FXML
    private TextField kotaAsal;
    @FXML
    private TextField kotaTujuan;
    @FXML
    private TextField jamAsal;
    @FXML
    private TextField jamTiba;
    @FXML
    private TextField harga1;
    @FXML
    private TextField namaPenumpang;

    /**
     * Initializes the controller class.
     */
   
    
    public void TampilkanPenumpang(String nama_depan) throws SQLException, ClassNotFoundException{
            namaPenumpang.setText(nama_depan);
        }

    public void TampilkanHarga(int harga, String kota_tujuan, String kota_asal, String jam_berangkat, String jam_tiba) throws SQLException, ClassNotFoundException{
            String harga2 = new StringBuilder().append(harga).toString(); 
            harga1.setText(harga2);
            kotaAsal.setText(kota_asal);
            kotaTujuan.setText(kota_tujuan);
            jamAsal.setText(jam_berangkat);
            jamTiba.setText(jam_tiba);
        }       
        
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
            this.TampilkanPenumpang(nama_depan);
            this.TampilkanHarga(harga, kota_tujuan, kota_asal, jam_berangkat, jam_tiba);
        } catch (SQLException ex) {
            Logger.getLogger(InvoiceController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(InvoiceController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
}
