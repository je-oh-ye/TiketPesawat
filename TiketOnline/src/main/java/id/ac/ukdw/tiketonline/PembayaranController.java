/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.ukdw.tiketonline;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
public class PembayaranController implements Initializable {

    @FXML
    private Button back;
    @FXML
    private ComboBox<String> miniMarket;
    @FXML
    private ComboBox<String> bank;
    @FXML
    private Button bayar;
    @FXML
    private TextField Asal;
    @FXML
    private TextField tujuan;

    /**
     * Initializes the controller class.
     */
    ObservableList<String> mini = FXCollections.observableArrayList("INDOMARET","ALFAMART");
    ObservableList<String> data = FXCollections.observableArrayList("BRI","BNI","MANDIRI","MANDIRI SYARIAH","BCA","BANK LAIN");
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        miniMarket.getItems().addAll("INDOMARET","ALFAMART");
        miniMarket.getSelectionModel().select("Mini Market");
        
        bank.getItems().addAll("BRI","BNI","MANDIRI","MANDIRI SYARIAH","BCA","BANK LAIN");
        bank.getSelectionModel().select("Bank");
    }    

    @FXML
    private void heandleback(ActionEvent event) {
    }

    @FXML
    private void hendleBayar(ActionEvent event) {
    }
    
}
