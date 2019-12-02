/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.ukdw.tiketonline;

import id.ac.ukdw.tiketonline.LoginController;
import id.ac.ukdw.tiketonline.db.DBUtil;
import id.ac.ukdw.tiketonline.db.PesawatDAO;
import id.ac.ukdw.tiketonline.db.PesawatDAO;
import id.ac.ukdw.tiketonline.model.Pesawat;
import id.ac.ukdw.tiketonline.model.Pesawat;
import java.net.URL;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class PesawatController extends HomeController {
    DBUtil db= new DBUtil();
    
    @FXML
    private TableView<Pesawat> tabelPesawat;
    @FXML
    private TableColumn<Pesawat, String> col_maskapai;
    @FXML
    private TableColumn<Pesawat, String> col_asal;
    @FXML
    private TableColumn<Pesawat, String> col_tujuan;
    @FXML
    private TableColumn<Pesawat, Integer> col_kursi;
    @FXML
    private TableColumn<Pesawat, String> col_class;
    @FXML
    private TableColumn<Pesawat, Integer> col_jam;
    @FXML
    private TableColumn<Pesawat, Integer> col_harga;
    

    public void searchTabel() throws SQLException, ClassNotFoundException{
        col_maskapai.setCellValueFactory(new PropertyValueFactory("maskapai"));
        col_asal.setCellValueFactory(new PropertyValueFactory("kota_asal"));
        col_tujuan.setCellValueFactory(new PropertyValueFactory("kota_tujuan"));
        col_kursi.setCellValueFactory(new PropertyValueFactory("jumlah_kursi"));
        col_class.setCellValueFactory(new PropertyValueFactory("kelas"));
        col_jam.setCellValueFactory(new PropertyValueFactory("jam_berangkat"));
        col_harga.setCellValueFactory(new PropertyValueFactory("harga"));
        
        ObservableList<Pesawat> data = FXCollections.observableArrayList();
        int i = 1;
        ResultSet rs1 = db.dbExecuteQuery("SELECT * from search WHERE id_pesawat = '"+i+"'");
        rs1.next();
        String asal1 = rs1.getString(2);
        String tujuan1 = rs1.getString(3);
        int kelas1 = rs1.getInt(7);
        String date1 =rs1.getString(6);
        i++;
        rs1.close();
        String sql = "SELECT * FROM pesawat WHERE kota_asal LIKE '%"+asal1+"%' AND '%"+tujuan1+"%' AND '%"+kelas1+"%' AND '%"+date1+"%'";
        try (ResultSet rs = db.dbExecuteQuery(sql)) {
            while (rs.next()) {
                Pesawat pesawat = new Pesawat();
                pesawat.setMaskapai(rs.getString("maskapai"));
                pesawat.setAsal(rs.getString("kota_asal")) ;
                pesawat.setTujuan(rs.getString("kota_tujuan"));
                pesawat.setJumlah(rs.getInt("jumlah_kursi"));
                pesawat.setKelas(rs.getString("kelas"));
                pesawat.setJam(rs.getInt("jam_berangkat"));
                pesawat.setHarga(rs.getInt("harga"));
                data.add(pesawat);
            }
            tabelPesawat.setItems(data);
        }

    }        
//        public void ShowTabel() throws SQLException, ClassNotFoundException{
//            this.SerachTabe();
//       
//    }
    @Override
    public void initialize(URL location, ResourceBundle resources) { 
        try {
            this.searchTabel();
        } catch (SQLException ex) {
            Logger.getLogger(PesawatController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PesawatController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
}
