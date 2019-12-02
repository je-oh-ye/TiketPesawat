/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.ukdw.tiketonline;

import id.ac.ukdw.tiketonline.db.DBUtil;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author User
 */
public class HomeController implements Initializable {
    DBUtil db= new DBUtil();
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
    private ComboBox<String> comboboxClass;
    @FXML
    private Button btnLogout1;

    @FXML
    void btnLogout(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/Login.fxml"));
        Parent Home = loader.load();
        Scene scene = new Scene(Home);
        Stage Primarystage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        Primarystage.setResizable(false);
        Primarystage.setScene(scene);
        Primarystage.show();
    }

    /**
     * Initializes the controller class.
     */
    ObservableList<String> data = FXCollections.observableArrayList("ECONOMY","BUSINEES");
    @Override
    public void initialize(URL location, ResourceBundle rb) {
    comboboxClass.getItems().addAll("ECONOMY","BUSINEES");
        comboboxClass.getSelectionModel().select("ECONOMY");
          
    }
     

    @FXML
    private void btnSearch(ActionEvent event) throws IOException, SQLException, ClassNotFoundException {
        String asal = txtForm.getText();//isi id yang di fxml .getText
        String tujuan = txtTo.getText();//isi id yang di fxml .getText 
        String adult = txtAdult.getText();//isi id yang di fxml .getText
        String infant = txtInfant.getText();//isi id yang di fxml .getText
        String child = txtChild.getText();//isi id yang di fxml .getText 
        LocalDate date1 = date.getValue();
        String kelas = comboboxClass.getValue();
        String query = "INSERT INTO search (asal1, tujuan1, adult1, infant1, child1, date1, kelas1) VALUES ('"+asal+"','"+tujuan+"','"+adult+"','"+infant+"','"+child+"','"+date1+"','"+kelas+"') ";
        db.dbExecuteUpdate(query);
         if(asal.isEmpty() || tujuan.isEmpty() || adult.isEmpty() && infant.isEmpty() && child.isEmpty()){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("SEARCH FAILED");
                alert.setHeaderText("SEARCH FAILED !");
                alert.setContentText("Empty Field");
                alert.showAndWait();
         }
         else{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/Pesawat.fxml"));
        Parent Regis = loader.load();
        Scene scene = new Scene(Regis);
        Stage Primarystage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        Primarystage.setResizable(false);
        Primarystage.setScene(scene);
        Primarystage.show();
        }
    }
    
}
