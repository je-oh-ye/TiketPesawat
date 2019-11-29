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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class PesawatController implements Initializable {
    DBUtil db= new DBUtil();
    private String asal ; 
    private String tujuan ;
    private String adult ;
    private String infant;
    private String child ;
    private LocalDate date1 ;
    private String kelas ;
    
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

    public void SerchTabel() throws SQLException, ClassNotFoundException{
        col_maskapai.setCellValueFactory(new PropertyValueFactory("maskapai"));
        col_asal.setCellValueFactory(new PropertyValueFactory("kota_asal"));
        col_tujuan.setCellValueFactory(new PropertyValueFactory("kota_tujuan"));
        col_kursi.setCellValueFactory(new PropertyValueFactory("jumlah_kursi"));
        col_class.setCellValueFactory(new PropertyValueFactory("class"));
        col_jam.setCellValueFactory(new PropertyValueFactory("jam_berangkat"));
        col_harga.setCellValueFactory(new PropertyValueFactory("harga"));
        
         ObservableList<Pesawat> data = FXCollections.observableArrayList();
        String asal1 = asal;
        String tujuan1 = tujuan;
        String kelas1 = kelas;
        LocalDate tanggal = date1;
        String sql = "SELECT * FROM pesawat WHERE kota_asal LIKE '%"+asal1+"%' AND '%"+tujuan1+"%' AND '%"+kelas1+"%' AND '%"+tanggal+"%'";
        ResultSet rs =db.dbExecuteQuery(sql);
           while (rs.next()) {
            Pesawat pesawat = new Pesawat();
            pesawat.setMaskapai(rs.getString("maskapai"));
            pesawat.setAsal(rs.getString("kota_asal")) ;
            pesawat.setTujuan(rs.getString("kota_tujuan"));
            pesawat.setJumlah(rs.getInt("jumlah_kursi"));
            pesawat.setKelas(rs.getString("class"));
            pesawat.setJam(rs.getInt("jam_berangkat"));
            pesawat.setHarga(rs.getInt("harga"));
            data.add(pesawat);
        }
        tabelPesawat.setItems(data);
        rs.close();

    }        
        public void ShowTabel(){
        col_maskapai.setCellValueFactory(new PropertyValueFactory("maskapai"));
        col_asal.setCellValueFactory(new PropertyValueFactory("kota_asal"));
        col_tujuan.setCellValueFactory(new PropertyValueFactory("kota_tujuan"));
        col_kursi.setCellValueFactory(new PropertyValueFactory("jumlah_kursi"));
        col_class.setCellValueFactory(new PropertyValueFactory("class"));
        col_jam.setCellValueFactory(new PropertyValueFactory("jam_berangkat"));
        col_harga.setCellValueFactory(new PropertyValueFactory("harga"));
        
        ObservableList<Pesawat> data;
        try {
            
            data = PesawatDAO.searchPesawat();
            
            tabelPesawat.setItems(data);
            
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) { 
            // TODO
            this.ShowTabel();
        
    }
}    
