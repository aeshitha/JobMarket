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

public class ManageAccountController implements Initializable {


    List<Province> provinces;
    List<Area> areas;
    List<City> cities;
    String windowName = "Manage Account";

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
    void btn_submit_OnKeyRelease(KeyEvent event) throws InterruptedException, ExecutionException, IOException {
        if (event.getCode().equals(KeyCode.ENTER)) {
            User user = DataHolder.user;
            Date dob = null;

            if (user.getType().equals("company")) {
                UserManager.addUser(new User(user.getId(), user.getType(), txt_name.getText(), txt_email.getText(), Long.parseLong(txt_tenNo.getText()), null, cb_province.getSelectionModel().getSelectedItem().toString(), cb_city.getSelectionModel().getSelectedItem().toString(), cb_area.getSelectionModel().getSelectedItem().toString(), txt_password.getText(), txt_discription.getText()));
                MessageManager.giveSuccessMessage(lblMain, "Account Updated Successfully", windowName);
            } else {
                try {
                    dob = new SimpleDateFormat("dd/MM/yyyy").parse(txt_Day.getText() + "/" + txt_Mounth.getText() + "/" + txt_year.getText());
                } catch (ParseException ex) {
                    ex.printStackTrace();
                }
                UserManager.addUser(new User(user.getId(), user.getType(), txt_name.getText(), txt_email.getText(), Long.parseLong(txt_tenNo.getText()), dob, cb_province.getSelectionModel().getSelectedItem().toString(), cb_city.getSelectionModel().getSelectedItem().toString(), cb_area.getSelectionModel().getSelectedItem().toString(), txt_password.getText(), txt_discription.getText()));
                MessageManager.giveSuccessMessage(lblMain, "Account Updated Successfully", windowName);
            }
        }
    }

    @FXML
    void btn_submit_OnMouseClicked(MouseEvent event) throws InterruptedException, ExecutionException, IOException {

        User user = DataHolder.user;
        Date dob = null;

        if (user.getType().equals("company")) {
            UserManager.addUser(new User(user.getId(), user.getType(), txt_name.getText(), txt_email.getText(), Long.parseLong(txt_tenNo.getText()), null, cb_province.getSelectionModel().getSelectedItem().toString(), cb_city.getSelectionModel().getSelectedItem().toString(), cb_area.getSelectionModel().getSelectedItem().toString(), txt_password.getText(), txt_discription.getText()));
            MessageManager.giveSuccessMessage(lblMain, "Account Updated Successfully", windowName);
        } else {
            try {
                dob = new SimpleDateFormat("dd/MM/yyyy").parse(txt_Day.getText() + "/" + txt_Mounth.getText() + "/" + txt_year.getText());
            } catch (ParseException ex) {
                ex.printStackTrace();
            }
            UserManager.addUser(new User(user.getId(), user.getType(), txt_name.getText(), txt_email.getText(), Long.parseLong(txt_tenNo.getText()), dob, cb_province.getSelectionModel().getSelectedItem().toString(), cb_city.getSelectionModel().getSelectedItem().toString(), cb_area.getSelectionModel().getSelectedItem().toString(), txt_password.getText(), txt_discription.getText()));
            MessageManager.giveSuccessMessage(lblMain, "Account Updated Successfully", windowName);
        }
    }

    @FXML
    void cb_area_OnKeyRelease(KeyEvent event) {

        if (event.getCode().equals(KeyCode.ENTER)) {
            txt_password.requestFocus();
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
        cb_city.requestFocus();
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


    public void loadUser() {
        User user = DataHolder.user;
        txt_name.setText(user.getName());
        txt_email.setText(user.getEmail());
        txt_tenNo.setText(user.getTellNo().toString());
        txt_discription.setText(user.getDescription());
        cb_province.getSelectionModel().select(user.getProvince());
        try {
            cb_city.getSelectionModel().clearSelection();
            cities = CityManager.getCitys(provinces.get(cb_province.getSelectionModel().getSelectedIndex()).getId());
            for (City c : cities) {
                cb_city.getItems().add(c.getCity());
            }
            cb_city.getSelectionModel().select(user.getCity());
            cb_area.getSelectionModel().clearSelection();
            areas = AreaManager.getAreas(cities.get(cb_city.getSelectionModel().getSelectedIndex()).getId());
            for (Area a : areas) {
                cb_area.getItems().add(a.getArea());
            }
            cb_area.getSelectionModel().select(user.getArea());
        } catch (ExecutionException | IOException | InterruptedException e) {
            e.printStackTrace();
        }


        if (user.getType().equals("personal")) {
            txt_Day.setText(Integer.toString(user.getDob().getDay()));
            txt_Mounth.setText((Integer.toString(user.getDob().getMonth() + 1)));
            txt_year.setText(Integer.toString(user.getDob().getYear()));
        } else {
            txt_Day.setDisable(true);
            txt_year.setDisable(true);
            txt_Mounth.setDisable(true);


        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
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


        loadUser();

    }
}
