package frontEnd;

import backEnd.DataHolder;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import entites.User;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class ManageAccountController implements Initializable {

    public static Stage stage;
    @FXML
    private Label lblMain;

    @FXML
    private JFXTextField txt_name;

    @FXML
    private JFXTextField txt_email;

    @FXML
    private JFXTextField txt_tenNo;

    @FXML
    private JFXComboBox<?> cb_province;

    @FXML
    private JFXComboBox<?> cb_city;

    @FXML
    private JFXComboBox<?> cb_area;

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
    private JFXTextArea txt_discription;

    @FXML
    private JFXTextField txt_Day;

    @FXML
    private JFXTextField txt_Mounth;

    @FXML
    private JFXTextField txt_year;

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
            loadUser();
        }
    }

    @FXML
    void btn_refresh_OnMouseClicked(MouseEvent event) {
        loadUser();
    }

    @FXML
    void btn_submit_OnKeyRelease(KeyEvent event) {
        if (event.getCode().equals(KeyCode.ENTER)) {

        }

    }

    @FXML
    void btn_submit_OnMouseClicked(MouseEvent event) {

    }

    @FXML
    void cb_area_OnKeyRelease(KeyEvent event) {

    }

    @FXML
    void cb_city_OnKeyRelease(KeyEvent event) {

    }

    @FXML
    void cb_province_OnKeyRelease(KeyEvent event) {

    }

    @FXML
    void txt_Password_OnKeyRelease(KeyEvent event) {

    }

    @FXML
    void txt_Year_OnKeyRelease(KeyEvent event) {

    }

    @FXML
    void txt_day_OnKeyRelease(KeyEvent event) {

    }

    @FXML
    void txt_discription_onKeyReleased(KeyEvent event) {

    }

    @FXML
    void txt_email_OnKeyRelease(KeyEvent event) {

    }

    @FXML
    void txt_mointh_OnKeyRelease(KeyEvent event) {

    }

    @FXML
    void txt_name_OnKeyRelease(KeyEvent event) {

    }

    @FXML
    void txt_rePassword_OnKeyRelease(KeyEvent event) {

    }

    @FXML
    void txt_tellNo_OnKeyRelease(KeyEvent event) {

    }


    public void loadUser() {
        User user = DataHolder.user;
        txt_email.setText(user.getEmail());
        txt_tenNo.setText(user.getTellNo().toString());
        txt_Day.setText(Integer.toString(user.getDob().getDay()));
        txt_Mounth.setText((Integer.toString(user.getDob().getMonth() + 1)));
        txt_year.setText(Integer.toString(user.getDob().getYear()));
        txt_discription.setText(user.getDescription());
        ;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadUser();
    }
}
