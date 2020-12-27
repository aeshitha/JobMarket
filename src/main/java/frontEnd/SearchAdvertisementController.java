package frontEnd;

import backEnd.*;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXListView;
import entites.*;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.concurrent.ExecutionException;

public class SearchAdvertisementController implements Initializable {

    public static Stage stage;
    public JFXButton btn_search;

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
        try {
            List<Service> services = ServiceManager.getServices();
            for (Service service:services) {
                cmb_service.getItems().add(service.getService());
            }
            List<Province> provinces = ProvinceManager.getProvinces();
            for (Province p:provinces) {
                cmb_province.getItems().add(p.getProvince());
            }
        } catch (ExecutionException | InterruptedException | IOException e) {
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
//        cmb_area.setOnAction(actionEvent -> {
//
//        });

    }

    private void search() throws InterruptedException, ExecutionException, IOException {
        List<Advertisement> advertisements = new ArrayList<>();
        if (!(null==cmb_area.getSelectionModel().getSelectedItem() || cmb_area.getSelectionModel().getSelectedItem().equals(""))){
            advertisements = AdvertisementManager.getAdvertisements(cmb_advertisementType.getSelectionModel().getSelectedItem(),
                    cmb_service.getSelectionModel().getSelectedItem(),cmb_area.getSelectionModel().getSelectedItem(),"area");
        }
        else if (!(null==cmb_city.getSelectionModel().getSelectedItem() || cmb_city.getSelectionModel().getSelectedItem().equals(""))){
            advertisements = AdvertisementManager.getAdvertisements(cmb_advertisementType.getSelectionModel().getSelectedItem(),
                    cmb_service.getSelectionModel().getSelectedItem(),cmb_area.getSelectionModel().getSelectedItem(),"city");
        }
        else if (!(null==cmb_province.getSelectionModel().getSelectedItem() || cmb_province.getSelectionModel().getSelectedItem().equals(""))){
            advertisements = AdvertisementManager.getAdvertisements(cmb_advertisementType.getSelectionModel().getSelectedItem(),
                    cmb_service.getSelectionModel().getSelectedItem(), cmb_area.getSelectionModel().getSelectedItem(), "province");
        }
        else {
            advertisements = AdvertisementManager.getAdvertisements();
        }
        if (advertisements.size()!=0) {
            for (Advertisement a : advertisements) {
                Pane p = new AnchorPane();
                p.setMaxWidth(lView_advertisement.getPrefWidth());
                Label lbl = new Label("ADD Type : "+ a.getType());
                lbl.setLayoutX(10);
                lbl.setLayoutY(10);
                Label lbl2 = new Label("Service : "+ a.getService());
                lbl2.setLayoutX(10);
                lbl2.setLayoutY(25);
                p.getChildren().add(lbl2);
                Label lbl3 = new Label("Charges per "+ a.getcPer() + " : "+ a.getCharges());
                lbl3.setLayoutX(10);
                lbl3.setLayoutY(40);
                p.getChildren().add(lbl3);
                Label lbl4 = new Label("Location : "+ a.getProvince());
                lbl4.setLayoutX(10);
                lbl4.setLayoutY(55);
                p.getChildren().add(lbl4);
                Label lbl5 = new Label("Description : "+ a.getDescription());
                lbl5.setLayoutX(10);
                lbl5.setLayoutY(70);
                p.getChildren().add(lbl5);
                Label lbl6 = new Label("Username : "+ a.getUserId());
                Label lbl7 = new Label("Contact No : "+ a.getContactNo());
                Label lbl8 = new Label("Mail : "+ a.getEmail());
                Button b = new Button();
                b.setText("Message");
                b.setLayoutX(70);
                b.setLayoutY(150);
                p.focusedProperty().addListener((observableValue, aBoolean, t1) -> {
                    if (t1){
                        lbl4.setText("Location : "+ a.getProvince() +","+a.getCity()+","+a.getArea());
                        p.getChildren().add(b);
                    }
                    else{
                        lbl4.setText("Location : "+ a.getProvince());
                        if(p.getChildren().contains(b)){
                            p.getChildren().remove(b);
                        }

                    }
                });
                lView_advertisement.getItems().add(p);
            }
        }
    }

    private void listItemClicked() {
    }


    public void btn_search_onMouseClicked(MouseEvent mouseEvent) throws InterruptedException, ExecutionException, IOException {
        search();
    }

    public void btn_search_onKeyReleased(KeyEvent keyEvent) throws InterruptedException, ExecutionException, IOException {
        if (keyEvent.getCode().equals(KeyCode.ENTER)){
            search();
        }
    }
}
