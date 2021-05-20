package Controllers;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import java.io.IOException;

public class LoginpageController {
    //buttons
    public JFXButton sign_up;
    public JFXButton signIn;

    //panes

    public AnchorPane sign_in;
    public AnchorPane main;


    public void sigin_action(ActionEvent Event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../pages/Userpanel1.fxml"));
        Stage window  = (Stage)((Node) Event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        window.setScene(scene);
        window.setResizable(false);
        window.show();

    }

  public void signup_action( ActionEvent Event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("../pages/Signup.fxml"));
        Scene scene = new Scene(root);
        Stage window  = (Stage)((Node) Event.getSource()).getScene().getWindow();

        window.setScene(scene);
        window.setResizable(false);
        window.show();

    }

    @FXML
    void getUsername(ActionEvent event) {

    }

    @FXML
    void getPassword(ActionEvent event) {

    }
}
