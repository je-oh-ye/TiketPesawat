package id.ac.ukdw.tiketonline;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class RegisterController {

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtUsername;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private Hyperlink signIn;

    @FXML
    private Button btnRegis;

    @FXML
    void btnRegis(ActionEvent event) {
DBUtil db = new DBUtil();
            String user = txtUsername.getText();//isi id yang di fxml .getText
            String email = txtEmail.getText();//isi id yang di fxml .getText 
            String pass = txtPassword.getText();//isi id yang di fxml .getText 
            String query2 = "INSERT INTO pengguna ( username, password, email) VALUES ( '"+user+"', '"+pass+"', '"+email+"') ";
            if(pass.isEmpty() || email.isEmpty() || user.isEmpty()){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("REGISTER FAILED");
                alert.setHeaderText("REGISTER FAILED !");
                alert.setContentText("Empty Field");
                alert.showAndWait();
            }else{
                db.dbExecuteUpdate(query2);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Register Success");
                alert.setHeaderText("Register Success");
                alert.showAndWait();
//            statement.close();
            }
    }

    @FXML
    void signIn(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/Login.fxml"));
        Parent Login = loader.load();
        Scene scene = new Scene(Login);
        Stage Primarystage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        Primarystage.setResizable(false);
        Primarystage.setScene(scene);
        Primarystage.show();
    }

}
