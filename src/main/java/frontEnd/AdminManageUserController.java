package frontEnd;

import backEnd.AdvertisementManager;
import backEnd.DataHolder;
import backEnd.MailManager;
import backEnd.UserManager;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;
import entites.Advertisement;
import entites.Message;
import entites.User;
import javafx.application.Platform;
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
import java.util.List;
import java.util.ResourceBundle;
import java.util.concurrent.ExecutionException;

public class AdminManageUserController implements Initializable {

    public static Stage stage;
    @FXML
    private Label lblMain;

    @FXML
    private JFXButton btn_cancel;

    @FXML
    private JFXListView<Pane> lView_Message;

    @FXML
    private JFXTextField txt_userId;

    @FXML
    private JFXButton btn_next;

    @FXML
    private JFXButton btn_prev;

    @FXML
    private JFXButton btn_search;

    public static String function = null;

    @FXML
    void btn_cancel_onKeyReleased(KeyEvent event) {

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
    void btn_search_onKeyReleased(KeyEvent event) {
        if(event.getCode().equals(KeyCode.ENTER)){
            search();
        }
    }

    @FXML
    void btn_search_onMouseClicked(MouseEvent event) {
        search();
    }

    @FXML
    void lView_Message_onKeyReleased(KeyEvent event) {

    }

    @FXML
    void lView_Message_onMouseClicked(MouseEvent event) {

    }

    @FXML
    void txt_userId_onKeyReleased(KeyEvent event) {
        if(event.getCode().equals(KeyCode.ENTER)){
            search();
        }
    }

    @FXML
    void txt_userId_onMouseClicked(MouseEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if (function.equals("user")){
            loadUsers();
        }
        else{
            loadAdds();
        }
    }

    private void search(){
        lView_Message.getItems().clear();
        if (function.equals("user")){
            try {
                User u = UserManager.getUser(txt_userId.getText());
                addToListUser(u);
            } catch (ExecutionException | InterruptedException | IOException e) {
                e.printStackTrace();
            }
        }
        if (function.equals("add")){
            try {
                Advertisement a = AdvertisementManager.getAdvertisement(txt_userId.getText());
                addToListAdd(a);
            } catch (ExecutionException | InterruptedException | IOException e) {
                e.printStackTrace();
            }
        }
    }


    private void loadUsers() {
        lView_Message.getItems().clear();
        new Thread(() -> {
            try {
                List<User> users;
                users = UserManager.getUsers();
                if (users.size()>0){
                    Platform.runLater(() -> {
                        for (User u: users) {
                            try {
                                addToListUser(u);
                            } catch (InterruptedException | ExecutionException | IOException e) {
                                e.printStackTrace();
                            }
                        }
                    });
                }
            } catch (ExecutionException | InterruptedException | IOException e) {
                e.printStackTrace();
            }
        }).start();
    }

    private void loadAdds() {
        lView_Message.getItems().clear();
        new Thread(() -> {
            try {
                List<Advertisement> adds;
                adds = AdvertisementManager.getAdvertisements();
                if (adds.size()>0){
                    Platform.runLater(() -> {
                        for (Advertisement a: adds) {
                            addToListAdd(a);
                        }
                    });
                }
            } catch (ExecutionException | InterruptedException | IOException e) {
                e.printStackTrace();
            }
        }).start();
    }

    private void addToListAdd(Advertisement a) {
        Pane p = new AnchorPane();
        p.setMaxWidth(lView_Message.getPrefWidth());
        Label lbl4 = new Label("ADD Type : " + a.getType());
        lbl4.setLayoutX(10);
        lbl4.setLayoutY(0);
        Label lbl5 = new Label("Service : " + a.getService());
        lbl5.setLayoutX(10);
        lbl5.setLayoutY(15);
        Label lbl6 = new Label("Charges per " + a.getcPer() + " : " + a.getCharges());
        lbl6.setLayoutX(10);
        lbl6.setLayoutY(30);
        Label lbl7 = new Label("Location : " + a.getProvince());
        lbl7.setLayoutX(10);
        lbl7.setLayoutY(45);
        Label lbl8 = new Label("Description : " + a.getDescription());
        lbl8.setLayoutX(10);
        lbl8.setLayoutY(60);
        Label lbl9 = new Label("Username : " + a.getUserId());
        lbl9.setLayoutX(10);
        lbl9.setLayoutY(75);
        Label lbl10 = new Label("Contact No : " + a.getContactNo());
        lbl10.setLayoutX(10);
        lbl10.setLayoutY(90);
        Label lbl11 = new Label("Mail : " + a.getEmail());
        lbl11.setLayoutX(10);
        lbl11.setLayoutY(105);;
        Button b = new Button();
        b.setText("Delete");
        b.setLayoutX(300);
        b.setLayoutY(0);
        b.setOnAction(actionEvent -> {
            try {
                AdvertisementManager.deleteAdvertisement(a.getId());
                lView_Message.getItems().remove(p);
                lView_Message.refresh();
            } catch (IOException | InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        });
        p.getChildren().addAll(lbl4,lbl5,lbl6,lbl7,lbl8,lbl9,lbl10,lbl11,b);

        lView_Message.getItems().add(p);
        lView_Message.refresh();

    }

    private void addToListUser(User u) throws InterruptedException, ExecutionException, IOException {
        Pane p = new AnchorPane();
        p.setMaxWidth(lView_Message.getPrefWidth());
        Label lbl = new Label("ID : "+ u.getId());
        lbl.setLayoutX(10);
        lbl.setLayoutY(0);
        Label lbl2 = new Label("Name : "+ u.getName());
        lbl2.setLayoutX(10);
        lbl2.setLayoutY(15);
        Button b = new Button();
        b.setText("Delete");
        b.setLayoutX(300);
        b.setLayoutY(0);
        b.setOnAction(actionEvent -> {
            try {
                UserManager.deleteUser(u.getId());
                lView_Message.getItems().remove(p);
                lView_Message.refresh();
            } catch (IOException | InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        });
        Label lbl3 = new Label("Email : "+  u.getEmail());
        lbl3.setLayoutX(10);
        lbl3.setLayoutY(30);
        Label lbl4 = new Label("Tell No : " + u.getTellNo());
        lbl4.setLayoutX(10);
        lbl4.setLayoutY(45);
        Label lbl5 = new Label("Date of Birth : " + u.getDob().getDate());
        lbl5.setLayoutX(10);
        lbl5.setLayoutY(60);
        Label lbl6 = new Label("Location " + u.getProvince() + ", "  +u.getCity()+ ", "  +u.getArea());
        lbl6.setLayoutX(10);
        lbl6.setLayoutY(75);
        Label lbl7 = new Label("Description : " + u.getDescription());
        lbl7.setLayoutX(10);
        lbl7.setLayoutY(90);
        p.getChildren().addAll(lbl,lbl2,lbl3,lbl4,lbl5,lbl6,lbl7,b);
        lView_Message.getItems().add(p);
        lView_Message.refresh();

    }
}
