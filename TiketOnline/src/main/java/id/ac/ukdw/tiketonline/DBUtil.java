/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.ukdw.tiketonline;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ASUS
 */
public class DBUtil {
    private static DBUtil dbutil = null;
    private static Connection conn = null;
    
    public DBUtil(){
    }
    
    public static DBUtil getInstance(){
        if(dbutil == null) {
            dbutil = new DBUtil();
        }
        return dbutil;
    }
    
    private String getJDBC() {
        String urlDB = "pesawatkertas.db";
        String JDBC_DRIVER = null;
        if (urlDB != null) {
            JDBC_DRIVER = "jdbc:sqlite:" + urlDB;
        }

        return JDBC_DRIVER;
    }
    
    public void dbConnect() throws SQLException, ClassNotFoundException {
        try {
            conn = DriverManager.getConnection(getJDBC());
        } catch (SQLException e) {
            throw e;
        }
    }
    
    public void dbDisconnect() throws SQLException {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (SQLException e) {
            throw e;
        }
    }
}
