package frontEnd;

import backEnd.DataHolder;
import backEnd.MailManager;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import entites.Message;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.ExecutionException;

public class ApplyAdvertisementController implements Initializable {
    public static String messageTo;
    public static String addId;
    public static String windowName = "Send Message";

    public static Stage stage;
    @FXML
    private Label lblMain;

    @FXML
    private JFXButton btn_cancel;

    @FXML
    private JFXButton btn_apply;

    @FXML
    private JFXTextField txt_message;

    @FXML
    void btn_apply_onKeyReleased(KeyEvent event) {


    }

    @FXML
    void btn_apply_onMouseClicked(MouseEvent event) {
        send();
    }

    private void send() {
        try {
            MailManager.addMessage(new Message(DataHolder.user.getId(),messageTo,txt_message.getText(),addId));
        } catch (IOException | InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

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
    void txt_message_onKeyReleased(KeyEvent event) {

    }

    @FXML
    void txt_message_onMouseClicked(MouseEvent event) {

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        lblMain.setText(windowName);
        if (messageTo.equals("admin")){
            Platform.runLater(() -> {
                lblMain.setText("Message to ADMIN");
            });
        }
    }
}
