package Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;


public class assignmentsPopUpWindow implements Initializable {

    @FXML
    private AnchorPane popup;

    @FXML
    private Button submit;

    @FXML
    private Button apply;

    @FXML
    private Button close;

    @FXML
    private TextField T1;


    @FXML
    private DatePicker T2;
    static String result = "";
    List<String> s = new ArrayList<>();
    public static assignmentsTableClass assignmentData=null;
    public static Integer idOfSelectedObject=null;
    public static void  getData(assignmentsTableClass object) {
        assignmentData = object;

    }

    public static void idOfSelectedSubject(Integer object) {
        idOfSelectedObject=object;
        System.out.println(idOfSelectedObject);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if (assignmentData!=null)
        {
            T1.setText(assignmentData.getTitle());
            T2.setValue(LocalDate.parse(assignmentData.getDeadline()));

        }
    }




    @FXML
    void closeWindow(ActionEvent event) {
        /*

        Stage stage = (Stage) close.getScene().getWindow();
        result="";
        s.clear();
        assignmentData=null;
        stage.close();
*/

    }

    @FXML
    void apply(ActionEvent event) {

        if (result=="")
        {
            s.add(addsinglecolumns(T1.getText()));
            s.add(addsinglecolumns(T2.getValue().toString()));
            s.add(assignmentData.getCourse_id()+"");


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
        /*apply(event);
        Connection con = Dbconnector.getConnection();
        Statement stmt = con.createStatement();
        String statement =null;
        if (assignmentData!=null)
        {
            statement = "update courses set "
                    + "course_name = " + s.get(0)
                    + ",credit_hours = " + s.get(1)
                    + ",Semester = " + s.get(2)
                    + "where id = " + assignmentData.getId();

        }

        else
            statement = "insert into courses (course_name,credit_hours,Semester) values (" + result + ")";


        stmt.executeUpdate(statement);
        result="";
        assignmentData=null;
        s.clear();*/


    }
}
