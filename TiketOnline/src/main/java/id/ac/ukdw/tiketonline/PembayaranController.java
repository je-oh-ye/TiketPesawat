/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.ukdw.tiketonline;

import id.ac.ukdw.tiketonline.db.DBUtil;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
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
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class PembayaranController implements Initializable {
    DBUtil db= new DBUtil();
    private String nama_depan;
    private int harga;
    private String kota_asal;
    private String kota_tujuan;
    private String jam_berangkat ;
    private String jam_tiba ;

    @FXML
    private Button back;
    @FXML
    private ComboBox<String> miniMarket;
    @FXML
    private ComboBox<String> bank;
    @FXML
    private Button bayar;
    @FXML
    private TextField txtAsal;
    @FXML
    private TextField txtTujuan;

    /**
     * Initializes the controller class.
     */
    
       public void Tampilkan() throws SQLException, ClassNotFoundException{
            String queryStmt = "SELECT * from detail_pesawat ";
            ResultSet rs = db.dbExecuteQuery(queryStmt);
            rs.next();
            txtAsal.setText(rs.getString("asal"));
            txtTujuan.setText(rs.getString("tujuan"));
            rs.close();
        }
    
    ObservableList<String> mini = FXCollections.observableArrayList("INDOMARET","ALFAMART");
    ObservableList<String> data = FXCollections.observableArrayList("BRI","BNI","MANDIRI","MANDIRI SYARIAH","BCA","BANK LAIN");
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
            this.Tampilkan();
        } catch (SQLException ex) {
            Logger.getLogger(PembayaranController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PembayaranController.class.getName()).log(Level.SEVERE, null, ex);
        }
        miniMarket.getItems().addAll("INDOMARET","ALFAMART");
        miniMarket.getSelectionModel().select("Mini Market");
        
        bank.getItems().addAll("BRI","BNI","MANDIRI","MANDIRI SYARIAH","BCA","BANK LAIN");
        bank.getSelectionModel().select("Bank");
    }
    

    @FXML
    private void heandleback(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/DataPenumpang.fxml"));
        Parent Regis = loader.load();
        Scene scene = new Scene(Regis);
        Stage Primarystage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        Primarystage.setResizable(false);
        Primarystage.setScene(scene);
        Primarystage.show();
    }

    @FXML
    private void hendleBayar(ActionEvent event) throws IOException, SQLException, ClassNotFoundException {
        String bayar = miniMarket.getValue();
        String bayar1 = bank.getValue();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/Invoice.fxml"));
        Parent Regis = loader.load();
        InvoiceController control = loader.getController();
        control.TampilkanPenumpang(nama_depan);
        control.TampilkanHarga(harga, kota_tujuan, kota_asal, jam_berangkat, jam_tiba);
        Scene scene = new Scene(Regis);
        Stage Primarystage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        Primarystage.setResizable(false);
        Primarystage.setScene(scene);
        Primarystage.show();
    }
    public void setNama(String nama_depan){
        this.nama_depan = nama_depan;
    }
     public void setHarga(int harga, String kota_tujuan, String kota_asal, String jam_berangkat, String jam_tiba){
        this.harga = harga;
        this.kota_tujuan = kota_tujuan;
        this.kota_asal = kota_asal;
        this.jam_berangkat = jam_berangkat;
        this.jam_tiba = jam_tiba;
    }
}
