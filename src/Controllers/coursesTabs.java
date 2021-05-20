package Controllers;

import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class coursesTabs implements Initializable {

    @FXML
    private AnchorPane users;



    @FXML
    private TableView<courseTableClass> courseTable;


    @FXML
    private TableColumn<courseTableClass, Integer> id;

    @FXML
    private TableColumn<courseTableClass, String> name;

    @FXML
    private TableColumn<courseTableClass, Integer> credith;

    @FXML
    private TableColumn<courseTableClass, Double> pass;

    @FXML
    private TableColumn<courseTableClass, Double> a_plus;


    @FXML
    private TableColumn<courseTableClass, String> Semester;



    static public  Connection con=null;

     void updateTable () throws  SQLException {
         ObservableList<courseTableClass> List = FXCollections.observableArrayList();
         Statement stmt = con.createStatement();
         ResultSet rs =  stmt.executeQuery("SELECT  * FROM courses");

         while (rs.next())
        {

            List.add(new courseTableClass(rs.getInt("id"),rs.getString("course_name"),rs.getInt("credit_hours")
                    ,rs.getDouble("pass_percentage"),rs.getDouble("exc_percentage") , rs.getString("Semester")));

            courseTable.setItems(List);



        }
         id.setCellValueFactory(new PropertyValueFactory<>("id"));

         name.setCellValueFactory(new PropertyValueFactory<>("name"));

         credith.setCellValueFactory(new PropertyValueFactory<>("creditHours"));

         pass.setCellValueFactory(new PropertyValueFactory<>("passPercentage"));
         a_plus.setCellValueFactory(new PropertyValueFactory<>("excPercentage"));
         Semester.setCellValueFactory(new PropertyValueFactory<>("semester"));








     }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        try {
            con = Dbconnector.getConnection();
            updateTable();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }



    }

    @FXML
    void popUpWindowAdd(ActionEvent event) throws IOException, SQLException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/pages/coursepopupwindow.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setResizable(false);

        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.show();


    }
    static  courseTableClass courseObject=null;
    @FXML
    void getData(MouseEvent mouseEvent) {
        if (mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
            if (mouseEvent.getClickCount() == 1) {
                courseObject=courseTable.getSelectionModel().getSelectedItem();
                System.out.println(courseObject.getName() + " " + courseObject.getSemester() + " " +courseObject.getCreditHours());
            }

        }
    }

    @FXML
    void enroll(ActionEvent event) {
        //getuserIDfrom session
        //query insert into courses_users (user_id column , course_id column) Values (currentuserid,courseObject from get data methodID)

    }

    @FXML
    void popUpWindowEdit(ActionEvent event) throws IOException, SQLException {
        if (courseObject!=null)
        {
            Coursepopupwindow.getData(courseObject);
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/pages/coursepopupwindow.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setResizable(false);
            stage.show();


        }



    }

    @FXML
    void removeAction(ActionEvent event) throws SQLException {
        String delete = (courseObject.getId()+"");
        Connection con = Dbconnector.getConnection();
        Statement stmt = con.createStatement();
        stmt.executeUpdate("DELETE FROM courses where id = " + delete);
        updateTable();
    }





}

