import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

//import com.mysql.cj.xdevapi.Statement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginControler {

    @FXML
    private PasswordField enterPasswordField;

    @FXML
    private Button loginButton;

    @FXML
    private Label loginMessageLabel;

    @FXML
    private Button signupButton;

    @FXML
    private TextField usernameTextField;

    public void loginButtonOnAction(ActionEvent event) {
        if (usernameTextField.getText().isBlank() == false && enterPasswordField.getText().isBlank() == false) {
            validateLogin();

        } else {
            loginMessageLabel.setText("please enter Username and Password");
        }

    }

    @FXML
    void signupButtonOnAction(ActionEvent event) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("Signup.fxml"));
            Stage stage = (Stage) signupButton.getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {

            e.printStackTrace();
        }

    }

    public void validateLogin() {
        Connect c = new Connect();
        Connection con = c.getconnection();

        String verify = ("select count(1) From student_account where userName ='" + usernameTextField.getText()
                + "' and password = '" + enterPasswordField.getText() + "'");

        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(verify);
            while (rs.next())
                if (rs.getInt(1) == 1) {

                    Parent root = FXMLLoader.load(getClass().getResource("welcome.fxml"));
                    Stage stage = (Stage) loginButton.getScene().getWindow();
                    Scene scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();

                } else {
                    loginMessageLabel.setText("Invalid Login Please try again");
                }
        } catch (Exception e) {
            System.out.print(e);
        }
    }

}
