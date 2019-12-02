/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.ukdw.tiketonline;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class DataPenumpangController implements Initializable {

    @FXML
    private Button back;
    @FXML
    private TextField namaDepan;
    @FXML
    private TextField namaBelakang;
    @FXML
    private TextField email;
    @FXML
    private TextField nKTP;
    @FXML
    private ComboBox<?> title;
    @FXML
    private Button next;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void heandleback(ActionEvent event) {
    }

    @FXML
    private void hendleContinue(ActionEvent event) {
    }
    
}
