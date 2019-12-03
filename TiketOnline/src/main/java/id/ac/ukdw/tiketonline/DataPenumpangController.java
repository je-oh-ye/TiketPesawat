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
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class DataPenumpangController implements Initializable {

    DBUtil db = new DBUtil();
    private String asal1;
    private String tujuan1;
    private String tanggal1;
    private String kelas1;
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
    private ComboBox<String> title;
    @FXML
    private Button next;

    /**
     * Initializes the controller class.
     */
    ObservableList<String> data = FXCollections.observableArrayList("TUAN", "NYONYA");

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        title.getItems().addAll("TUAN", "NYONYA");
        title.getSelectionModel().select(" ");
    }

    @FXML
    private void heandleback(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/Pesawat.fxml"));
        Parent Regis = loader.load();
        Scene scene = new Scene(Regis);
        Stage Primarystage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Primarystage.setResizable(false);
        Primarystage.setScene(scene);
        Primarystage.show();
    }

    @FXML
    private void hendleContinue(ActionEvent event) throws SQLException, ClassNotFoundException, IOException {
        DBUtil db = new DBUtil();
        String Title = title.getValue();
        String nama_depan = namaDepan.getText();//isi id yang di fxml .getText
        String nama_belakang = namaBelakang.getText();//isi id yang di fxml .getText 
        String query2 = "INSERT INTO detail_penumpang (title, nama_depan, nama_belakang) VALUES ('" + Title + "', '" + nama_depan + "', '" + nama_belakang + "') ";
        try {
            db.dbExecuteUpdate(query2);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Register Success");
            alert.setHeaderText("Register Success");
            alert.showAndWait();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/fxml/pembayaran.fxml"));
            Parent Regis = loader.load();
            Scene scene = new Scene(Regis);
            Stage Primarystage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Primarystage.setResizable(false);
            Primarystage.setScene(scene);
            Primarystage.show();
//          statement.close();
        } catch (SQLException e) {
            Logger.getLogger(PesawatController.class.getName()).log(Level.SEVERE, null, e);
        }

    }

}
