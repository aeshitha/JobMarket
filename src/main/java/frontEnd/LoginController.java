package frontEnd;

import backEnd.AdminManager;
import backEnd.DataHolder;
import backEnd.MessageManager;
import backEnd.UserManager;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import entites.Admin;
import entites.User;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.apache.tools.ant.launch.Launcher;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.ExecutionException;

public class LoginController implements Initializable {


    public static Stage stage;
    public RadioButton rb_admin;
    public AnchorPane pane;
    String windowName = "Login Menu";
    public Label lblMain;
    public JFXTextField txtUserName;
    public PasswordField txtPassword;
    public JFXButton btnLogin;
    public JFXButton btnExite;
    public JFXButton btnCreatAccount;

    public void txtIDOnKeyRelease(KeyEvent keyEvent) {
        if (keyEvent.getCode().equals(KeyCode.ENTER)) {
            User user;
            Admin admin;
            if (rb_admin.isSelected()) {
                try {
                    admin = AdminManager.getAdmin(txtUserName.getText());
                    MessageManager.giveSuccessMessage(lblMain, "Welcome! " + admin.getName(), windowName);
                    txtPassword.requestFocus();
                } catch (NullPointerException e) {
                    e.printStackTrace();
                    MessageManager.giveAWarning(lblMain, "Invalid ID!", windowName);
                    txtUserName.clear();
                    txtUserName.requestFocus();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {

                try {
                    user = UserManager.getUser(txtUserName.getText());


                    MessageManager.giveSuccessMessage(lblMain, "Welcome! " + user.getName(), windowName);
                    txtPassword.requestFocus();

                } catch (NullPointerException e) {
                    e.printStackTrace();
                    try {
                        User userCo = UserManager.getUserCo(txtUserName.getText());
                        MessageManager.giveSuccessMessage(lblMain, "Welcome! " + userCo.getName(), windowName);
                        txtPassword.requestFocus();
                    } catch (NullPointerException e1) {
                        e1.printStackTrace();
                        MessageManager.giveAWarning(lblMain, "Invalid User ID!", windowName);
                        txtUserName.clear();
                        txtUserName.requestFocus();
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    } catch (ExecutionException ex) {
                        ex.printStackTrace();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }


                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    public void txtPasswordOnKeyRelease(KeyEvent keyEvent) throws InterruptedException, ExecutionException, IOException {


        if (keyEvent.getCode().equals(KeyCode.ENTER)) {

            String type;
            Admin admin;
            User user;

            if (rb_admin.isSelected()) {

                admin = AdminManager.getAdmin(txtUserName.getText());
                DataHolder.admin = admin;
                if (admin.getPassword().equals(txtPassword.getText())) {

                    HomepageAdminController.stage = new Stage();
                    Parent root = FXMLLoader.load(HomepageAdminController.class.getResource("Homepage-Admin.fxml"));
                    HomepageAdminController.stage.setScene(new Scene(root));
                    HomepageAdminController.stage.setMaximized(true);
                    HomepageAdminController.stage.setResizable(false);
                    HomepageAdminController.stage.show();
                    stage.close();

                } else {
                    MessageManager.giveAWarning(lblMain, "Incorrect Password", windowName);
                    txtPassword.clear();
                    txtPassword.requestFocus();
                }

            } else {
                try {
                    user = UserManager.getUser(txtUserName.getText());
                    DataHolder.user = user;
                } catch (NullPointerException e) {
                    user = UserManager.getUserCo(txtUserName.getText());
                    DataHolder.user = user;
                }
                type = user.getType();
                if (user.getPassword().equals(txtPassword.getText())) {
                    if (type.equals("personal")) {
                        HomepagePersonalController.stage = new Stage();
                        Parent root = FXMLLoader.load(HomepagePersonalController.class.getResource("PersonalAccountMenue.fxml"));
                        HomepagePersonalController.stage.setScene(new Scene(root));
                        HomepagePersonalController.stage.setMaximized(true);
                        HomepagePersonalController.stage.setResizable(false);
                        HomepagePersonalController.stage.show();
                        stage.close();
                    } else {
                        HomepageCompanyController.stage = new Stage();
                        Parent root = FXMLLoader.load(HomepageCompanyController.class.getResource("HompageCompany.fxml"));
                        HomepageCompanyController.stage.setScene(new Scene(root));
                        HomepageCompanyController.stage.setMaximized(true);
                        HomepageCompanyController.stage.setResizable(false);
                        HomepageCompanyController.stage.show();
                        stage.close();
                    }
                } else {
                    MessageManager.giveAWarning(lblMain, "Incorrect Password", windowName);
                    txtPassword.clear();
                    txtPassword.requestFocus();
                }
            }
        }
    }


    public void btnLoginOnKeyRelease(KeyEvent keyEvent) throws InterruptedException, ExecutionException, IOException {
        if (keyEvent.getCode().equals(KeyCode.ENTER)) {

            String type;
            Admin admin;
            User user;

            if (rb_admin.isSelected()) {

                admin = AdminManager.getAdmin(txtUserName.getText());
                DataHolder.admin = admin;
                if (admin.getPassword().equals(txtPassword.getText())) {

                    HomepageAdminController.stage = new Stage();
                    Parent root = FXMLLoader.load(HomepageAdminController.class.getResource("Homepage-Admin.fxml"));
                    HomepageAdminController.stage.setScene(new Scene(root));
                    HomepageAdminController.stage.setMaximized(true);
                    HomepageAdminController.stage.setResizable(false);
                    HomepageAdminController.stage.show();
                    stage.close();

                } else {
                    MessageManager.giveAWarning(lblMain, "Incorrect Password", windowName);
                    txtPassword.clear();
                    txtPassword.requestFocus();
                }

            } else {
                try {
                    user = UserManager.getUser(txtUserName.getText());
                    DataHolder.user = user;
                } catch (NullPointerException e) {
                    user = UserManager.getUserCo(txtUserName.getText());
                    DataHolder.user = user;
                }
                type = user.getType();
                if (user.getPassword().equals(txtPassword.getText())) {
                    if (type.equals("personal")) {
                        HomepagePersonalController.stage = new Stage();
                        Parent root = FXMLLoader.load(HomepagePersonalController.class.getResource("PersonalAccountMenue.fxml"));
                        HomepagePersonalController.stage.setScene(new Scene(root));
                        HomepagePersonalController.stage.setMaximized(true);
                        HomepagePersonalController.stage.setResizable(false);
                        HomepagePersonalController.stage.show();
                        stage.close();
                    } else {
                        HomepageCompanyController.stage = new Stage();
                        Parent root = FXMLLoader.load(HomepageCompanyController.class.getResource("HompageCompany.fxml"));
                        HomepageCompanyController.stage.setScene(new Scene(root));
                        HomepageCompanyController.stage.setMaximized(true);
                        HomepageCompanyController.stage.setResizable(false);
                        HomepageCompanyController.stage.show();
                        stage.close();
                    }
                } else {
                    MessageManager.giveAWarning(lblMain, "Incorrect Password", windowName);
                    txtPassword.clear();
                    txtPassword.requestFocus();
                }
            }
        }
    }

    public void btnLoginOnMouseClicked(MouseEvent mouseEvent) throws InterruptedException, ExecutionException, IOException {


        String type;
        Admin admin;
        User user;

        if (rb_admin.isSelected()) {

            admin = AdminManager.getAdmin(txtUserName.getText());
            DataHolder.admin = admin;
            if (admin.getPassword().equals(txtPassword.getText())) {

                HomepageAdminController.stage = new Stage();
                Parent root = FXMLLoader.load(HomepageAdminController.class.getResource("Homepage-Admin.fxml"));
                HomepageAdminController.stage.setScene(new Scene(root));
                HomepageAdminController.stage.setMaximized(true);
                HomepageAdminController.stage.setResizable(false);
                HomepageAdminController.stage.show();
                stage.close();

            } else {
                MessageManager.giveAWarning(lblMain, "Incorrect Password", windowName);
                txtPassword.clear();
                txtPassword.requestFocus();
            }

        } else {
            try {
                user = UserManager.getUser(txtUserName.getText());
                DataHolder.user = user;
            } catch (NullPointerException e) {
                user = UserManager.getUserCo(txtUserName.getText());
                DataHolder.user = user;
            }
            type = user.getType();
            if (user.getPassword().equals(txtPassword.getText())) {
                if (type.equals("personal")) {
                    HomepagePersonalController.stage = new Stage();
                    Parent root = FXMLLoader.load(HomepagePersonalController.class.getResource("PersonalAccountMenue.fxml"));
                    HomepagePersonalController.stage.setScene(new Scene(root));
                    HomepagePersonalController.stage.setMaximized(true);
                    HomepagePersonalController.stage.setResizable(false);
                    HomepagePersonalController.stage.show();
                    stage.close();
                } else {
                    HomepageCompanyController.stage = new Stage();
                    Parent root = FXMLLoader.load(HomepageCompanyController.class.getResource("HompageCompany.fxml"));
                    HomepageCompanyController.stage.setScene(new Scene(root));
                    HomepageCompanyController.stage.setMaximized(true);
                    HomepageCompanyController.stage.setResizable(false);
                    HomepageCompanyController.stage.show();
                    stage.close();
                }
            } else {
                MessageManager.giveAWarning(lblMain, "Incorrect Password", windowName);
                txtPassword.clear();
                txtPassword.requestFocus();
            }
        }
    }


    public void btnExiteOnKeyRelease(KeyEvent keyEvent) {
        stage.close();
    }

    public void btnExiteOnMouseClicked(MouseEvent mouseEvent) {
        stage.close();
    }

    public void btnCreatAccountOnKeyRelease(KeyEvent keyEvent) throws IOException {
        if (keyEvent.getCode().equals(KeyCode.ENTER)){


            CreatAccountController.stage = new Stage();
            Parent root = FXMLLoader.load(CreatAccountController.class.getResource("CreatAccount.fxml"));
            CreatAccountController.stage.setScene(new Scene(root));
            CreatAccountController.stage.show();
            stage.close();

        }
    }

    public void btnCreatAccountOnMouseClicked(MouseEvent mouseEvent) throws IOException {
        CreatAccountController.stage = new Stage();
        Parent root = FXMLLoader.load(CreatAccountController.class.getResource("CreatAccount.fxml"));
        CreatAccountController.stage.setScene(new Scene(root));
        CreatAccountController.stage.show();
        stage.close();
    }



    public void rb_admin_onKeyReleased(KeyEvent keyEvent) {

        if (keyEvent.getCode().equals(KeyCode.ENTER)){

            if (rb_admin.isSelected()){
                btnCreatAccount.setDisable(true);
            }else{
                btnCreatAccount.setDisable(false);
            }
            txtUserName.requestFocus();
        }

    }

    public void rb_admin_onMouseClicked(MouseEvent mouseEvent) {
        if (rb_admin.isSelected()) {
            btnCreatAccount.setDisable(true);
        } else {
            btnCreatAccount.setDisable(false);
        }
        txtUserName.requestFocus();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Scaler.scale(pane,false);
        lblMain.setText(windowName);
        txtUserName.requestFocus();
    }
}
