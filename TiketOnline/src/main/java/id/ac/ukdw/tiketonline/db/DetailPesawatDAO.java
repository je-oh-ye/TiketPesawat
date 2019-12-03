/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.ukdw.tiketonline.db;

import id.ac.ukdw.tiketonline.model.DetailPesawat;
import id.ac.ukdw.tiketonline.model.Pesawat;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author asus
 */
public class DetailPesawatDAO {
     public static DetailPesawat searchdetailPesawat(int id_detail) throws SQLException, ClassNotFoundException {
        String selectStmt = "SELECT * FROM detail_pesawat WHERE id_detail='" + id_detail + "'";
        try {
            ResultSet rsDetailPesawat= DBUtil.getInstance().dbExecuteQuery(selectStmt);
            DetailPesawat detail = getPesawatFromResultSet(rsDetailPesawat);
            return detail;
        } catch (SQLException e) {
            System.out.println("Sedang mencari detail_detail dengan id_detail " + id_detail + ", error terjadi: " + e);
            throw e;
        }
    }

    private static DetailPesawat getDetailPesawatFromResultSet(ResultSet rs) throws SQLException {
        DetailPesawat detail = null;
        if (rs.next()) {
            detail = new DetailPesawat();
            detail.setId_detail(rs.getInt("id_detail"));
            detail.setMaskapai(rs.getString("maskapai"));
            detail.setAsal(rs.getString("asal"));
            detail.setTujuan(rs.getString("tujuan"));
            detail.setKelas(rs.getString("kelas"));
            detail.setJam_berangkat(rs.getString("jam_berangkat"));
            detail.setJam_tiba(rs.getString("jam_tiba"));
            detail.setHarga(rs.getInt("harga"));
            
        }
        return detail;
    }

    public static ObservableList<DetailPesawat> searchDetailPesawat() throws SQLException, ClassNotFoundException {
        String selectStmt = "SELECT * FROM detail_pesawat";
        try {
            ResultSet rsMtk = DBUtil.getInstance().dbExecuteQuery(selectStmt);
            ObservableList<DetailPesawat> detailList = getDetailPesawatList(rsMtk);
            return detailList;
        } catch (SQLException e) {
            System.out.println("SQL select operation has been failed: " + e); //Return exception
            throw e;
        }
    }

    private static ObservableList<DetailPesawat> getDetailPesawatList(ResultSet rs) throws SQLException, ClassNotFoundException {
        ObservableList<DetailPesawat> detailList = FXCollections.observableArrayList();
        while (rs.next()) {
            DetailPesawat detail = new DetailPesawat();
            detail.setId_detail(rs.getInt("id_detail"));
            detail.setMaskapai(rs.getString("maskapai"));
            detail.setAsal(rs.getString("asal"));
            detail.setTujuan(rs.getString("tujuan"));
            detail.setKelas(rs.getString("kelas"));
            detail.setJam_berangkat(rs.getString("jam_berangkat"));
            detail.setJam_tiba(rs.getString("jam_tiba"));
            detail.setHarga(rs.getInt("harga"));
            detailList.add(detail);
        }
        return detailList;
    }

 
    public static void updateDetailPesawat(int id_detail, DetailPesawat detail) throws SQLException, ClassNotFoundException {
        String updateStmt = "UPDATE detail_pesawat SET id_detail='" + detail.getId_detail() + "',"
                + "maskapai = '" + detail.getMaskapai() + "', "
                + "asal = '" + detail.getAsal() + "',"
                + "tujuan = '" + detail.getTujuan() + "',"
                + "kelas= '" + detail.getKelas() + "',"
                + "jam_berangkat = '" + detail.getJam_berangkat() + "',"
                + "jam_tiba = '" + detail.getJam_tiba() + "',"
                + "harga = '" + detail.getHarga() + "',"
                + "WHERE id_detail='" + id_detail + "'";
        try {
            DBUtil.getInstance().dbExecuteUpdate(updateStmt);
        } catch (SQLException e) {
            throw e;
        }
    }

    public static void deleteEmpWithId(int id_detail) throws SQLException, ClassNotFoundException {
        String updateStmt = "DELETE FROM detail_pesawat WHERE id_detail='" + id_detail + "'";
        try {
            DBUtil.getInstance().dbExecuteUpdate(updateStmt);
        } catch (SQLException e) {
            throw e;
        }
    }

    private static DetailPesawat getPesawatFromResultSet(ResultSet rsDetailPesawat) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

