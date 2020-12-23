package frontEnd;

import backEnd.MessageManager;
import backEnd.UserManager;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import entites.User;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

public class LoginController {


    public static Stage stage;
    String windowName = "Loging Menu";
    public Label lblMain;
    public JFXTextField txtUserName;
    public PasswordField txtPassword;
    public JFXButton btnLogin;
    public JFXButton btnExite;
    public JFXButton btnCreatAccount;
    public Hyperlink hl_admin;

    public void txtIDOnKeyRelease(KeyEvent keyEvent) {
        if (keyEvent.getCode().equals(KeyCode.ENTER)){
            User user;
            try{
                user = UserManager.getUser(txtUserName.getText());
                MessageManager.giveSuccessMessage(lblMain,"Welcome! " + user.getName(),windowName);
                txtPassword.requestFocus();

            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    public void txtPasswordOnKeyRelease(KeyEvent keyEvent) throws InterruptedException, ExecutionException, IOException {

        if (keyEvent.getCode().equals(KeyCode.ENTER)){
            User user = UserManager.getUser(txtUserName.getText());

            if (user.getPassword().equals(txtPassword.getText())){
                MessageManager.giveSuccessMessage(lblMain,"Login Successful",windowName);
                if (user.getType().equals("personal")) {
                    CompanyMenuController.stage = new Stage();
                    Parent root = FXMLLoader.load(CompanyMenuController.class.getResource("studentMenu.fxml"));
                    CompanyMenuController.stage.setScene(new Scene(root));
                    CompanyMenuController.stage.show();
                    stage.close();


                }else {
                    PersonalAccountMenuController.stage = new Stage();
                    Parent root = FXMLLoader.load(PersonalAccountMenuController.class.getResource("PersonalAccountMenu.fxml"));
                    PersonalAccountMenuController.stage.setScene(new Scene(root));
                    PersonalAccountMenuController.stage.show();
                    stage.close();
                }
            }else {
                MessageManager.giveAWarning(lblMain,"Incorrect Password",windowName);
                txtPassword.clear();
                txtPassword.requestFocus();
            }
        }


    }

    public void btnLoginOnKeyRelease(KeyEvent keyEvent) throws InterruptedException, ExecutionException, IOException {
        if (keyEvent.getCode().equals(KeyCode.ENTER)){
            User user = UserManager.getUser(txtUserName.getText());

            if (user.getPassword().equals(txtPassword.getText())){
                if (user.getType().equals("personal")) {
                    CompanyMenuController.stage = new Stage();
                    Parent root = FXMLLoader.load(CompanyMenuController.class.getResource("studentMenu.fxml"));
                    CompanyMenuController.stage.setScene(new Scene(root));
                    CompanyMenuController.stage.show();
                    stage.close();


                }else {
                    PersonalAccountMenuController.stage = new Stage();
                    Parent root = FXMLLoader.load(PersonalAccountMenuController.class.getResource("PersonalAccountMenu.fxml"));
                    PersonalAccountMenuController.stage.setScene(new Scene(root));
                    PersonalAccountMenuController.stage.show();
                    stage.close();
                }
            }else {
                MessageManager.giveAWarning(lblMain,"Incorrect Password",windowName);
                txtPassword.clear();
                txtPassword.requestFocus();
            }
        }
    }

    public void btnLoginOnMouseClicked(MouseEvent mouseEvent) throws InterruptedException, ExecutionException, IOException {
        User user = UserManager.getUser(txtUserName.getText());

        if (user.getPassword().equals(txtPassword.getText())){
            if (user.getType().equals("personal")) {
                CompanyMenuController.stage = new Stage();
                Parent root = FXMLLoader.load(CompanyMenuController.class.getResource("studentMenu.fxml"));
                CompanyMenuController.stage.setScene(new Scene(root));
                CompanyMenuController.stage.show();
                stage.close();


            }else {
                PersonalAccountMenuController.stage = new Stage();
                Parent root = FXMLLoader.load(PersonalAccountMenuController.class.getResource("PersonalAccountMenu.fxml"));
                PersonalAccountMenuController.stage.setScene(new Scene(root));
                PersonalAccountMenuController.stage.show();
                stage.close();
            }
        }else {
            MessageManager.giveAWarning(lblMain,"Incorrect Password",windowName);
            txtPassword.clear();
            txtPassword.requestFocus();
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

    public void btnCreatAccountOnMouseClicked(MouseEvent mouseEvent) {

    }

    public void hl_admin_onKeyReleased(KeyEvent keyEvent) {
    }

    public void hl_admin_onMouseClicked(MouseEvent mouseEvent) {
    }
}
