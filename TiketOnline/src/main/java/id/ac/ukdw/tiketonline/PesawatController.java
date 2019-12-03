/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.ukdw.tiketonline;

import id.ac.ukdw.tiketonline.db.DBUtil;
import id.ac.ukdw.tiketonline.model.Pesawat;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javax.swing.JOptionPane;


/**
 * FXML Controller class
 *
 * @author asus
 */
public class PesawatController implements Initializable {
    DBUtil db= new DBUtil();
    private String asal ;
    private String tujuan ;
    private String tanggal;
    private String kelas ;
    private int harga ;
    
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
    private Button btnCari;
    
    @FXML
    public void btnPilih(ActionEvent event) throws ClassNotFoundException, IOException{
        try{
        String query = "INSERT INTO detail_pesawat (maskapai, asal, tujuan, kelas ,jam_berangkat,harga) VALUES ('"+tabelPesawat.getSelectionModel().getSelectedItem().getMaskapai()+"',"
                + "                                                                            '"+tabelPesawat.getSelectionModel().getSelectedItem().getKota_asal()+"',"
                                                                                             +"'"+tabelPesawat.getSelectionModel().getSelectedItem().getKota_tujuan()+"',"
                + "                                                                             '"+tabelPesawat.getSelectionModel().getSelectedItem().getKelas()+"',"
                + "                                                                                '"+tabelPesawat.getSelectionModel().getSelectedItem().getJam_berangkat()+"',"
                + "                                                                                 '"+tabelPesawat.getSelectionModel().getSelectedItem().getHarga()+"') ";
            db.dbExecuteUpdate(query);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("SUCCESS");
            alert.setHeaderText("SUCCESS");
            alert.showAndWait();
        }catch(SQLException e){
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "ADD FAILED");
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, e);
    //      e.printStackTrace();
            
        }
        harga = tabelPesawat.getSelectionModel().getSelectedItem().getHarga();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/DataPenumpang.fxml"));
        Parent Regis = loader.load();
        DataPenumpangController control = loader.getController();
        control.setHarga(harga);
        Scene scene = new Scene(Regis);
        Stage Primarystage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        Primarystage.setResizable(false);
        Primarystage.setScene(scene);
        Primarystage.show();
    }

    @FXML
    void handleback(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/Home.fxml"));
        Parent Regis = loader.load();
        Scene scene = new Scene(Regis);
        Stage Primarystage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        Primarystage.setResizable(false);
        Primarystage.setScene(scene);
        Primarystage.show();
    }   
 
    

    public void ShowTable(String asal, String tujuan, String kelas) throws SQLException, ClassNotFoundException {
        col_maskapai.setCellValueFactory(new PropertyValueFactory("maskapai"));
        col_asal.setCellValueFactory(new PropertyValueFactory("kota_asal"));
        col_tujuan.setCellValueFactory(new PropertyValueFactory("kota_tujuan"));
        col_kursi.setCellValueFactory(new PropertyValueFactory("jumlah_kursi"));
        col_class.setCellValueFactory(new PropertyValueFactory("kelas"));
        col_jam.setCellValueFactory(new PropertyValueFactory("jam_berangkat"));
        col_harga.setCellValueFactory(new PropertyValueFactory("harga"));
        ObservableList<Pesawat> data = FXCollections.observableArrayList();
        String sql = "SELECT * FROM pesawat WHERE kota_asal LIKE '%"+asal+"%' AND kota_tujuan LIKE '%"+tujuan+"%' AND kelas LIKE '%"+kelas+"%'";
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
        try {
            this.ShowTable(asal, tujuan, kelas);
        } catch (SQLException ex) {
            Logger.getLogger(PesawatController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PesawatController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}


