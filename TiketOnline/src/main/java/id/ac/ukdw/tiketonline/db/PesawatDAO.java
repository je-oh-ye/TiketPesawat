/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.ukdw.tiketonline.db;

import id.ac.ukdw.tiketonline.model.Pesawat;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author asus
 */
public class PesawatDAO {
     public static Pesawat searchPesawat(int id_pesawat) throws SQLException, ClassNotFoundException {
        String selectStmt = "SELECT * FROM pesawat WHERE id_pesawat='" + id_pesawat + "'";
        try {
            ResultSet rsPesawat= DBUtil.getInstance().dbExecuteQuery(selectStmt);
            Pesawat pesawat = getPesawatFromResultSet(rsPesawat);
            return pesawat;
        } catch (SQLException e) {
            System.out.println("Sedang mencari pesawat dengan id_pesawat " + id_pesawat + ", error terjadi: " + e);
            throw e;
        }
    }

    private static Pesawat getPesawatFromResultSet(ResultSet rs) throws SQLException {
        Pesawat pesawat = null;
        if (rs.next()) {
            pesawat = new Pesawat();
           pesawat.setId_pesawat(rs.getInt("id_pesawat"));
            pesawat.setMaskapai(rs.getString("maskapai"));
            pesawat.setKota_asal(rs.getString("kota_asal"));
            pesawat.setKota_tujuan(rs.getString("kota_tujuan"));
            pesawat.setJumlah_kursi(rs.getInt("jumlah_kursi"));
            pesawat.setTanggal(rs.getString("tanggal"));
            pesawat.setKelas(rs.getString("kelas"));
            pesawat.setJam_berangkat(rs.getString("jam_berangkat"));
            pesawat.setJam_tiba(rs.getString("jam_tiba"));
            pesawat.setHarga(rs.getInt("harga"));
            
        }
        return pesawat;
    }

    public static ObservableList<Pesawat> searchPesawat() throws SQLException, ClassNotFoundException {
        String selectStmt = "SELECT * FROM pesawat";
        try {
            ResultSet rsMtk = DBUtil.getInstance().dbExecuteQuery(selectStmt);
            ObservableList<Pesawat> pesawatList = getPesawatList(rsMtk);
            return pesawatList;
        } catch (SQLException e) {
            System.out.println("SQL select operation has been failed: " + e); //Return exception
            throw e;
        }
    }

    private static ObservableList<Pesawat> getPesawatList(ResultSet rs) throws SQLException, ClassNotFoundException {
        ObservableList<Pesawat> pesawatList = FXCollections.observableArrayList();
        while (rs.next()) {
            Pesawat pesawat = new Pesawat();
            pesawat.setId_pesawat(rs.getInt("id_pesawat"));
            pesawat.setMaskapai(rs.getString("maskapai"));
            pesawat.setKota_asal(rs.getString("kota_asal"));
            pesawat.setKota_tujuan(rs.getString("kota_tujuan"));
            pesawat.setJumlah_kursi(rs.getInt("jumlah_kursi"));
            pesawat.setTanggal(rs.getString("tanggal"));
            pesawat.setKelas(rs.getString("kelas"));
            pesawat.setJam_berangkat(rs.getString("jam_berangkat"));
            pesawat.setJam_tiba(rs.getString("jam_tiba"));
            pesawat.setHarga(rs.getInt("harga"));
            pesawatList.add(pesawat);
        }
        return pesawatList;
    }

 
    public static void updatePesawat(int id_pesawat, Pesawat pesawat) throws SQLException, ClassNotFoundException {
        String updateStmt = "UPDATE pesawat SET id_pesawat='" + pesawat.getId_pesawat() + "',"
                + "maskapai = '" + pesawat.getMaskapai() + "', "
                + "kota_asal = '" + pesawat.getKota_asal() + "',"
                + "kota_tujuan = '" + pesawat.getKota_tujuan() + "',"
                + "jumlah_kursi = '" + pesawat.getJumlah_kursi() + "',"
                + "tanggal = '" + pesawat.getTanggal() + "',"
                + "kelas= '" + pesawat.getKelas() + "',"
                + "jam_berangkat = '" + pesawat.getJam_berangkat() + "',"
                + "jam_tiba = '" + pesawat.getJam_tiba() + "',"
                + "harga = '" + pesawat.getHarga() + "',"
                + "WHERE id_pesawat='" + id_pesawat + "'";
        try {
            DBUtil.getInstance().dbExecuteUpdate(updateStmt);
        } catch (SQLException e) {
            throw e;
        }
    }

    public static void deleteEmpWithId(int id_pesawat) throws SQLException, ClassNotFoundException {
        String updateStmt = "DELETE FROM pesawat WHERE id_pesawat='" + id_pesawat + "'";
        try {
            DBUtil.getInstance().dbExecuteUpdate(updateStmt);
        } catch (SQLException e) {
            throw e;
        }
    }
}
