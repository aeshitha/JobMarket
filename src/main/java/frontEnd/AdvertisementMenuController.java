package frontEnd;

import backEnd.*;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import entites.*;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.concurrent.ExecutionException;

public class AdvertisementMenuController implements Initializable {

    public static Stage stage;
    public JFXButton btn_add;
    @FXML
    private Label lblMain;

    @FXML
    private JFXComboBox<String> cmb_advertisementType;

    @FXML
    private JFXComboBox<String> cmb_service;

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
    private JFXComboBox<String> cmb_province;

    @FXML
    private JFXComboBox<String> cmb_city;

    @FXML
    private JFXComboBox<String> cmb_area;

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
            addAdvertisement();
        }
    }

    private void addAdvertisement() {
        try {
            String nextAdvertisementId = AdvertisementManager.getNextAdvertisementId();
            Advertisement a = new Advertisement(nextAdvertisementId,cmb_advertisementType.getSelectionModel().getSelectedItem(),
                    cmb_service.getSelectionModel().getSelectedItem(),txt_contactNumber.getText(),txt_emailAddress.getText(),txt_charges.getText(),
                    txt_chargesPer.getText(),cBox_negotiable.isSelected(),cmb_province.getSelectionModel().getSelectedItem(),
                    cmb_city.getSelectionModel().getSelectedItem(),cmb_area.getSelectionModel().getSelectedItem(),
                    txt_description.getText(),DataHolder.user.getId()
            );
            AdvertisementManager.addAdvertisement(a);
        } catch (IOException | InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void btn_submit_onMouseClicked(MouseEvent event) throws InterruptedException, ExecutionException, IOException {
        AdvertisementManager.getNextAdvertisementId();
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cmb_advertisementType.setItems((ObservableList<String>) AdvertisementManager.types);
        try {
            List<Service> services = ServiceManager.getServices();
            for (Service service:services) {
                cmb_service.getItems().add(service.getService());
            }

        } catch (ExecutionException | InterruptedException | IOException e) {
            e.printStackTrace();
        }
        txt_contactNumber.setText(DataHolder.user.getTellNo().toString());
        txt_emailAddress.setText(DataHolder.user.getEmail());
        try {
            List<Province> provinces = ProvinceManager.getProvinces();
            for (Province p:provinces) {
                cmb_province.getItems().add(p.getProvince());
            }
        } catch (ExecutionException | IOException | InterruptedException e) {
            e.printStackTrace();
        }

        cmb_province.setOnAction(actionEvent -> {
            try {
                cmb_city.getSelectionModel().clearSelection();
                List<City> cities = CityManager.getCitys(cmb_province.getSelectionModel().getSelectedItem());
                for (City c:cities) {
                    cmb_city.getItems().add(c.getCity());
                }
            } catch (ExecutionException | IOException | InterruptedException e) {
                e.printStackTrace();
            }
        });

        cmb_city.setOnAction(actionEvent -> {
            try {
                cmb_area.getSelectionModel().clearSelection();
                List<Area> areas = AreaManager.getAreas(cmb_city.getSelectionModel().getSelectedItem());
                for (Area a:areas) {
                    cmb_area.getItems().add(a.getArea());
                }
            } catch (ExecutionException | IOException | InterruptedException e) {
                e.printStackTrace();
            }
        });



    }

    public void btn_add_onKeyReleased(KeyEvent keyEvent) {
    }

    public void btn_add_onMouseClicked(MouseEvent mouseEvent) {
    }
    private void add_service(){
       /* ServiceManager.
        ServiceManager.addService(new Service())*/
    }
}
