package id.ac.ukdw.tiketonline;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import id.ac.ukdw.tiketonline.db.DBUtil;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author User
 */
public class LoginController implements Initializable {

    @FXML
    private TextField txtUsername;
    @FXML
    private PasswordField txtPassword;
    @FXML
    private Hyperlink signUp;
    @FXML
    private Button btnLogin;

    @FXML
    void btnLogin(ActionEvent event) throws IOException, ClassNotFoundException {
        try{
            DBUtil db = new DBUtil();
            String user = txtUsername.getText();
            String pass = txtPassword.getText();
            String query = "SELECT * from pengguna WHERE username = '"+user+"' AND password =  '"+pass+"'";
            ResultSet rs = db.dbExecuteQuery(query);  
            if(rs.next()){
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("/fxml/Home.fxml"));
                Parent Home = loader.load();
                Scene scene = new Scene(Home);
                Stage Primarystage = (Stage) ((Node)event.getSource()).getScene().getWindow();
                Primarystage.setResizable(false);
                Primarystage.setScene(scene);
                Primarystage.show();
            }
    }catch(SQLException e){
        System.out.println(e.getMessage());
        JOptionPane.showMessageDialog(null, "LOGIN FAILED");
//      e.printStackTrace();
    }
    }

    @FXML
    void signUp(ActionEvent event) throws IOException {
         FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/Register.fxml"));
        Parent Regis = loader.load();
        Scene scene = new Scene(Regis);
        Stage Primarystage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        Primarystage.setResizable(false);
        Primarystage.setScene(scene);
        Primarystage.show();
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         DBUtil db;
        db = new DBUtil();
        try {
            db.dbConnect();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
}
