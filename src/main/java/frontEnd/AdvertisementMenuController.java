package frontEnd;

import backEnd.AdvertisementManager;
import backEnd.DBHandler;
import backEnd.DataHolder;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import entites.Advertisement;
import entites.User;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class AdvertisementMenuController {

    public static Stage stage;
    @FXML
    private Label lblMain;

    @FXML
    private JFXComboBox<?> cmb_advertisementType;

    @FXML
    private JFXComboBox<?> cmb_service;

    @FXML
    private JFXTextField txt_contactNumber;

    @FXML
    private JFXTextField txt_emailAddress;

    @FXML
    private JFXTextField txt_charges;

    @FXML
    private JFXTextField txt_chargesPer;

    @FXML
    private JFXCheckBox cBox_negotiable;

    @FXML
    private JFXComboBox<?> cmb_province;

    @FXML
    private JFXComboBox<?> cmb_city;

    @FXML
    private JFXComboBox<?> cmb_area;

    @FXML
    private JFXTextField txt_description;

    @FXML
    private JFXButton btn_submit;

    @FXML
    private JFXButton btn_refresh;

    @FXML
    private JFXButton btn_cancel;

    @FXML
    void btn_cancel_onKeyReleased(KeyEvent event) {
        if (event.getCode().equals(KeyCode.ENTER)) {
            stage.close();
        }
    }

    @FXML
    void btn_cancel_onMouseClicked(MouseEvent event) {
        stage.close();
    }

    @FXML
    void btn_refresh_onKeyReleased(KeyEvent event) {
        if (event.getCode().equals(KeyCode.ENTER)) {
            refreshUi();
        }
    }

    @FXML
    void btn_refresh_onMouseClicked(MouseEvent event) {
        refreshUi();
    }

    @FXML
    void btn_submit_onKeyReleased(KeyEvent event) throws InterruptedException, ExecutionException, IOException {
        if (event.getCode().equals(KeyCode.ENTER)) {
            User user = DataHolder.user;
            AdvertisementManager.addAdvertisement(new Advertisement());
        }
    }

    @FXML
    void btn_submit_onMouseClicked(MouseEvent event) {

    }

    @FXML
    void cBox_negotiable_onKeyReleased(KeyEvent event) {

    }

    @FXML
    void cBox_negotiable_onMouseClicked(MouseEvent event) {

    }

    @FXML
    void txt_chargesPer_onKeyReleased(KeyEvent event) {

    }

    @FXML
    void txt_chargesPer_onMouseClicked(MouseEvent event) {

    }

    @FXML
    void txt_charges_onKeyReleased(KeyEvent event) {

    }

    @FXML
    void txt_charges_onMouseClicked(MouseEvent event) {

    }

    @FXML
    void txt_contactNumber_onKeyReleased(KeyEvent event) {

    }

    @FXML
    void txt_contactNumber_onMouseClicked(MouseEvent event) {

    }

    @FXML
    void txt_description_onKeyReleased(KeyEvent event) {

    }

    @FXML
    void txt_description_onMouseClicked(MouseEvent event) {

    }

    @FXML
    void txt_emailAddress_onKeyReleased(KeyEvent event) {

    }

    @FXML
    void txt_emailAddress_onMouseClicked(MouseEvent event) {

    }


    public void refreshUi(){
        cmb_advertisementType.getSelectionModel().clearSelection();
        cmb_service.getSelectionModel().clearSelection();
        txt_contactNumber.clear();
        txt_emailAddress.clear();
        txt_charges.clear();
        txt_chargesPer.clear();
        cBox_negotiable.setSelected(false);
        cmb_province.getSelectionModel().clearSelection();
        cmb_area.getSelectionModel().clearSelection();
        cmb_city.getSelectionModel().clearSelection();
        cmb_advertisementType.requestFocus();
    }

}
