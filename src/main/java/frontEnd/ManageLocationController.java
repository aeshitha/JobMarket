package frontEnd;

import backEnd.ProvinceManager;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import entites.Province;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

public class ManageLocationController {

    @FXML
    private Label lblMain;

    @FXML
    private JFXTextField txt_provinceId;

    @FXML
    private TableView<?> tbl_location;

    @FXML
    private JFXButton btn_add;

    @FXML
    private JFXTextField txt_cityId;

    @FXML
    private JFXTextField txt_areId;

    @FXML
    private JFXTextField txt_provinceName;

    @FXML
    private JFXTextField txt_cityName;

    @FXML
    private JFXTextField txt_areaName;

    @FXML
    private JFXButton btn_cancle;

    @FXML
    private JFXButton btn_save;

    @FXML
    void btn_add_onKeyReleased(KeyEvent event) {
        if (event.getCode().equals(KeyCode.ENTER)) {


        }
    }

    @FXML
    void btn_add_onMouseClicked(MouseEvent event) {

    }

    @FXML
    void btn_cancle_onKeyReleased(KeyEvent event) {

    }

    @FXML
    void btn_cancle_onMouseClicked(MouseEvent event) {

    }

    @FXML
    void btn_save_onKeyReleased(KeyEvent event) {

    }

    @FXML
    void btn_save_onMouseClicked(MouseEvent event) {

    }

    @FXML
    void txt_areId_onKeyReleased(KeyEvent event) {

    }

    @FXML
    void txt_areId_onMouseClicked(MouseEvent event) {

    }

    @FXML
    void txt_areaName_onKeyReleased(KeyEvent event) {

    }

    @FXML
    void txt_areaName_onMouseClicked(MouseEvent event) {

    }

    @FXML
    void txt_cityId_onKeyReleased(KeyEvent event) {

    }

    @FXML
    void txt_cityId_onMouseClicked(MouseEvent event) {

    }

    @FXML
    void txt_cityName_onKeyReleased(KeyEvent event) {

    }

    @FXML
    void txt_cityName_onMouseClicked(MouseEvent event) {

    }

    @FXML
    void txt_provinceId_onKeyReleased(KeyEvent event) throws InterruptedException, ExecutionException, IOException {
        if (event.getCode().equals(KeyCode.ENTER)) {


            try {
                Province province = ProvinceManager.getProvince(txt_provinceId.getText());
                txt_provinceName.setText(province.getProvince());
                txt_cityId.requestFocus();
            } catch (NullPointerException e) {
                txt_provinceName.requestFocus();
            }


        }
    }

    @FXML
    void txt_provinceId_onMouseClicked(MouseEvent event) {

    }

    @FXML
    void txt_provinceName_onKeyReleased(KeyEvent event) {

    }

    @FXML
    void txt_provinceName_onMouseClicked(MouseEvent event) {

    }

}
