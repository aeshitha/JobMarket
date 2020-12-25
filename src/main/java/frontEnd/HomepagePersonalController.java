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

public class HomepagePersonalController {

    Stage stage;
    @FXML
    private Label lblMain;

    @FXML
    private JFXButton btnCrAd;

    @FXML
    private JFXButton btnMaAd;

    @FXML
    private JFXButton btnSeAd;

    @FXML
    private JFXButton btnMe;

    @FXML
    private JFXButton btnEdAc;

    @FXML
    private JFXButton btnEx;

    @FXML
    void btnCrAdOnKeyReleased(KeyEvent event) throws IOException {

        if (event.getCode().equals(KeyCode.ENTER)) {

            AdvertisementMenuController.stage = new Stage();
            Parent root = FXMLLoader.load(AdvertisementMenuController.class.getResource("AdvertisementMenu.fxml"));
            AdvertisementMenuController.stage.setScene(new Scene(root));
            AdvertisementMenuController.stage.show();
            stage.close();

        }


    }

    @FXML
    void btnCrAdOnMouseClicked(MouseEvent event) throws IOException {

        AdvertisementMenuController.stage = new Stage();
        Parent root = FXMLLoader.load(AdvertisementMenuController.class.getResource("AdvertisementMenu.fxml"));
        AdvertisementMenuController.stage.setScene(new Scene(root));
        AdvertisementMenuController.stage.show();
        stage.close();

    }

    @FXML
    void btnEdAcOnKeyReleased(KeyEvent event) throws IOException {

        if (event.getCode().equals(KeyCode.ENTER)) {
            ManageAccountController.stage = new Stage();
            Parent root = FXMLLoader.load(ManageAccountController.class.getResource("ManageAccount.fxml"));
            ManageAccountController.stage.setScene(new Scene(root));
            ManageAccountController.stage.show();
            stage.close();
        }

    }

    @FXML
    void btnEdAcOnMouseClicked(MouseEvent event) throws IOException {

        ManageAccountController.stage = new Stage();
        Parent root = FXMLLoader.load(ManageAccountController.class.getResource("ManageAccount.fxml"));
        ManageAccountController.stage.setScene(new Scene(root));
        ManageAccountController.stage.show();
        stage.close();

    }

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
    void btnMeOnKeyReleased(KeyEvent event) {

    }

    @FXML
    void btnMeOnMouseClicked(MouseEvent event) {

    }

    @FXML
    void btnSeAdOnKeyReleased(KeyEvent event) throws IOException {

        if (event.getCode().equals(KeyCode.ENTER)) {
            SearchAdvertisementController.stage = new Stage();
            Parent root = FXMLLoader.load(SearchAdvertisementController.class.getResource("SearchAdvertisement.fxml"));
            SearchAdvertisementController.stage.setScene(new Scene(root));
            SearchAdvertisementController.stage.show();
            stage.close();
        }
    }

    @FXML
    void btnSeAdOnMouseClicked(MouseEvent event) throws IOException {

        SearchAdvertisementController.stage = new Stage();
        Parent root = FXMLLoader.load(SearchAdvertisementController.class.getResource("SearchAdvertisement.fxml"));
        SearchAdvertisementController.stage.setScene(new Scene(root));
        SearchAdvertisementController.stage.show();
        stage.close();

    }

}
