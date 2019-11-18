/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.ukdw.tiketonline.db;

import id.ac.ukdw.tiketonline.model.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author asus
 */
public class UserDAO {
     public static User searchUser(int id_user) throws SQLException, ClassNotFoundException {
        String selectStmt = "SELECT * FROM user WHERE id_user='" + id_user + "'";
        try {
            ResultSet rsUser= DBUtil.getInstance().dbExecuteQuery(selectStmt);
            User user = getUserFromResultSet(rsUser);
            return user;
        } catch (SQLException e) {
            System.out.println("Sedang mencari user dengan id_user " + id_user + ", error terjadi: " + e);
            throw e;
        }
    }

    private static User getUserFromResultSet(ResultSet rs) throws SQLException {
        User user = null;
        if (rs.next()) {
            user = new User();
            user.setId_user(rs.getInt("id_user"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setBerat(rs.getInt("berat"));
        }
        return user;
    }

    public static ObservableList<User> searchUser() throws SQLException, ClassNotFoundException {
        String selectStmt = "SELECT * FROM user";
        try {
            ResultSet rsMtk = DBUtil.getInstance().dbExecuteQuery(selectStmt);
            ObservableList<User> userList = getUserList(rsMtk);
            return userList;
        } catch (SQLException e) {
            System.out.println("SQL select operation has been failed: " + e); //Return exception
            throw e;
        }
    }

    private static ObservableList<User> getUserList(ResultSet rs) throws SQLException, ClassNotFoundException {
        ObservableList<User> userList = FXCollections.observableArrayList();
        while (rs.next()) {
            User user = new User();
            user.setId_user(rs.getInt("id_user"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setBerat(rs.getInt("berat"));
            userList.add(user);
        }
        return userList;
    }

 
    public static void updateUser(int id_user, User user) throws SQLException, ClassNotFoundException {
        String updateStmt = "UPDATE user SET id_user='" + user.getId_user() + "',"
                + "username = '" + user.getUsername() + "', "
                + "password = '" + user.getPassword() + "',"
                + "email = '" + user.getEmail() + "',"
                + "berat = '" + user.getBerat() + "' "
                + "WHERE id_user='" + id_user + "'";
        try {
            DBUtil.getInstance().dbExecuteUpdate(updateStmt);
        } catch (SQLException e) {
            throw e;
        }
    }

    public static void deleteEmpWithId(int id_user) throws SQLException, ClassNotFoundException {
        String updateStmt = "DELETE FROM user WHERE id_user='" + id_user + "'";
        try {
            DBUtil.getInstance().dbExecuteUpdate(updateStmt);
        } catch (SQLException e) {
            throw e;
        }
    }
}
    


