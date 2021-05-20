package Controllers;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.io.IOException;



public class MainPageController extends LoginpageController{
    @FXML
    private AnchorPane content;


    @FXML

    void initialize () throws IOException {

    }
    @FXML
    void usersInfo(MouseEvent event) throws IOException {
        AnchorPane root = getpage("usersTab.fxml");
        show(root);

    }
    @FXML
    void userInfo(MouseEvent event) throws IOException {
        AnchorPane root = getpage("userTab.fxml");
        show(root);

    }
    @FXML
    void assignmentsInfo(MouseEvent event) throws IOException {
        AnchorPane root = getpage("assignmentstabs.fxml");
        show(root);


    }
    @FXML
    void rolesInfo(MouseEvent event) throws IOException {
        AnchorPane root = getpage("roleTabs.fxml");
        show(root);


    }
    @FXML
    void coursesInfo(MouseEvent event) throws IOException {
        AnchorPane root = getpage("coursesTabs.fxml");
        show(root);


    }
    @FXML
    void  permissionsInfo(MouseEvent event) throws IOException {
        AnchorPane root = getpage("permissionsTab.fxml");
        show(root);


    }
    @FXML
    void lecturesInfo(MouseEvent event) throws IOException {
        AnchorPane root = getpage("Lecturestab.fxml");
        show(root);


    }
    @FXML
    void examsInfo(MouseEvent event) throws IOException {
        AnchorPane root = getpage("examstab.fxml");
        show(root);


    }





    @FXML
    void returnBack(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../pages/Loginpage.fxml"));
        Scene scene = new Scene(root);
        Stage window  = (Stage)((Node) event.getSource()).getScene().getWindow();

        window.setScene(scene);
        window.setResizable(false);
        window.show();

    }

    @FXML
    public AnchorPane getpage (String fileName) throws IOException {

        AnchorPane page;
        page = FXMLLoader.load(getClass().getResource("../pages/" + fileName));
        return page;
    }
    @FXML
    public void show(AnchorPane root)
    {
        //question
        if (content.getChildren().size()!=0)
            content.getChildren().clear();


        content.getChildren().add(root);
        //System.out.println(content.getChildren().size()); debugging



    }

    }


