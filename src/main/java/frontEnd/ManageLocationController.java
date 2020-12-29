package frontEnd;

import backEnd.AreaManager;
import backEnd.CityManager;
import backEnd.MessageManager;
import backEnd.ProvinceManager;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import entites.Area;
import entites.City;
import entites.Province;
import entites.Tables.LocationTable;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.ExecutionException;

public class ManageLocationController implements Initializable {
    public static Stage stage;
    String windowName = "Manage Location";

    @FXML
    private Label lblMain;

    @FXML
    private JFXTextField txt_provinceId;

    @FXML
    private TableView<LocationTable> tbl_location;

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
    void btn_add_onKeyReleased(KeyEvent event) throws InterruptedException, ExecutionException, IOException {
        if (event.getCode().equals(KeyCode.ENTER)) {
            if (null == txt_cityId || null == txt_cityName || null == txt_areId || null == txt_areaName || null == txt_provinceId || null == txt_provinceName) {
                MessageManager.giveAWarning(lblMain, "Information Is Not Complete Please Fill All The Information", windowName);
            } else {
                try {
                    Province province = ProvinceManager.getProvince(txt_provinceId.getText());
                    if (province.getProvince().equals(txt_provinceName.getText())) {

                    } else {
                        ProvinceManager.updateProvince(new Province(txt_provinceId.getText(), txt_provinceName.getText()));
                        MessageManager.giveSuccessMessage(lblMain, "Province Updated Successfully", windowName);
                    }

                } catch (NullPointerException | ExecutionException | InterruptedException | IOException e) {
                    ProvinceManager.addProvince(new Province(txt_provinceId.getText(), txt_provinceName.getText()));
                    MessageManager.giveSuccessMessage(lblMain, "Province Added Successfully", windowName);
                }

                try {
                    City city = CityManager.getCity(txt_cityId.getText());
                    if (city.getCity().equals(txt_cityName.getText())) {

                    } else {
                        CityManager.updateCity(new City(txt_cityId.getText(), txt_cityName.getText(), txt_provinceId.getText()));
                        MessageManager.giveSuccessMessage(lblMain, "City Updated Successfully", windowName);
                    }

                } catch (NullPointerException e) {
                    CityManager.addCity(new City(txt_cityId.getText(), txt_cityName.getText(), txt_provinceId.getText()));
                    MessageManager.giveSuccessMessage(lblMain, "City Added Successfully", windowName);
                }

                try {
                    Area area = AreaManager.getArea(txt_areId.getText());
                    if (area.getArea().equals(txt_areaName.getText())) {

                    } else {
                        AreaManager.updateArea(new Area(txt_areId.getText(), txt_areaName.getText(), txt_cityId.getText()));
                        MessageManager.giveSuccessMessage(lblMain, "Area Updated Successfully", windowName);
                    }
                } catch (NullPointerException e) {
                    AreaManager.addArea(new Area(txt_areId.getText(), txt_areaName.getText(), txt_cityId.getText()));
                    MessageManager.giveSuccessMessage(lblMain, "Area Added Successfully", windowName);
                }

                LocationTable locationTable = new LocationTable(txt_provinceName.getText(), txt_cityName.getText(), txt_areaName.getText());
                tbl_location.getItems().add(locationTable);

                txt_areId.clear();
                txt_areaName.clear();
                txt_areId.requestFocus();

            }


        }
    }

    @FXML
    void btn_add_onMouseClicked(MouseEvent event) throws InterruptedException, ExecutionException, IOException {


        if (null == txt_cityId || null == txt_cityName || null == txt_areId || null == txt_areaName || null == txt_provinceId || null == txt_provinceName) {
            MessageManager.giveAWarning(lblMain, "Information Is Not Complete Please Fill All The Information", windowName);
        } else {
            try {
                Province province = ProvinceManager.getProvince(txt_provinceId.getText());
                if (province.getProvince().equals(txt_provinceName.getText())) {

                } else {
                    ProvinceManager.updateProvince(new Province(txt_provinceId.getText(), txt_provinceName.getText()));
                    MessageManager.giveSuccessMessage(lblMain, "Province Updated Successfully", windowName);
                }

            } catch (NullPointerException | ExecutionException | InterruptedException | IOException e) {
                ProvinceManager.addProvince(new Province(txt_provinceId.getText(), txt_provinceName.getText()));
                MessageManager.giveSuccessMessage(lblMain, "Province Added Successfully", windowName);
            }

            try {
                City city = CityManager.getCity(txt_cityId.getText());
                if (city.getCity().equals(txt_cityName.getText())) {

                } else {
                    CityManager.updateCity(new City(txt_cityId.getText(), txt_cityName.getText(), txt_provinceId.getText()));
                    MessageManager.giveSuccessMessage(lblMain, "City Updated Successfully", windowName);
                }

            } catch (NullPointerException e) {
                CityManager.addCity(new City(txt_cityId.getText(), txt_cityName.getText(), txt_provinceId.getText()));
                MessageManager.giveSuccessMessage(lblMain, "City Added Successfully", windowName);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                Area area = AreaManager.getArea(txt_areId.getText());
                if (area.getArea().equals(txt_areaName.getText())) {

                } else {
                    AreaManager.updateArea(new Area(txt_areId.getText(), txt_areaName.getText(), txt_cityId.getText()));
                    MessageManager.giveSuccessMessage(lblMain, "Area Updated Successfully", windowName);
                }
            } catch (NullPointerException e) {
                AreaManager.addArea(new Area(txt_areId.getText(), txt_areaName.getText(), txt_cityId.getText()));
                MessageManager.giveSuccessMessage(lblMain, "Area Added Successfully", windowName);
            }

            LocationTable locationTable = new LocationTable(txt_provinceName.getText(), txt_cityName.getText(), txt_areaName.getText());
            tbl_location.getItems().add(locationTable);

            txt_areId.clear();
            txt_areaName.clear();
            txt_areId.requestFocus();

        }


    }

    @FXML
    void btn_cancle_onKeyReleased(KeyEvent event) throws IOException {

        if (event.getCode().equals(KeyCode.ENTER)) {
            stage.close();
        }
    }

    @FXML
    void btn_cancle_onMouseClicked(MouseEvent event) throws IOException {

        stage.close();

    }


    @FXML
    void txt_areId_onKeyReleased(KeyEvent event) {
        if (event.getCode().equals(KeyCode.ENTER)) {
            try {
                Area area = AreaManager.getArea(txt_areId.getText());
                txt_areaName.setText(area.getArea());
                City city = CityManager.getCity(area.getCityId());
                txt_cityId.setText(city.getId());
                txt_cityName.setText(city.getCity());
                Province province = ProvinceManager.getProvince(city.getProvinceId());
                txt_provinceId.setText(province.getId());
                txt_provinceName.setText(province.getProvince());
                txt_areaName.requestFocus();

            } catch (NullPointerException | ExecutionException | InterruptedException | IOException e) {
                txt_areaName.requestFocus();
            }
        }

    }

    @FXML
    void txt_areId_onMouseClicked(MouseEvent event) {

    }

    @FXML
    void txt_areaName_onKeyReleased(KeyEvent event) {
        if (event.getCode().equals(KeyCode.ENTER)) {
            txt_cityId.requestFocus();
        }
    }

    @FXML
    void txt_areaName_onMouseClicked(MouseEvent event) {

    }

    @FXML
    void txt_cityId_onKeyReleased(KeyEvent event) throws InterruptedException, ExecutionException, IOException {
        if (event.getCode().equals(KeyCode.ENTER)) {
            try {
                City city = CityManager.getCity(txt_cityId.getId());
                txt_cityName.setText(city.getCity());
                txt_cityName.requestFocus();
                Province province = ProvinceManager.getProvince(city.getProvinceId());
                txt_provinceId.setText(province.getId());
                txt_provinceName.setText(province.getProvince());
            } catch (NullPointerException e) {
                txt_cityName.requestFocus();
            }


        }

    }

    @FXML
    void txt_cityId_onMouseClicked(MouseEvent event) {

    }

    @FXML
    void txt_cityName_onKeyReleased(KeyEvent event) {
        if (event.getCode().equals(KeyCode.ENTER)) {
            txt_provinceId.requestFocus();
        }
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
                txt_provinceName.requestFocus();
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

        if (event.getCode().equals(KeyCode.ENTER)) {
            btn_add.requestFocus();
        }

    }

    @FXML
    void txt_provinceName_onMouseClicked(MouseEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setTable();
    }


    private void setTable() {
        tbl_location.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("province"));
        tbl_location.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("area"));
        tbl_location.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("city"));
    }
}
