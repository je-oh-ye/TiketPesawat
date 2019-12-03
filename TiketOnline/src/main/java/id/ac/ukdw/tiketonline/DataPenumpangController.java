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
    DBUtil db= new DBUtil();
    private int harga;
    private String asal1 ;
    private String tujuan1 ;
    private String tanggal1;
    private String kelas1 ;
    private String kota_asal ;
    private String kota_tujuan ;
    private String jam_berangkat ;
    private String jam_tiba ;
        
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
     ObservableList<String> data = FXCollections.observableArrayList("TUAN","NYONYA");
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        title.getItems().addAll("TUAN","NYONYA");
        title.getSelectionModel().select(" ");
    }    

    @FXML
    private void heandleback(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/Pesawat.fxml"));
        Parent Regis = loader.load();
        Scene scene = new Scene(Regis);
        Stage Primarystage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        Primarystage.setResizable(false);
        Primarystage.setScene(scene);
        Primarystage.show();
    }
     public void setHarga(int harga, String kota_tujuan, String kota_asal, String jam_berangkat, String jam_tiba){
        this.harga = harga;
        this.kota_tujuan = kota_tujuan;
        this.kota_asal = kota_asal;
        this.jam_berangkat = jam_berangkat;
        this.jam_tiba = jam_tiba;
    }
    @FXML
    private void hendleContinue(ActionEvent event) throws SQLException, ClassNotFoundException, IOException {
        DBUtil db = new DBUtil();
        String title1 = title.getValue();
        String nama_depan = namaDepan.getText();//isi id yang di fxml .getText
        String nama_belakang = namaBelakang.getText();//isi id yang di fxml .getText 
        String nktp = nKTP.getText();//isi id yang di fxml .getText 
        String query2 = "INSERT INTO detail_penumpang (title, nama_depan, nama_belakang, ktp) VALUES ('"+title1+"', '"+nama_depan+"', '"+nama_belakang+"', '"+nktp+"') ";
        try{
            db.dbExecuteUpdate(query2);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Register Success");
            alert.setHeaderText("Register Success");
            alert.showAndWait();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/fxml/Pembayaran.fxml"));
            Parent Regis = loader.load();
            PembayaranController control = loader.getController();
            control.setNama(nama_depan);
            control.setHarga(harga, kota_tujuan, kota_asal, jam_berangkat, jam_tiba);
            Scene scene = new Scene(Regis);
            Stage Primarystage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            Primarystage.setResizable(false);
            Primarystage.setScene(scene);
            Primarystage.show();
//            statement.close();
        }
        catch(SQLException e){
           Logger.getLogger(PesawatController.class.getName()).log(Level.SEVERE, null, e);
        }
       
    }
    
}
