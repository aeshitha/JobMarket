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
    public JFXButton btn_creatAdminAccount;
    public JFXButton btn_message;
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
        if (event.getCode().equals(KeyCode.ENTER)) {
            stage.close();
        }
    }

    @FXML
    void btnExOnMouseClicked(MouseEvent event) {
        stage.close();
    }

    @FXML
    void btnMaAdOnKeyReleased(KeyEvent event) throws IOException {
        if (event.getCode().equals(KeyCode.ENTER)) {
            AdminManageUserController.function = "add";
            AdminManageUserController.stage = new Stage();
            Parent root = FXMLLoader.load(AdminManageUserController.class.getResource("AdimManageUser.fxml"));
            AdminManageUserController.stage.setScene(new Scene(root));
            AdminManageUserController.stage.show();

        }
    }

    @FXML
    void btnMaAdOnMouseClicked(MouseEvent event) throws IOException {
        AdminManageUserController.function = "add";
        AdminManageUserController.stage = new Stage();
        Parent root = FXMLLoader.load(AdminManageUserController.class.getResource("AdimManageUser.fxml"));
        AdminManageUserController.stage.setScene(new Scene(root));
        AdminManageUserController.stage.show();

    }

    @FXML
    void btnMaLoOnKeyReleased(KeyEvent event) throws IOException {

        if (event.getCode().equals(KeyCode.ENTER)) {
            ManageLocationController.stage = new Stage();
            Parent root = FXMLLoader.load(ManageLocationController.class.getResource("ManageLocation.fxml"));
            ManageLocationController.stage.setScene(new Scene(root));
            ManageLocationController.stage.show();
        }

    }

    @FXML
    void btnMaLoOnMouseClicked(MouseEvent event) throws IOException {

        ManageLocationController.stage = new Stage();
        Parent root = FXMLLoader.load(ManageLocationController.class.getResource("ManageLocation.fxml"));
        ManageLocationController.stage.setScene(new Scene(root));
        ManageLocationController.stage.show();

    }

    @FXML
    void btnMaUsAcOnKeyReleased(KeyEvent event) throws IOException {
        if (event.getCode().equals(KeyCode.ENTER)) {
            AdminManageUserController.function = "user";
            AdminManageUserController.stage = new Stage();
            Parent root = FXMLLoader.load(AdminManageUserController.class.getResource("AdimManageUser.fxml"));
            AdminManageUserController.stage.setScene(new Scene(root));
            AdminManageUserController.stage.show();

        }

    }

    @FXML
    void btnMaUsAcOnMouseClicked(MouseEvent event) throws IOException {
        AdminManageUserController.function = "user";
        AdminManageUserController.stage = new Stage();
        Parent root = FXMLLoader.load(AdminManageUserController.class.getResource("AdimManageUser.fxml"));
        AdminManageUserController.stage.setScene(new Scene(root));
        AdminManageUserController.stage.show();


    }

    @FXML
    void btn_publishNotice_onKeyReleased(KeyEvent event) {


    }

    @FXML
    void btn_publishNotice_onMouseClicked(MouseEvent event) {

    }

    public void btn_creatAdminAccount_onKeyReleased(KeyEvent keyEvent) throws IOException {
        if (keyEvent.getCode().equals(KeyCode.ENTER)) {

            CreatAdminAccountController.stage = new Stage();
            Parent root = FXMLLoader.load(CreatAdminAccountController.class.getResource("CreatAdminAccount.fxml"));
            CreatAdminAccountController.stage.setScene(new Scene(root));
            CreatAdminAccountController.stage.show();

        }
    }

    public void btn_creatAdminAccount_onMouseClicked(MouseEvent mouseEvent) throws IOException {

        CreatAdminAccountController.stage = new Stage();
        Parent root = FXMLLoader.load(CreatAdminAccountController.class.getResource("CreatAdminAccount.fxml"));
        CreatAdminAccountController.stage.setScene(new Scene(root));
        CreatAdminAccountController.stage.show();

    }

    public void btn_message_OnKeyReleased(KeyEvent keyEvent) throws IOException {
        if (keyEvent.getCode().equals(KeyCode.ENTER)) {
            ViewMessageController.stage = new Stage();
            Parent root = FXMLLoader.load(ViewMessageController.class.getResource("ViewMessage.fxml"));
            ViewMessageController.stage.setScene(new Scene(root));
            ViewMessageController.stage.show();

        }
    }

    public void btn_message_OnMouseClicked(MouseEvent mouseEvent) throws IOException {
        ViewMessageController.stage = new Stage();
        Parent root = FXMLLoader.load(ViewMessageController.class.getResource("ViewMessage.fxml"));
        ViewMessageController.stage.setScene(new Scene(root));
        ViewMessageController.stage.show();
    }
}
