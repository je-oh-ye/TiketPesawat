/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.ukdw.tiketonline;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class InvoiceController implements Initializable {

    @FXML
    private TextField berangkat;
    @FXML
    private TextField tiba;
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
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
