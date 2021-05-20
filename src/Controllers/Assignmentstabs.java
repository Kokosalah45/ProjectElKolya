package Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;


public class Assignmentstabs implements Initializable {
    @FXML
    private AnchorPane users;

    @FXML
    private Button Add_course;

    @FXML
    private Button enroll;

    @FXML
    private Button Edit_course;

    @FXML
    private Button Remove;

    @FXML
    private TableView<assignmentsTableClass> assignmentTable;

    @FXML
    private TableColumn<assignmentsTableClass, String> title;

    @FXML
    private TableColumn<assignmentsTableClass, String> deadline;


    @FXML
    private ComboBox<String> viewSubject;

    static Integer idOfSelectedSubject = null;
    HashMap<String,Integer> subjectList = new HashMap<>();



    static public Connection con=null;

    void updateTable () throws SQLException {
        ObservableList<courseTableClass> List = FXCollections.observableArrayList();

        Statement stmt = con.createStatement();
        //if user has the rights e3emel el query di
        //ResultSet rs =  stmt.executeQuery("select * from courses inner join users_courses on courses.id = users_courses.course_id ");

        //not
        ResultSet rs =  stmt.executeQuery("select distinct * from courses inner join users_courses on courses.id = users_courses.course_id where user_id = 4 ");

        while (rs.next())
        {
            List.add(new courseTableClass(rs.getInt("id"),rs.getString("course_name"),rs.getInt("credit_hours")
                    ,rs.getDouble("pass_percentage"),rs.getDouble("exc_percentage") , rs.getString("Semester")));
        }

       for (int i = 0 ; i < List.size() ; i++) {subjectList.put(List.get(i).getName(),List.get(i).getId());}
       for (String i : subjectList.keySet()) {viewSubject.getItems().add(i);}

       viewSubject.getSelectionModel().selectFirst();



    }



        @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
            try {
                con = Dbconnector.getConnection();
                updateTable ();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }


    static  assignmentsTableClass assignmentObject=null;
    @FXML
    void getData(MouseEvent mouseEvent) {
        if (mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
            if (mouseEvent.getClickCount() == 1) {
                assignmentObject=assignmentTable.getSelectionModel().getSelectedItem();

            }

        }

    }

    @FXML
    void popUpWindowAdd(ActionEvent event) throws IOException {

        assignmentsPopUpWindow.idOfSelectedSubject(idOfSelectedSubject);

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/pages/assignmentPopUpWindow.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setResizable(false);

        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.show();




    }

    @FXML
    void popUpWindowEdit(ActionEvent event) throws IOException {
        if (assignmentObject!=null)
        {
            assignmentsPopUpWindow.getData(assignmentObject);
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/pages/assignmentPopUpWindow.fxml"));
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
        String delete = (assignmentObject.getId()+"");
        Connection con = Dbconnector.getConnection();
        Statement stmt = con.createStatement();
        stmt.executeUpdate("DELETE FROM courses where id = " + delete);
        updateTable();

    }

    @FXML
    void showMenu(ActionEvent event) throws SQLException {
        ObservableList<assignmentsTableClass> List = FXCollections.observableArrayList();
        Statement stmt = con.createStatement();
        String selected = viewSubject.getSelectionModel().getSelectedItem();
        idOfSelectedSubject = subjectList.get(selected);


        ResultSet rs =  stmt.executeQuery("select * from assignments where course_id = " + idOfSelectedSubject);


        while (rs.next())
        {
            List.add(new assignmentsTableClass(rs.getInt("id"),rs.getInt("course_id"),rs.getString("deadline")
                    ,rs.getString("title")));

            assignmentTable.setItems(List);
        }
        title.setCellValueFactory(new PropertyValueFactory<>("title"));

        deadline.setCellValueFactory(new PropertyValueFactory<>("deadline"));

    }

}




