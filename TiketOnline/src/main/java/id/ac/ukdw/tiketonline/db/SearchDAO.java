/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.ukdw.tiketonline.db;

import id.ac.ukdw.tiketonline.model.Pesawat;
import id.ac.ukdw.tiketonline.model.Search;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import static jdk.nashorn.internal.objects.NativeString.search;

/**
 *
 * @author asus
 */
public class SearchDAO {
     public static Search searchSearch(int id_search) throws SQLException, ClassNotFoundException {
        String selectStmt = "SELECT * FROM search WHERE id_search='" + id_search + "'";
        try {
            ResultSet rsSearch= DBUtil.getInstance().dbExecuteQuery(selectStmt);
            Search search = getSearchFromResultSet(rsSearch);
            return search;
        } catch (SQLException e) {
            System.out.println("Sedang mencari search dengan id_search " + id_search + ", error terjadi: " + e);
            throw e;
        }
    }

    private static Search getSeacrhFromResultSet(ResultSet rs) throws SQLException {
        Search search = null;
        if (rs.next()) {
            search = new Search();
            search.setId_search(rs.getInt("id_search"));
            search.setAsal1(rs.getString("asal1"));
            search.setTujuan1(rs.getString("tujuan1"));
            search.setAdult1(rs.getInt("adult1"));
            search.setInfant1(rs.getInt("infant1"));
            search.setChild1(rs.getInt("child1"));
            search.setDate1(rs.getString("date1"));
            search.setKelas1(rs.getString("kelas1"));
      
            
        }
        return search;
    }

    public static ObservableList<Search> searchSearch() throws SQLException, ClassNotFoundException {
        String selectStmt = "SELECT * FROM search";
        try {
            ResultSet rsMtk = DBUtil.getInstance().dbExecuteQuery(selectStmt);
            ObservableList<Search> searchList = getSearchList(rsMtk);
            return searchList;
        } catch (SQLException e) {
            System.out.println("SQL select operation has been failed: " + e); //Return exception
            throw e;
        }
    }

    private static ObservableList<Search> getSearchList(ResultSet rs) throws SQLException, ClassNotFoundException {
        ObservableList<Search> searchList = FXCollections.observableArrayList();
        while (rs.next()) {
            Search search = new Search();
             search.setId_search(rs.getInt("id_search"));
            search.setAsal1(rs.getString("asal1"));
            search.setTujuan1(rs.getString("tujuan1"));
            search.setAdult1(rs.getInt("adult1"));
            search.setInfant1(rs.getInt("infant1"));
            search.setChild1(rs.getInt("child1"));
            search.setDate1(rs.getString("date1"));
            search.setKelas1(rs.getString("kelas1"));
            searchList.add(search);
        }
        return searchList;
    }

 
    public static void updateSearcht(int id_search, Search search) throws SQLException, ClassNotFoundException {
        String updateStmt = "UPDATE search SET id_search='" + search.getId_search() + "',"
                + "aasal1 = '" + search.getAsal1()+ "', "
                + "tujaun1 = '" + search.getTujuan1() + "',"
                + "adult1 = '" + search.getAdult1() + "',"
                + "infant1 = '" + search.getInfant1() + "',"
                + "child1 = '" + search.getChild1() + "',"
                + "date1= '" + search.getDate1() + "',"
                + "kelas1 = '" + search.getKelas1() +"'";
        try {
            DBUtil.getInstance().dbExecuteUpdate(updateStmt);
        } catch (SQLException e) {
            throw e;
        }
    }

    public static void deleteEmpWithId(int id_search) throws SQLException, ClassNotFoundException {
        String updateStmt = "DELETE FROM search WHERE id_search='" + id_search + "'";
        try {
            DBUtil.getInstance().dbExecuteUpdate(updateStmt);
        } catch (SQLException e) {
            throw e;
        }
    }

    private static Search getSearchFromResultSet(ResultSet rsSearch) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
