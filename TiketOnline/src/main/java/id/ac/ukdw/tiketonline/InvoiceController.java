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
    String nama_depan;
    String code1;
    
    @FXML
    private TextField kotaAsal;
    @FXML
    private TextField kotaTujuan;
    @FXML
    private TextField bandaraAsal;
    @FXML
    private TextField bandaraTiba;
    @FXML
    private TextField code;
    @FXML
    private TextField namaPenumpang;

    /**
     * Initializes the controller class.
     */
   
    
    public void TampilkanPenumpang(String nama_depan) throws SQLException, ClassNotFoundException{
            namaPenumpang.setText(nama_depan);
        }

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
            this.TampilkanPenumpang(nama_depan);
        } catch (SQLException ex) {
            Logger.getLogger(InvoiceController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(InvoiceController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
}
