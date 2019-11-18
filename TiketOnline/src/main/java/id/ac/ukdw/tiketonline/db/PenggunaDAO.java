/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.ukdw.tiketonline.db;

import id.ac.ukdw.tiketonline.model.Pengguna;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author asus
 */
public class PenggunaDAO {
     public static Pengguna searchPengguna(int id_pengguna) throws SQLException, ClassNotFoundException {
        String selectStmt = "SELECT * FROM pengguna WHERE id_pengguna='" + id_pengguna + "'";
        try {
            ResultSet rsPengguna= DBUtil.getInstance().dbExecuteQuery(selectStmt);
            Pengguna pengguna = getPenggunaFromResultSet(rsPengguna);
            return pengguna;
        } catch (SQLException e) {
            System.out.println("Sedang mencari pengguna dengan id_pengguna " + id_pengguna + ", error terjadi: " + e);
            throw e;
        }
    }

    private static Pengguna getPenggunaFromResultSet(ResultSet rs) throws SQLException {
        Pengguna pengguna = null;
        if (rs.next()) {
            pengguna = new Pengguna();
            pengguna.setId_pengguna(rs.getInt("id_pengguna"));
            pengguna.setUsername(rs.getString("username"));
            pengguna.setPassword(rs.getString("password"));
            pengguna.setEmail(rs.getString("email"));
        }
        return pengguna;
    }

    public static ObservableList<Pengguna> searchPengguna() throws SQLException, ClassNotFoundException {
        String selectStmt = "SELECT * FROM pengguna";
        try {
            ResultSet rsMtk = DBUtil.getInstance().dbExecuteQuery(selectStmt);
            ObservableList<Pengguna> penggunaList = getPenggunaList(rsMtk);
            return penggunaList;
        } catch (SQLException e) {
            System.out.println("SQL select operation has been failed: " + e); //Return exception
            throw e;
        }
    }

    private static ObservableList<Pengguna> getPenggunaList(ResultSet rs) throws SQLException, ClassNotFoundException {
        ObservableList<Pengguna> penggunaList = FXCollections.observableArrayList();
        while (rs.next()) {
            Pengguna pengguna = new Pengguna();
            pengguna.setId_pengguna(rs.getInt("id_pengguna"));
            pengguna.setUsername(rs.getString("username"));
            pengguna.setPassword(rs.getString("password"));
            pengguna.setEmail(rs.getString("email"));
            penggunaList.add(pengguna);
        }
        return penggunaList;
    }

 
    public static void updatePengguna(int id_pengguna, Pengguna pengguna) throws SQLException, ClassNotFoundException {
        String updateStmt = "UPDATE pengguna SET id_pengguna='" + pengguna.getId_pengguna() + "',"
                + "penggunaname = '" + pengguna.getUsername() + "', "
                + "password = '" + pengguna.getPassword() + "',"
                + "email = '" + pengguna.getEmail() + "',"
                + "WHERE id_pengguna='" + id_pengguna + "'";
        try {
            DBUtil.getInstance().dbExecuteUpdate(updateStmt);
        } catch (SQLException e) {
            throw e;
        }
    }

    public static void deleteEmpWithId(int id_pengguna) throws SQLException, ClassNotFoundException {
        String updateStmt = "DELETE FROM pengguna WHERE id_pengguna='" + id_pengguna + "'";
        try {
            DBUtil.getInstance().dbExecuteUpdate(updateStmt);
        } catch (SQLException e) {
            throw e;
        }
    }
}
    


