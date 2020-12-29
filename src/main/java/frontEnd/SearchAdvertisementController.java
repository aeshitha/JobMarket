package frontEnd;

import backEnd.*;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXListView;
import entites.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
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

    String windowName = "Search Advertisement";
    public static Stage stage;
    public JFXButton btn_search;

    List<Service> services;
    List<Province> provinces;
    List<City> cities;

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
            stage.close();
        }
    }

    @FXML
    void btn_cancel_onMouseClicked(MouseEvent event) {
        stage.close();
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
        lblMain.setText(windowName);
        cmb_advertisementType.getItems().addAll(AdvertisementManager.types);
        try {
            services = ServiceManager.getServices();
            for (Service service:services) {
                cmb_service.getItems().add(service.getService());
            }
            provinces = ProvinceManager.getProvinces();
            for (Province p:provinces) {
                cmb_province.getItems().add(p.getProvince());
            }
        } catch (ExecutionException | InterruptedException | IOException e) {
            e.printStackTrace();
        }
        cmb_province.setOnAction(actionEvent -> {
            System.out.println("out side the try");
            try {
                System.out.println("inside the try");
                cmb_city.getSelectionModel().clearSelection();

                cities = CityManager.getCitys(provinces.get(cmb_province.getSelectionModel().getSelectedIndex()).getId());
                for (City c : cities) {
                    cmb_city.getItems().add(c.getCity());
                    System.out.println("inside the loop");
                    ;
                }
            } catch (ExecutionException | IOException | InterruptedException e) {
                System.out.println("in the catch");
                e.printStackTrace();
            }
        });

        cmb_city.setOnAction(actionEvent -> {
            try {
                cmb_area.getSelectionModel().clearSelection();
                List<Area> areas = AreaManager.getAreas(cities.get(cmb_city.getSelectionModel().getSelectedIndex()).getId());
                for (Area a:areas) {
                    cmb_area.getItems().add(a.getArea());
                }
            } catch (ExecutionException | IOException | InterruptedException e) {
                e.printStackTrace();
            }
        });
        try {
            search();
        } catch (InterruptedException | ExecutionException | IOException e) {
            e.printStackTrace();
        }
//        cmb_area.setOnAction(actionEvent -> {
//
//        });

    }

    private void search() throws InterruptedException, ExecutionException, IOException {

        List<Advertisement> advertisements = new ArrayList<>();
        if (!(null==cmb_area.getSelectionModel().getSelectedItem() || cmb_area.getSelectionModel().getSelectedItem().equals(""))){
            System.out.println("case 1");
            advertisements = AdvertisementManager.getAdvertisements(cmb_advertisementType.getSelectionModel().getSelectedItem(),
                    cmb_service.getSelectionModel().getSelectedItem(),cmb_area.getSelectionModel().getSelectedItem(),"area");
        }
        else if (!(null==cmb_city.getSelectionModel().getSelectedItem() || cmb_city.getSelectionModel().getSelectedItem().equals(""))){
            System.out.println("case 2");
            advertisements = AdvertisementManager.getAdvertisements(cmb_advertisementType.getSelectionModel().getSelectedItem(),
                    cmb_service.getSelectionModel().getSelectedItem(),cmb_area.getSelectionModel().getSelectedItem(),"city");
        }
        else if (!(null==cmb_province.getSelectionModel().getSelectedItem() || cmb_province.getSelectionModel().getSelectedItem().equals(""))){
            System.out.println("case 3");
            advertisements = AdvertisementManager.getAdvertisements(cmb_advertisementType.getSelectionModel().getSelectedItem(),
                    cmb_service.getSelectionModel().getSelectedItem(), cmb_area.getSelectionModel().getSelectedItem(), "province");
        }
        else {
            System.out.println("case 4");
            advertisements = AdvertisementManager.getAdvertisements();
        }
        System.out.println(advertisements.size());
        if (advertisements.size()!=0) {
            for (Advertisement a : advertisements) {
                Pane p = new AnchorPane();
                p.setMaxWidth(lView_advertisement.getPrefWidth());
                Label lbl = new Label("ADD Type : "+ a.getType());
                lbl.setLayoutX(10);
                lbl.setLayoutY(0);
                p.getChildren().add(lbl);
                Label lbl2 = new Label("Service : "+ a.getService());
                lbl2.setLayoutX(10);
                lbl2.setLayoutY(15);
                p.getChildren().add(lbl2);
                Label lbl3 = new Label("Charges per "+ a.getcPer() + " : "+ a.getCharges());
                lbl3.setLayoutX(10);
                lbl3.setLayoutY(30);
                p.getChildren().add(lbl3);
                Label lbl4 = new Label("Location : "+ a.getProvince());
                lbl4.setLayoutX(10);
                lbl4.setLayoutY(45);
                p.getChildren().add(lbl4);
                Label lbl5 = new Label("Description : "+ a.getDescription());
                lbl5.setLayoutX(10);
                lbl5.setLayoutY(60);
                p.getChildren().add(lbl5);
                Label lbl6 = new Label("Username : "+ a.getUserId());
                lbl6.setLayoutX(10);
                lbl6.setLayoutY(75);
                Label lbl7 = new Label("Contact No : "+ a.getContactNo());
                lbl7.setLayoutX(10);
                lbl7.setLayoutY(90);
                Label lbl8 = new Label("Mail : "+ a.getEmail());
                lbl8.setLayoutX(10);
                lbl8.setLayoutY(105);
                Button b = new Button();
                b.setText("Message");
                b.setLayoutX(300);
                b.setLayoutY(100);
                b.setOnAction(actionEvent -> {
                    try {
                        message(a.getUserId(),a.getId());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
                Button b2 = new Button();
                b2.setText("Report");
                b2.setLayoutX(375);
                b2.setLayoutY(100);
                b2.setOnAction(actionEvent -> {
                    try {
                        message("admin",a.getId());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
                p.setOnMouseReleased(mouseEvent -> {
                    p.requestFocus();
                });
                p.focusedProperty().addListener((observableValue, aBoolean, t1) -> {
                    System.out.println("focus : " + t1);
                    if (t1){
                        lbl4.setText("Location : "+ a.getProvince() +","+a.getCity()+","+a.getArea());
                        p.getChildren().add(b);
                        p.getChildren().add(b2);
                        p.getChildren().addAll(lbl6,lbl7,lbl8);
                    }
                    else if(!b.isFocused()){
                        lbl4.setText("Location : "+ a.getProvince());
                        p.getChildren().remove(b);
                        p.getChildren().remove(b2);
                        p.getChildren().removeAll(lbl6,lbl7,lbl8);


                    }
                });
                lView_advertisement.getItems().add(p);
                lView_advertisement.refresh();
            }
        }
    }

    public static void message(String to,String addId) throws IOException {
        ApplyAdvertisementController.stage = new Stage();

        ApplyAdvertisementController.messageTo = to;
        ApplyAdvertisementController.addId = addId;
        Parent root = FXMLLoader.load(ApplyAdvertisementController.class.getResource("ApplyAdvertisement.fxml"));
        ApplyAdvertisementController.stage.setScene(new Scene(root));
        ApplyAdvertisementController.stage.show();
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
