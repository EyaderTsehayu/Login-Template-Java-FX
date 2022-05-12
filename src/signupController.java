import java.sql.Connection;
import java.sql.PreparedStatement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class signupController {

    @FXML
    private TextField firstNameTextField;

    @FXML
    private TextField lastNameTextField;

    @FXML
    private PasswordField passwordTextField;

    @FXML
    private Button signupButton;

    @FXML
    private TextField userNameTextField;

    @FXML
    private Label signupMessage;

    @FXML
    void signup(ActionEvent event) {
        if (firstNameTextField.getText().isBlank() == false && lastNameTextField.getText().isBlank() == false
                && userNameTextField.getText().isBlank() == false && passwordTextField.getText().isBlank() == false) {
            add();
        } else {
            signupMessage.setText("Fill all Field !!!");
        }
    }

    public void add() {
        Connect c = new Connect();
        Connection con = c.getconnection();

        String sql = ("insert into student_account(firstname,lastname,username,password) values(?,?,?,?)");
        try {
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, firstNameTextField.getText());
            st.setString(2, lastNameTextField.getText());
            st.setString(3, userNameTextField.getText());
            st.setString(4, passwordTextField.getText());

            st.executeUpdate();

            signupMessage.setText("Successfully Registered ");

        } catch (Exception e) {
            System.out.println(e);
        }

    }
}