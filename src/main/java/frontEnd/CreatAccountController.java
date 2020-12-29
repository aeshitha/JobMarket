package frontEnd;

import backEnd.*;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import entites.Area;
import entites.City;
import entites.Province;
import entites.User;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.concurrent.ExecutionException;

public class CreatAccountController implements Initializable {

    List<Province> provinces;
    List<Area> areas;
    List<City> cities;
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
    private JFXComboBox<String> cb_province;

    @FXML
    private JFXComboBox<String> cb_city;

    @FXML
    private JFXComboBox<String> cb_area;

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
                MessageManager.giveAWarning(lblMain, "User Id Already Exists", windowName);
                txt_id.clear();
                txt_id.requestFocus();
            } catch (NullPointerException e) {
                if (txt_password.getText().equals(txt_rePassword.getText())) {
                    if (rbTypeC.isSelected()) {
                        UserManager.addUser(new User(txt_id.getText(), "company", txt_name.getText(), txt_email.getText(), Long.parseLong(txt_tenNo.getText()), null, cb_province.getSelectionModel().getSelectedItem().toString(), cb_city.getSelectionModel().getSelectedItem().toString(), cb_area.getSelectionModel().getSelectedItem().toString(), txt_password.getText(), txt_discription.getText()));
                        MessageManager.giveSuccessMessage(lblMain, "Company AccountCreated Successfully", windowName);
                        refreshUI();
                    } else if (rbTypeP.isSelected()) {
//                    System.out.println(cb_province.getSelectionModel().getSelectedItem());
                        Date dob = null;
                        try {
                            dob = new SimpleDateFormat("dd/MM/yyyy").parse(txt_Day.getText() + "/" + txt_Mounth.getText() + "/" + txt_year.getText());
                        } catch (ParseException ex) {
                            ex.printStackTrace();
                        }
                        UserManager.addUser(new User(txt_id.getText(), "personal", txt_name.getText(), txt_email.getText(), Long.parseLong(txt_tenNo.getText()), dob, cb_province.getSelectionModel().getSelectedItem().toString(), cb_city.getSelectionModel().getSelectedItem().toString(), cb_area.getSelectionModel().getSelectedItem().toString(), txt_password.getText(), txt_discription.getText()));
                        MessageManager.giveSuccessMessage(lblMain, "Personal AccountCreated Successfully", windowName);
                        refreshUI();
                    } else {
                        MessageManager.giveAWarning(lblMain, "Select Account Type", windowName);
                        rbTypeC.requestFocus();
                    }
                } else {
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
            MessageManager.giveAWarning(lblMain, "User Id Already Exists", windowName);
            txt_id.clear();
            txt_id.requestFocus();
        } catch (NullPointerException e) {
            if (txt_password.getText().equals(txt_rePassword.getText())) {
                if (rbTypeC.isSelected()) {
                    UserManager.addUser(new User(txt_id.getText(), "company", txt_name.getText(), txt_email.getText(), Long.parseLong(txt_tenNo.getText()), null, cb_province.getSelectionModel().getSelectedItem().toString(), cb_city.getSelectionModel().getSelectedItem().toString(), cb_area.getSelectionModel().getSelectedItem().toString(), txt_password.getText(), txt_discription.getText()));
                    MessageManager.giveSuccessMessage(lblMain, "Company AccountCreated Successfully", windowName);
                    refreshUI();
                } else if (rbTypeP.isSelected()) {
//                    System.out.println(cb_province.getSelectionModel().getSelectedItem());
                    Date dob = null;
                    try {
                        dob = new SimpleDateFormat("dd/MM/yyyy").parse(txt_Day.getText() + "/" + txt_Mounth.getText() + "/" + txt_year.getText());
                    } catch (ParseException ex) {
                        ex.printStackTrace();
                    }
                    UserManager.addUser(new User(txt_id.getText(), "personal", txt_name.getText(), txt_email.getText(), Long.parseLong(txt_tenNo.getText()), dob, "gemba", "gemba", "gemba"/*cb_province.getSelectionModel().getSelectedItem().toString(), cb_city.getSelectionModel().getSelectedItem().toString(), cb_area.getSelectionModel().getSelectedItem().toString()*/, txt_password.getText(), txt_discription.getText()));
                    MessageManager.giveSuccessMessage(lblMain, "Personal AccountCreated Successfully", windowName);
                    refreshUI();
                } else {
                    MessageManager.giveAWarning(lblMain, "Select Account Type", windowName);
                    rbTypeC.requestFocus();
                }
            } else {
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
            cb_province.setOnAction(actionEvent -> {
                try {
                    cb_city.getSelectionModel().clearSelection();
                    List<City> cities = CityManager.getCitys(cb_province.getSelectionModel().getSelectedItem());
                    for (City c : cities) {
                        cb_city.getItems().add(c.getCity());
                    }
                } catch (ExecutionException | IOException | InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
    }

    @FXML
    void rbTypeCOnKeyRelease(KeyEvent event) {
        if (event.getCode().equals(KeyCode.ENTER)) {
            txt_name.requestFocus();
            txt_Day.setDisable(true);
            txt_year.setDisable(true);
            txt_Mounth.setDisable(true);
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
        if (event.getCode().equals(KeyCode.ENTER)) {
            txt_rePassword.requestFocus();
        }
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

    public void refreshUI() {
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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        lblMain.setText(windowName);
        rbTypeC.requestFocus();

        try {

            provinces = ProvinceManager.getProvinces();
            for (Province p : provinces) {
                cb_province.getItems().add(p.getProvince());
            }
        } catch (ExecutionException | InterruptedException | IOException e) {
            e.printStackTrace();
        }
        cb_province.setOnAction(actionEvent -> {
            try {
                cb_city.getSelectionModel().clearSelection();

                cities = CityManager.getCitys(provinces.get(cb_province.getSelectionModel().getSelectedIndex()).getId());
                for (City c : cities) {
                    cb_city.getItems().add(c.getCity());
                }
            } catch (ExecutionException | IOException | InterruptedException e) {
                e.printStackTrace();
            }
        });

        cb_city.setOnAction(actionEvent -> {
            try {
                cb_area.getSelectionModel().clearSelection();

                areas = AreaManager.getAreas(cities.get(cb_city.getSelectionModel().getSelectedIndex()).getId());
                for (Area a : areas) {
                    cb_area.getItems().add(a.getArea());
                }
            } catch (ExecutionException | IOException | InterruptedException e) {
                e.printStackTrace();
            }
        });
    }

    public void cb_area_OnMouseClicked(MouseEvent mouseEvent) {
    }

    public void cb_city_OnMouseClicked(MouseEvent mouseEvent) {
    }

    public void cb_province_OnMouseClicked(MouseEvent mouseEvent) {

    }
}
