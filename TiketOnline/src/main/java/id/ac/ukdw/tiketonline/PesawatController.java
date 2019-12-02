/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.ukdw.tiketonline;

import id.ac.ukdw.tiketonline.db.DBUtil;
import id.ac.ukdw.tiketonline.db.PesawatDAO;
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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
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
    private String asal1 ;
    private String tujuan1 ;
    private String tanggal1;
    private String kelas1 ;
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
    @FXML
    private Button btnPilih;

    
    @FXML
    public void btnPilih(ActionEvent event){
//        String query = "INSERT INTO 'detail' ('')"
        
    }
    
    @FXML
    void handleback(ActionEvent event) {

    }   
    
//    public void SearcTable() throws SQLException, ClassNotFoundException{
//        int i = 1;
<<<<<<< HEAD
//         String queryStmt  = "SELECT * FROM search WHERE id_search = '"+i+"'";
//        ResultSet rs = db.dbExecuteQuery(queryStmt);
//        rs.next();
//        String asal1 = rs.getString("asal1");
//        String tujuan1= rs.getString("tujuan1") ;
//        String tanggal1= rs.getString("date1");
//        String kelas1 = rs.getString("kelas1");
//        i++;
//       rs.close();
//       
//    }
//    public void ShowTable() throws SQLException, ClassNotFoundException {
//        col_maskapai.setCellValueFactory(new PropertyValueFactory("maskapai"));
//        col_asal.setCellValueFactory(new PropertyValueFactory("kota_asal"));
//        col_tujuan.setCellValueFactory(new PropertyValueFactory("kota_tujuan"));
//        col_kursi.setCellValueFactory(new PropertyValueFactory("jumlah_kursi"));
//        col_class.setCellValueFactory(new PropertyValueFactory("kelas"));
//        col_jam.setCellValueFactory(new PropertyValueFactory("jam_berangkat"));
//        col_harga.setCellValueFactory(new PropertyValueFactory("harga"));
//        ObservableList<Pesawat> data = FXCollections.observableArrayList();
//        String sql = "SELECT * FROM pesawat WHERE kota_asal LIKE '%"+asal1+"%' AND kota_tujuan LIKE '%"+tujuan1+"%' AND tanggal LIKE '%"+tanggal1+"%' AND kelas LIKE '%"+kelas1+"%'";
//        ResultSet rs1 = db.dbExecuteQuery(sql);
//        try {
//            while(rs1.next()){
//            Pesawat pesawat = new Pesawat();
//            pesawat.setId_pesawat(rs1.getInt("id_pesawat"));
//            pesawat.setMaskapai(rs1.getString("maskapai"));
//            pesawat.setKota_asal(rs1.getString("kota_asal"));
//            pesawat.setKota_tujuan(rs1.getString("kota_tujuan"));
//            pesawat.setJumlah_kursi(rs1.getInt("jumlah_kursi"));
//            pesawat.setTanggal(rs1.getString("tanggal"));
//            pesawat.setKelas(rs1.getString("kelas"));
//            pesawat.setJam_berangkat(rs1.getString("jam_berangkat"));
//            pesawat.setHarga(rs1.getInt("harga"));
//        
//            data.add(pesawat);
//            }
//                tabelPesawat.setItems(data);
//           rs1.close();
//        } catch (SQLException ex) {
//            Logger.getLogger(PesawatController.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    
//    }
    
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {    
         col_maskapai.setCellValueFactory(new PropertyValueFactory("maskapai"));
        col_asal.setCellValueFactory(new PropertyValueFactory("kota_asal"));
        col_tujuan.setCellValueFactory(new PropertyValueFactory("kota_tujuan"));
        col_kursi.setCellValueFactory(new PropertyValueFactory("jumlah_kursi"));
        col_class.setCellValueFactory(new PropertyValueFactory("kelas"));
        col_jam.setCellValueFactory(new PropertyValueFactory("jam_berangkat"));
        col_harga.setCellValueFactory(new PropertyValueFactory("harga"));
        
         ObservableList<Pesawat> data ;
           try {
   
            data = PesawatDAO.searchPesawat();
            tabelPesawat.setItems(data);
//            ShowTable();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }


   }
}
=======
//        String sql = "SELECT * FROM search WHERE id_search = '"+i+"'";
//        ResultSet rs = db.dbExecuteQuery(sql);
//        while(rs.next()){
//        String asal1 = rs.getString(2);
//        String tujuan1= rs.getString(3) ;
//        String tanggal1= rs.getString(7);
//        String kelas1 = rs.getString(8);
//        i++;
//        }
//        rs.close();
//       
//    }
    public void ShowTable() throws SQLException, ClassNotFoundException {
        col_maskapai.setCellValueFactory(new PropertyValueFactory("maskapai"));
        col_asal.setCellValueFactory(new PropertyValueFactory("kota_asal"));
        col_tujuan.setCellValueFactory(new PropertyValueFactory("kota_tujuan"));
        col_kursi.setCellValueFactory(new PropertyValueFactory("jumlah_kursi"));
        col_class.setCellValueFactory(new PropertyValueFactory("kelas"));
        col_jam.setCellValueFactory(new PropertyValueFactory("jam_berangkat"));
        col_harga.setCellValueFactory(new PropertyValueFactory("harga"));
        
        ObservableList<Pesawat> data = FXCollections.observableArrayList();
        String sql = "SELECT * FROM pesawat WHERE kota_asal LIKE '%"+asal1+"%' AND kota_tujuan LIKE '%"+tujuan1+"%' AND tanggal LIKE '%"+tanggal1+"%' AND kelas LIKE '%"+kelas1+"%'";
        ResultSet rs1 = db.dbExecuteQuery(sql);
        try {
            while(rs1.next()){
            Pesawat pesawat = new Pesawat();
            pesawat.setId_pesawat(rs1.getInt("id_pesawat"));
            pesawat.setMaskapai(rs1.getString("maskapai"));
            pesawat.setKota_asal(rs1.getString("kota_asal"));
            pesawat.setKota_tujuan(rs1.getString("kota_tujuan"));
            pesawat.setJumlah_kursi(rs1.getInt("jumlah_kursi"));
            pesawat.setTanggal(rs1.getString("tanggal"));
            pesawat.setKelas(rs1.getString("kelas"));
            pesawat.setJam_berangkat(rs1.getString("jam_berangkat"));
            pesawat.setHarga(rs1.getInt("harga"));
        
            data.add(pesawat);
            }
                tabelPesawat.setItems(data);
           rs1.close();
        } catch (SQLException ex) {
            Logger.getLogger(PesawatController.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {    
        col_maskapai.setCellValueFactory(new PropertyValueFactory("maskapai"));
        col_asal.setCellValueFactory(new PropertyValueFactory("kota_asal"));
        col_tujuan.setCellValueFactory(new PropertyValueFactory("kota_tujuan"));
        col_kursi.setCellValueFactory(new PropertyValueFactory("jumlah_kursi"));
        col_class.setCellValueFactory(new PropertyValueFactory("kelas"));
        col_jam.setCellValueFactory(new PropertyValueFactory("jam_berangkat"));
        col_harga.setCellValueFactory(new PropertyValueFactory("harga"));
        
         ObservableList<Pesawat> data ;
           try {
   
            data = PesawatDAO.searchPesawat();
            tabelPesawat.setItems(data);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
//        ShowTable();
//        } catch (SQLException ex) {
//            Logger.getLogger(PesawatController.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(PesawatController.class.getName()).log(Level.SEVERE, null, ex);
//        }
        }
   }
>>>>>>> 1f7c968ca557987349a067ef06925f809f6c30ba
