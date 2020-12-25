package frontEnd;

import backEnd.MessageManager;
import backEnd.UserManager;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import entites.User;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Date;
import java.util.concurrent.ExecutionException;

public class CreatAccountController {

    public static Stage stage;
    private String windowName = "Creat Account";
    @FXML
    private Label lblMain;

    @FXML
    private RadioButton rbTypeP;

    @FXML
    private ToggleGroup accountType;

    @FXML
    private RadioButton rbTypeC;

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
    private JFXTextField txt_id;


    @FXML
    void btnCancelOnKeyRelease(KeyEvent event) {
        if (event.getCode().equals(KeyCode.ENTER)){
            stage.close();
        }
    }

    @FXML
    void btn_cancel_OnMouseClicked(MouseEvent event) {
        stage.close();
    }

    @FXML
    void btn_refresh_OnKeyRelease(KeyEvent event) {
        if (event.getCode().equals(KeyCode.ENTER)){
            refreshUI();
        }
    }

    @FXML
    void btn_refresh_OnMouseClicked(MouseEvent event) {
        refreshUI();
    }

    @FXML
    void btn_submit_OnKeyRelease(KeyEvent event) throws InterruptedException, ExecutionException, IOException {
        if (event.getCode().equals(KeyCode.ENTER)) {
            try {
                User user = UserManager.getUser(txt_id.getText());
                System.out.println(user);
//                MessageManager.giveAWarning("dsf");
            }catch (NullPointerException e){
                System.out.println(e);
                if (txt_password.getText().equals(txt_rePassword.getText())) {
                    if (rbTypeC.isSelected()) {
                        Date dob = new Date(Integer.parseInt(txt_year.getText()), Integer.parseInt(txt_Mounth.getText()), Integer.parseInt(txt_Day.getText()));
                        UserManager.addUser(new User(txt_id.getText(), "company", txt_name.getText(), txt_email.getText(), Long.parseLong(txt_tenNo.getText()), dob, cb_province.getSelectionModel().getSelectedItem().toString(), cb_city.getSelectionModel().getSelectedItem().toString(), cb_area.getSelectionModel().getSelectedItem().toString(), txt_password.getText(), txt_discription.getText()));
                        MessageManager.giveSuccessMessage(lblMain, "Company AccountCreated Successfully", windowName);
                    } else if (rbTypeP.isSelected()) {
                        Date dob = new Date(Integer.parseInt(txt_year.getText()), Integer.parseInt(txt_Mounth.getText()), Integer.parseInt(txt_Day.getText()));
                        UserManager.addUser(new User(txt_id.getText(), "personal", txt_name.getText(), txt_email.getText(), Long.parseLong(txt_tenNo.getText()), dob, cb_province.getSelectionModel().getSelectedItem().toString(), cb_city.getSelectionModel().getSelectedItem().toString(), cb_area.getSelectionModel().getSelectedItem().toString(), txt_password.getText(), txt_discription.getText()));
                        MessageManager.giveSuccessMessage(lblMain, "Personal AccountCreated Successfully", windowName);
                    } else {
                        MessageManager.giveAWarning(lblMain, "Select Account Type", windowName);
                        rbTypeC.requestFocus();
                    }
                }else {
                    MessageManager.giveAWarning(lblMain, "Password Doesn't Match, Please Re Enter Your Password", windowName);
                    txt_password.clear();
                    txt_rePassword.clear();
                    txt_password.requestFocus();
                }
            }
        }
    }

    @FXML
    void btn_submit_OnMouseClicked(MouseEvent event) throws InterruptedException, ExecutionException, IOException {


        try {
            User user = UserManager.getUser(txt_id.getText());
            System.out.println(user);
//                MessageManager.giveAWarning("dsf");
        }catch (NullPointerException e){
            System.out.println(e);
            if (txt_password.getText().equals(txt_rePassword.getText())) {
                if (rbTypeC.isSelected()) {
                    Date dob = new Date(Integer.parseInt(txt_year.getText()), Integer.parseInt(txt_Mounth.getText()), Integer.parseInt(txt_Day.getText()));
                    UserManager.addUser(new User(txt_id.getText(), "company", txt_name.getText(), txt_email.getText(), Long.parseLong(txt_tenNo.getText()), dob, cb_province.getSelectionModel().getSelectedItem().toString(), cb_city.getSelectionModel().getSelectedItem().toString(), cb_area.getSelectionModel().getSelectedItem().toString(), txt_password.getText(), txt_discription.getText()));
                    MessageManager.giveSuccessMessage(lblMain, "Company AccountCreated Successfully", windowName);
                } else if (rbTypeP.isSelected()) {
                    System.out.println(cb_province.getSelectionModel().getSelectedItem());
                    Date dob = new Date(Integer.parseInt(txt_year.getText()), Integer.parseInt(txt_Mounth.getText()), Integer.parseInt(txt_Day.getText()));
                    UserManager.addUser(new User(txt_id.getText(), "personal", txt_name.getText(), txt_email.getText(), Long.parseLong(txt_tenNo.getText()), dob, "gemba","gemba","gemba"/*cb_province.getSelectionModel().getSelectedItem().toString(), cb_city.getSelectionModel().getSelectedItem().toString(), cb_area.getSelectionModel().getSelectedItem().toString()*/, txt_password.getText(), txt_discription.getText()));
                    MessageManager.giveSuccessMessage(lblMain, "Personal AccountCreated Successfully", windowName);

                } else {
                    MessageManager.giveAWarning(lblMain, "Select Account Type", windowName);
                    rbTypeC.requestFocus();
                }
            }else {
                MessageManager.giveAWarning(lblMain, "Password Doesn't Match, Please Re Enter Your Password", windowName);
                txt_password.clear();
                txt_rePassword.clear();
                txt_password.requestFocus();
            }
        }

    }

    @FXML
    void cb_area_OnKeyRelease(KeyEvent event) {
        if (event.getCode().equals(KeyCode.ENTER)) {
            txt_id.requestFocus();
        }
    }

    @FXML
    void cb_city_OnKeyRelease(KeyEvent event) {
        if (event.getCode().equals(KeyCode.ENTER)) {
            cb_area.requestFocus();
        }
    }

    @FXML
    void cb_province_OnKeyRelease(KeyEvent event) {
        if (event.getCode().equals(KeyCode.ENTER)) {
            cb_city.requestFocus();
        }
    }

    @FXML
    void rbTypeCOnKeyRelease(KeyEvent event) {
        if (event.getCode().equals(KeyCode.ENTER)) {
            txt_name.requestFocus();
        }
    }

    @FXML
    void rbTypePOnKeyRelease(KeyEvent event) {
        if (event.getCode().equals(KeyCode.ENTER)) {
            txt_name.requestFocus();
        }
    }

    @FXML
    void txt_Password_OnKeyRelease(KeyEvent event) {
        txt_rePassword.requestFocus();
    }

    @FXML
    void txt_Year_OnKeyRelease(KeyEvent event) {
        if (event.getCode().equals(KeyCode.ENTER)) {
            cb_province.requestFocus();
        }
    }

    @FXML
    void txt_day_OnKeyRelease(KeyEvent event) {
        if (event.getCode().equals(KeyCode.ENTER)) {
            txt_Mounth.requestFocus();
        }
    }

    @FXML
    void txt_discription_onKeyReleased(KeyEvent event) {
        if (event.getCode().equals(KeyCode.ENTER)) {
            btn_submit.requestFocus();
        }
    }

    @FXML
    void txt_email_OnKeyRelease(KeyEvent event) {
        if (event.getCode().equals(KeyCode.ENTER)) {
            txt_tenNo.requestFocus();
        }
    }

    @FXML
    void txt_id_OnKeyRelease(KeyEvent event) {
        if (event.getCode().equals(KeyCode.ENTER)) {
            txt_password.requestFocus();
        }
    }

    @FXML
    void txt_mointh_OnKeyRelease(KeyEvent event) {
        if (event.getCode().equals(KeyCode.ENTER)) {
            txt_year.requestFocus();
        }
    }

    @FXML
    void txt_name_OnKeyRelease(KeyEvent event) {
        if (event.getCode().equals(KeyCode.ENTER)) {
         txt_email.requestFocus();
        }
    }

    @FXML
    void txt_rePassword_OnKeyRelease(KeyEvent event) {
        if (event.getCode().equals(KeyCode.ENTER)) {
            txt_discription.requestFocus();
        }
    }

    @FXML
    void txt_tellNo_OnKeyRelease(KeyEvent event) {
        if (event.getCode().equals(KeyCode.ENTER)) {
            txt_Day.requestFocus();
        }
    }

    public  void refreshUI(){
        rbTypeC.setSelected(false);
        rbTypeP.setSelected(false);
        txt_name.clear();
        txt_email.clear();
        txt_tenNo.clear();
        txt_Day.clear();
        txt_Mounth.clear();
        txt_year.clear();
        cb_province.getSelectionModel().clearSelection();
        cb_city.getSelectionModel().clearSelection();
        cb_area.getSelectionModel().clearSelection();
        txt_id.clear();
        txt_password.clear();
        txt_rePassword.clear();
        txt_discription.clear();
        rbTypeC.requestFocus();
    }
}
