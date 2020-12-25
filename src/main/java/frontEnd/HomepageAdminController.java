package frontEnd;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class HomepageAdminController {

    public static Stage stage;
    @FXML
    private Label lblMain;

    @FXML
    private JFXButton btnCoAc;

    @FXML
    private JFXButton btnMaUsAc;

    @FXML
    private JFXButton btnMaAd;

    @FXML
    private JFXButton btnMaLo;

    @FXML
    private JFXButton btnEx;

    @FXML
    private JFXButton btn_publishNotice;


    @FXML
    void btnExOnKeyReleased(KeyEvent event) {
        stage.close();
    }

    @FXML
    void btnExOnMouseClicked(MouseEvent event) {
        stage.close();
    }

    @FXML
    void btnMaAdOnKeyReleased(KeyEvent event) throws IOException {
        if (event.getCode().equals(KeyCode.ENTER)) {

            SelectAdvertisementController.stage = new Stage();
            Parent root = FXMLLoader.load(SelectAdvertisementController.class.getResource("SelectAdvertisement.fxml"));
            SelectAdvertisementController.stage.setScene(new Scene(root));
            SelectAdvertisementController.stage.show();
            stage.close();

        }
    }

    @FXML
    void btnMaAdOnMouseClicked(MouseEvent event) throws IOException {

        SelectAdvertisementController.stage = new Stage();
        Parent root = FXMLLoader.load(SelectAdvertisementController.class.getResource("SelectAdvertisement.fxml"));
        SelectAdvertisementController.stage.setScene(new Scene(root));
        SelectAdvertisementController.stage.show();
        stage.close();

    }

    @FXML
    void btnMaLoOnKeyReleased(KeyEvent event) {



    }

    @FXML
    void btnMaLoOnMouseClicked(MouseEvent event) {

    }

    @FXML
    void btnMaUsAcOnKeyReleased(KeyEvent event) throws IOException {

        if (event.getCode().equals(KeyCode.ENTER)) {

            AdminUserManageController.stage = new Stage();
            Parent root = FXMLLoader.load(AdminUserManageController.class.getResource("AdminUserManage.fxml"));
            AdminUserManageController.stage.setScene(new Scene(root));
            AdminUserManageController.stage.show();
            stage.close();

        }

    }

    @FXML
    void btnMaUsAcOnMouseClicked(MouseEvent event) throws IOException {

        AdminUserManageController.stage = new Stage();
        Parent root = FXMLLoader.load(AdminUserManageController.class.getResource("AdminUserManage.fxml"));
        AdminUserManageController.stage.setScene(new Scene(root));
        AdminUserManageController.stage.show();
        stage.close();

    }

    @FXML
    void btn_publishNotice_onKeyReleased(KeyEvent event) {



    }

    @FXML
    void btn_publishNotice_onMouseClicked(MouseEvent event) {

    }

}
