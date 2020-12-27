package frontEnd;

import backEnd.AdvertisementManager;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXListView;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class SearchAdvertisementController implements Initializable {

    public static Stage stage;

    @FXML
    private Label lblMain;

    @FXML
    private JFXButton btn_cancel;

    @FXML
    private JFXComboBox<String> cmb_advertisementType;

    @FXML
    private JFXComboBox<String> cmb_service;

    @FXML
    private JFXComboBox<String> cmb_province;

    @FXML
    private JFXComboBox<String> cmb_city;

    @FXML
    private JFXComboBox<String> cmb_area;

    @FXML
    private JFXListView<Pane> lView_advertisement;

    @FXML
    private JFXButton btn_next;

    @FXML
    private JFXButton btn_prev;

    @FXML
    void btn_cancel_onKeyReleased(KeyEvent event) {
        if (event.getCode().equals(KeyCode.ENTER)){
//            stage.close();
        }
    }

    @FXML
    void btn_cancel_onMouseClicked(MouseEvent event) {

    }

    @FXML
    void btn_next_onKeyReleased(KeyEvent event) {

    }

    @FXML
    void btn_next_onMouseClicked(MouseEvent event) {

    }

    @FXML
    void btn_prev_onKeyReleased(KeyEvent event) {

    }

    @FXML
    void btn_prev_onMouseClicked(MouseEvent event) {

    }

    @FXML
    void lView_advertisement_onKeyReleased(KeyEvent event) {

    }

    @FXML
    void lView_advertisement_onMouseClicked(MouseEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cmb_advertisementType.setItems((ObservableList<String>) AdvertisementManager.types);



    }
}
