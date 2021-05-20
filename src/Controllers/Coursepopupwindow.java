package Controllers;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class Coursepopupwindow implements Initializable {

    static String result = "";
    @FXML
    private TextField T1;

    @FXML
    private TextField T3;

    @FXML
    private TextField T2;
    @FXML
    private AnchorPane popup;

    @FXML
    private Button close;

    List<String> s = new ArrayList<>();
    public static courseTableClass courseData=null;
    public static void  getData(courseTableClass object) {
        courseData = object;

    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if (courseData!=null)
        {
            T1.setText(courseData.getName());
            T2.setText(courseData.getCreditHours()+"");
            T3.setText(courseData.getSemester());
        }
    }




    @FXML
    void closeWindow(ActionEvent event) {

        Stage stage = (Stage) close.getScene().getWindow();
        result="";
        s.clear();
        courseData=null;
        stage.close();


    }

    @FXML
    void apply(ActionEvent event) {
        if (result=="")
        {
            s.add(addsinglecolumns(T1.getText()));
            s.add(T2.getText());
            s.add(addsinglecolumns(T3.getText()));
            result = String.join(",",s);
            System.out.println(result);
        }

    }





    private String addsinglecolumns(String text) {
        text = '\'' + text + '\'';
        System.out.println(text);
        return text;
    }


    @FXML
    void submit(ActionEvent event) throws SQLException {
        apply(event);
        Connection con = Dbconnector.getConnection();
        Statement stmt = con.createStatement();
        String statement =null;
        if (courseData!=null)
        {
            statement = "update courses set "
                    + "course_name = " + s.get(0)
                    + ",credit_hours = " + s.get(1)
                    + ",Semester = " + s.get(2)
                    + "where id = " + courseData.getId();

        }

        else
            statement = "insert into courses (course_name,credit_hours,Semester) values (" + result + ")";


        stmt.executeUpdate(statement);
        result="";
        courseData=null;
        s.clear();


    }


}
