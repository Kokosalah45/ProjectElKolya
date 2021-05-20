package Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;



public class SignupController {


    public void returnBack(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../pages/Loginpage.fxml"));
        Scene scene = new Scene(root);
        Stage window  = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();

        window.setScene(scene);
        window.setResizable(false);
        window.show();


    }
}
