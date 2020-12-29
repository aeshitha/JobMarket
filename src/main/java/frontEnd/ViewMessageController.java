package frontEnd;

import backEnd.AdvertisementManager;
import backEnd.DataHolder;
import backEnd.MailManager;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import entites.Advertisement;
import entites.Message;
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

public class ViewMessageController implements Initializable {
    String windowName = "Messages";

    public static Stage stage;
    @FXML
    private Label lblMain;

    @FXML
    private JFXListView<Pane> lView_Message;

    @FXML
    private JFXButton btn_cancel;

    @FXML
    private JFXButton btn_complaint;

    @FXML
    private JFXButton btn_allMe;

    @FXML
    private JFXButton btn_unreadMe;

    @FXML
    void btn_allMe_onKeyReleased(KeyEvent event) {
        if (event.getCode().equals(KeyCode.ENTER)) {
            loadAll();
        }

    }

    @FXML
    void btn_allMe_onMouseClicked(MouseEvent event) {
        loadAll();
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
    void btn_complaint_onKeyReleased(KeyEvent event) {

    }

    @FXML
    void btn_complaint_onMouseClicked(MouseEvent event) {

    }

    @FXML
    void btn_unreadMe_onKeyReleased(KeyEvent event) {
        if (event.getCode().equals(KeyCode.ENTER)) {
            loadUnreaded();
        }
    }

    @FXML
    void btn_unreadMe_onMouseClicked(MouseEvent event) {
        loadUnreaded();
    }

    @FXML
    void lView_Message_onKeyReleased(KeyEvent event) {

    }

    @FXML
    void lView_Message_onMouseClicked(MouseEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        lblMain.setText(windowName);
        loadUnreaded();
    }

    private void loadUnreaded() {
        lView_Message.getItems().clear();
        new Thread(() -> {
            try {
                List<Message> messages;
                if (null!=DataHolder.user) {
                    messages = MailManager.getUnReadedMessages(DataHolder.user.getId());
                }
                else{
                    messages = MailManager.getUnReadedMessages("admin");
                }
                System.out.println(messages.size() + " unreaded messages");
                if (messages.size()>0){
                    Platform.runLater(() -> {
                        for (Message m: messages) {
                            try {
                                addToListMessage(m);
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

    private void loadAll() {
        lView_Message.getItems().clear();
        new Thread(() -> {
            try {
                List<Message> messages;
                if (null!=DataHolder.user) {
                    messages = MailManager.getMessages(DataHolder.user.getId());
                }
                else{
                    messages = MailManager.getMessages("admin");
                }
                System.out.println(messages.size() + "messages");
                if (messages.size()>0){
                    Platform.runLater(() -> {
                        for (Message m: messages) {
                            try {
                                addToListMessage(m);
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

    private void addToListMessage(Message m) throws InterruptedException, ExecutionException, IOException {
        Pane p = new AnchorPane();
        p.setMaxWidth(lView_Message.getPrefWidth());
        Label lbl = new Label("From : "+ m.getFrom());
        lbl.setLayoutX(10);
        lbl.setLayoutY(0);
        p.getChildren().add(lbl);
        Label lbl2 = new Label(m.getBody());
        lbl2.setLayoutX(10);
        lbl2.setLayoutY(15);
        Label lbl3,lbl4,lbl5,lbl6,lbl7,lbl8,lbl9,lbl10,lbl11;
        Button b = new Button();
        b.setText("Reply");
        b.setLayoutX(300);
        b.setLayoutY(0);
        b.setOnAction(actionEvent -> {
            try {
                SearchAdvertisementController.message(m.getFrom(),m.getAddId());
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        if (!m.getAddId().equals("null")){
            lbl3 = new Label("--Advertisement--");
            lbl3.setLayoutX(10);
            lbl3.setLayoutY(40);
            Advertisement a = AdvertisementManager.getAdvertisement(m.getAddId());
            lbl4 = new Label("ADD Type : "+ a.getType());
            lbl4.setLayoutX(10);
            lbl4.setLayoutY(55);
            lbl5 = new Label("Service : "+ a.getService());
            lbl5.setLayoutX(10);
            lbl5.setLayoutY(70);
            lbl6 = new Label("Charges per "+ a.getcPer() + " : "+ a.getCharges());
            lbl6.setLayoutX(10);
            lbl6.setLayoutY(85);
            lbl7 = new Label("Location : "+ a.getProvince());
            lbl7.setLayoutX(10);
            lbl7.setLayoutY(100);
            lbl8 = new Label("Description : "+ a.getDescription());
            lbl8.setLayoutX(10);
            lbl8.setLayoutY(115);
            lbl9 = new Label("Username : "+ a.getUserId());
            lbl9.setLayoutX(10);
            lbl9.setLayoutY(130);
            lbl10 = new Label("Contact No : "+ a.getContactNo());
            lbl10.setLayoutX(10);
            lbl10.setLayoutY(145);
            lbl11 = new Label("Mail : "+ a.getEmail());
            lbl11.setLayoutX(10);
            lbl11.setLayoutY(160);
            if (null!=DataHolder.admin){
                Button b2 = new Button();
                b2.setText("Delete Current Advertisement");
                b2.setLayoutX(375);
                b2.setLayoutY(0);
                b2.setOnAction(actionEvent -> {
                    try {
                        AdvertisementManager.deleteAdvertisement(m.getAddId());
                        m.setAddId("null");
                        MailManager.updateMessage(m);
                    } catch (IOException | InterruptedException | ExecutionException e) {
                        e.printStackTrace();
                    }
                });

                p.focusedProperty().addListener((observableValue, aBoolean, t1) -> {
                    System.out.println("focus : " + t1);
                    if (t1){
                        if(!m.isViewed()){
                            m.setViewed(true);
                            try {
                                MailManager.updateMessage(m);
                            } catch (ExecutionException | InterruptedException | IOException e) {
                                e.printStackTrace();
                            }
                        }
                        p.getChildren().add(b);
                        p.getChildren().add(b2);
                        p.getChildren().add(lbl2);
                        p.getChildren().addAll(lbl3, lbl4,lbl5,lbl6,lbl7,lbl8,lbl9,lbl10,lbl11);
                    }
                    else if(!b.isFocused()){
                        p.getChildren().remove(b);
                        p.getChildren().remove(b2);
                        p.getChildren().remove(lbl2);
                        p.getChildren().removeAll(lbl3, lbl4,lbl5,lbl6,lbl7,lbl8,lbl9,lbl10,lbl11);



                    }
                });


            }
            else{
                p.focusedProperty().addListener((observableValue, aBoolean, t1) -> {
                    System.out.println("focus : " + t1);
                    if (t1){
                        if(!m.isViewed()){
                            m.setViewed(true);
                            try {
                                MailManager.updateMessage(m);
                            } catch (ExecutionException | InterruptedException | IOException e) {
                                e.printStackTrace();
                            }
                        }
                        p.getChildren().add(b);
                        p.getChildren().add(lbl2);
                        p.getChildren().addAll(lbl3, lbl4,lbl5,lbl6,lbl7,lbl8,lbl9,lbl10,lbl11);
                    }
                    else if(!b.isFocused()){
                        p.getChildren().remove(b);
                        p.getChildren().remove(lbl2);
                        p.getChildren().removeAll(lbl3, lbl4,lbl5,lbl6,lbl7,lbl8,lbl9,lbl10,lbl11);



                    }
                });
            }



        }
        else{
            p.focusedProperty().addListener((observableValue, aBoolean, t1) -> {
                System.out.println("focus : " + t1);
                if (t1){
                    p.getChildren().add(b);
                    p.getChildren().add(lbl2);
                }
                else if(!b.isFocused()){
                    p.getChildren().remove(b);
                    p.getChildren().remove(lbl2);


                }
            });
        }

//        p.getChildren().add(lbl2);


        p.setOnMouseReleased(mouseEvent -> {
            p.requestFocus();
        });

        lView_Message.getItems().add(p);
        lView_Message.refresh();

    }

}
