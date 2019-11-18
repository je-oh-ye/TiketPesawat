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
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author User
 */
public class HomeController implements Initializable {

    @FXML
    private Button btnSearch;
    @FXML
    private TextField txtForm;
    @FXML
    private TextField txtTo;
    @FXML
    private TextField txtAdult;
    @FXML
    private TextField txtChild;
    @FXML
    private TextField txtInfant;
    @FXML
    private DatePicker date;
    @FXML
    private ComboBox<?> comboboxClass;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void btnSearch(ActionEvent event) {
    }
    
}
