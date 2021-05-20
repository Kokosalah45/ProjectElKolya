import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
        primaryStage.setTitle("Hello World");
       Parent root = FXMLLoader.load(getClass().getResource("pages/Loginpage.fxml"));
       primaryStage.setResizable(false);
       Scene login_page = new Scene(root);
       primaryStage.setScene(login_page);


        primaryStage.show();


    }




    public static void main(String[] args) throws SQLException {

        launch(args);
    }
}
