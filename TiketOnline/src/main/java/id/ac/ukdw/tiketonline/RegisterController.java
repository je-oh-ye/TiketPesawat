/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.ukdw.tiketonline;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class RegisterController implements Initializable {
   
    @FXML
    private TextField txtUsername;

    @FXML
    private Hyperlink signIn;

    @FXML
    private TextField txtEmail;

    @FXML
    private Button btnRegis;

    @FXML
    private PasswordField txtPassword;

    @FXML
    void signIn(ActionEvent event) {

    }

    @FXML
    void f65a00(ActionEvent event) {

    }

  


  
    @FXML
    void btnRegis(ActionEvent event) throws IOException, ClassNotFoundException, SQLException {
        if (txtEmail.getText().isEmpty() || txtUsername.getText().isEmpty() || txtPassword.getText().isEmpty()) {
           Alert alert = new Alert(Alert.AlertType.INFORMATION);
           alert.setTitle("Register Failed");
           alert.setHeaderText("Register Failed");
           alert.setContentText("Empty Field");
           alert.showAndWait();
        } else {
            SignUpPengguna();
            Stage stageUtama = new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Login.fxml"));
            Parent root1 = (Parent) loader.load();
            Scene scene = new Scene(root1);
            scene.getStylesheets().add("/styles/style.css");
            stageUtama.setScene(scene);
            stageUtama.show();
        }
    }

    
    PreparedStatement preparedStatement;
    Connection connection;
     public RegisterController() {
//        connection = (Connection) ConnectionDB.Connector();
    }

    /**
     * Initializes the controller class.
     */
     
    private void ClearFields() {
        txtEmail.clear();
        txtUsername.clear();
    }
    
    private String SignUpPengguna(){
        try{
          
                String sql = "INSERT INTO pengguna(Email, Username, Password) VALUES (?,?,?)";
                preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
                preparedStatement.setString(1, txtEmail.getText());
                preparedStatement.setString(2, txtUsername.getText());
                preparedStatement.setString(3, txtPassword.getText());

                preparedStatement.executeUpdate();
               Alert alert = new Alert(Alert.AlertType.INFORMATION);
               alert.setTitle("Register Succes");
               alert.setHeaderText("Register Success");
               alert.showAndWait();

                ClearFields();
                return "Success";
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
            
            return "SQLException";
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
