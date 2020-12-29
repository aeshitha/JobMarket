package frontEnd;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HomepageCompanyController implements Initializable {


    String windowName = "Company Menu";
    public static Stage stage;
    @FXML
    private Label lblMain;

    @FXML
    private JFXButton btnExit;

    @FXML
    private JFXButton btnCrAd;

    @FXML
    private JFXButton btnMaAd;

    @FXML
    private JFXButton btnSeAd;

    @FXML
    private JFXButton btnJobReq;

    @FXML
    private JFXButton btnMes;

    @FXML
    private JFXButton btnEdAc;

    @FXML
    void btnCrAdOnKeyReleased(KeyEvent event) throws IOException {


        if (event.getCode().equals(KeyCode.ENTER)) {

            AdvertisementMenuController.stage = new Stage();
            Parent root = FXMLLoader.load(AdvertisementMenuController.class.getResource("AdvertisementMenu.fxml"));
            AdvertisementMenuController.stage.setScene(new Scene(root));
            AdvertisementMenuController.stage.show();

        }

    }

    @FXML
    void btnCrAdOnMouseClicked(MouseEvent event) throws IOException {

        AdvertisementMenuController.stage = new Stage();
        Parent root = FXMLLoader.load(AdvertisementMenuController.class.getResource("AdvertisementMenu.fxml"));
        AdvertisementMenuController.stage.setScene(new Scene(root));
        AdvertisementMenuController.stage.show();

    }

    @FXML
    void btnEdAcOnKeyReleased(KeyEvent event) throws IOException {

        if (event.getCode().equals(KeyCode.ENTER)) {
            ManageAccountController.stage = new Stage();
            Parent root = FXMLLoader.load(ManageAccountController.class.getResource("ManageAccount.fxml"));
            ManageAccountController.stage.setScene(new Scene(root));
            ManageAccountController.stage.show();
        }

    }

    @FXML
    void btnEdAcOnMouseClicked(MouseEvent event) throws IOException {

        ManageAccountController.stage = new Stage();
        Parent root = FXMLLoader.load(ManageAccountController.class.getResource("ManageAccount.fxml"));
        ManageAccountController.stage.setScene(new Scene(root));
        ManageAccountController.stage.show();

    }

    @FXML
    void btnExitOnKeyReleased(KeyEvent event) {
        if (event.getCode().equals(KeyCode.ENTER)) {
            stage.close();
        }
    }

    @FXML
    void btnExitOnMouseClicked(MouseEvent event) {

        stage.close();

    }

    @FXML
    void btnJobReqOnKeyReleased(KeyEvent event) {

    }

    @FXML
    void btnJobReqOnMouseClicked(MouseEvent event) {

    }

    @FXML
    void btnMaAdOnKeyReleased(KeyEvent event) throws IOException {

        if (event.getCode().equals(KeyCode.ENTER)) {
            AdminManageUserController.function = "add";
            AdminManageUserController.stage = new Stage();
            Parent root = FXMLLoader.load(AdminManageUserController.class.getResource("AdimManageUer.fxml"));
            AdminManageUserController.stage.setScene(new Scene(root));
            AdminManageUserController.stage.show();
        }

    }

    @FXML
    void btnMaAdOnMouseClicked(MouseEvent event) throws IOException {

        AdminManageUserController.function = "add";
        AdminManageUserController.stage = new Stage();
        Parent root = FXMLLoader.load(AdminManageUserController.class.getResource("AdimManageUer.fxml"));
        AdminManageUserController.stage.setScene(new Scene(root));
        AdminManageUserController.stage.show();

    }

    @FXML
    void btnMesOnKeyReleased(KeyEvent event) throws IOException {


        if (event.getCode().equals(KeyCode.ENTER)) {
            ViewMessageController.stage = new Stage();
            Parent root = FXMLLoader.load(ViewMessageController.class.getResource("ViewMessage.fxml"));
            ViewMessageController.stage.setScene(new Scene(root));
            ViewMessageController.stage.show();
        }


    }

    @FXML
    void btnMesOnMouseClicked(MouseEvent event) throws IOException {

        ViewMessageController.stage = new Stage();
        Parent root = FXMLLoader.load(ViewMessageController.class.getResource("ViewMessage.fxml"));
        ViewMessageController.stage.setScene(new Scene(root));
        ViewMessageController.stage.show();

    }

    @FXML
    void btnSeAdOnKeyReleased(KeyEvent event) throws IOException {

        if (event.getCode().equals(KeyCode.ENTER)) {
            SearchAdvertisementController.stage = new Stage();
            Parent root = FXMLLoader.load(SearchAdvertisementController.class.getResource("SearchAdvertisement.fxml"));
            SearchAdvertisementController.stage.setScene(new Scene(root));
            SearchAdvertisementController.stage.show();
        }

    }

    @FXML
    void btnSeAdOnMouseClicked(MouseEvent event) throws IOException {

        SearchAdvertisementController.stage = new Stage();
        Parent root = FXMLLoader.load(SearchAdvertisementController.class.getResource("SearchAdvertisement.fxml"));
        SearchAdvertisementController.stage.setScene(new Scene(root));
        SearchAdvertisementController.stage.show();

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        lblMain.setText(windowName);

    }
}
