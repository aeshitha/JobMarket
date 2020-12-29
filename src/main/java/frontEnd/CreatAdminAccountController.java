package frontEnd;

import backEnd.AdminManager;
import backEnd.MessageManager;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import entites.Admin;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.ExecutionException;

public class CreatAdminAccountController implements Initializable {

    public static Stage stage;
    String windowName = "Creat Admin Account";
    @FXML
    private Label lblMain;

    @FXML
    private JFXTextField txt_name;

    @FXML
    private JFXTextField txt_id;

    @FXML
    private JFXTextField txt_password;

    @FXML
    private JFXTextField txt_rePassword;

    @FXML
    private JFXButton btn_submit;

    @FXML
    private JFXButton btn_refresh;

    @FXML
    private JFXButton btn_cancel;

    @FXML
    void btnCancelOnKeyRelease(KeyEvent event) {
        if (event.getCode().equals(KeyCode.ENTER)) {
            stage.close();
        }
    }

    @FXML
    void btn_cancel_OnMouseClicked(MouseEvent event) {
        stage.close();
    }

    @FXML
    void btn_refresh_OnKeyRelease(KeyEvent event) {
        if (event.getCode().equals(KeyCode.ENTER)) {
            refreshUi();
        }

    }

    @FXML
    void btn_refresh_OnMouseClicked(MouseEvent event) {
        refreshUi();

    }

    @FXML
    void btn_submit_OnKeyRelease(KeyEvent event) throws InterruptedException, ExecutionException, IOException {
        if (event.getCode().equals(KeyCode.ENTER)) {

            if (txt_password.getText().equals(txt_rePassword.getText())) {
                AdminManager.addAdmin(new Admin(txt_id.getText(), txt_name.getText(), txt_password.getText(), "admin"));
                MessageManager.giveSuccessMessage(lblMain, "Admin AccountCreated Successfully", windowName);
                refreshUi();

            } else {
                MessageManager.giveAWarning(lblMain, "Password Doesn't Match, Please Re Enter Your Password", windowName);
                txt_password.clear();
                txt_rePassword.clear();
                txt_password.requestFocus();
            }
        }

    }

    @FXML
    void btn_submit_OnMouseClicked(MouseEvent event) throws InterruptedException, ExecutionException, IOException {

        if (txt_password.getText().equals(txt_rePassword.getText())) {
            AdminManager.addAdmin(new Admin(txt_id.getText(), txt_name.getText(), txt_password.getText(), "admin"));
            MessageManager.giveSuccessMessage(lblMain, "Admin AccountCreated Successfully", windowName);
            refreshUi();
        } else {
            MessageManager.giveAWarning(lblMain, "Password Doesn't Match, Please Re Enter Your Password", windowName);
            txt_password.clear();
            txt_rePassword.clear();
            txt_password.requestFocus();
        }

    }

    @FXML
    void txt_Password_OnKeyRelease(KeyEvent event) {
        if (event.getCode().equals(KeyCode.ENTER)) {
            txt_rePassword.requestFocus();
        }

    }

    @FXML
    void txt_id_OnKeyRelease(KeyEvent event) {
        if (event.getCode().equals(KeyCode.ENTER)) {
            txt_name.requestFocus();
        }
    }

    @FXML
    void txt_name_OnKeyRelease(KeyEvent event) {
        if (event.getCode().equals(KeyCode.ENTER)) {
            txt_password.requestFocus();
        }
    }

    @FXML
    void txt_rePassword_OnKeyRelease(KeyEvent event) {
        btn_submit.requestFocus();
    }

    public void refreshUi() {
        txt_id.clear();
        txt_name.clear();
        txt_password.clear();
        txt_rePassword.clear();
        txt_id.requestFocus();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        lblMain.setText(windowName);
        txt_id.requestFocus();
    }
}
