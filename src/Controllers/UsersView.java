package Controllers;


import com.mysql.cj.protocol.Resultset;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

import java.beans.EventHandler;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class UsersView implements Initializable {



    @FXML
    private AnchorPane user;

    @FXML
    private TableView<UsertableClass> Usertable;

    @FXML
    private TableColumn<UsertableClass, Integer> col_ID;

    @FXML
    private TableColumn<UsertableClass, String> col_Fname;

    @FXML
    private TableColumn<UsertableClass, String> col_Lname;

    @FXML
    private TableColumn<UsertableClass, String> col_Gender;

    @FXML
    private TableColumn<UsertableClass, String> col_Address;

    @FXML
    private TableColumn<UsertableClass, String> col_Bdate;

    @FXML
    private TableColumn<UsertableClass, String> col_Phone;

    @FXML
    private TableColumn<UsertableClass, String> col_Username;

    @FXML
    private TableColumn<UsertableClass, String> col_Password;

    @FXML
    private TableColumn<UsertableClass, String> col_Email;

    @FXML
    private TableColumn<UsertableClass, Integer> col_State;

    ObservableList<UsertableClass> List = FXCollections.observableArrayList();








    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Connection con = null;
        try {
            con = Dbconnector.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs =  stmt.executeQuery("SELECT  * FROM users");




            while (rs.next())
            {

                List.add(new UsertableClass(rs.getInt("id"),rs.getString("fname"),rs.getString("lname")
                        ,rs.getString("gender"),rs.getString("address"),
                        rs.getString("bdate"),rs.getString("phone"),rs.getString("username")
                        ,rs.getString("password"),rs.getString("email"),rs.getInt("state")));


            }
        } catch (Exception  throwables) {
            throwables.printStackTrace();
        }
        col_ID.setCellValueFactory(new PropertyValueFactory<>("id"));
        col_Fname.setCellValueFactory(new PropertyValueFactory<>("fname"));
        col_Lname.setCellValueFactory(new PropertyValueFactory<>("lname"));
        col_Gender.setCellValueFactory(new PropertyValueFactory<>("gender"));
        col_Address.setCellValueFactory(new PropertyValueFactory<>("address"));
        col_Bdate.setCellValueFactory(new PropertyValueFactory<>("bdate"));
        col_Phone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        col_Username.setCellValueFactory(new PropertyValueFactory<>("username"));
        col_Password.setCellValueFactory(new PropertyValueFactory<>("password"));
        col_Email.setCellValueFactory(new PropertyValueFactory<>("email"));
        col_State.setCellValueFactory(new PropertyValueFactory<>("state"));
        Usertable.setItems(List);






    }

    @FXML
    UsertableClass portableData=null;
    public void test(MouseEvent mouseEvent) {

        if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
            if(mouseEvent.getClickCount() == 1){
                portableData = Usertable.getSelectionModel().getSelectedItem();
                System.out.println("Data has been loaded !");
            }
            else if (mouseEvent.getClickCount() == 2)
            {
                UserView.getuserinfo(portableData);
                System.out.println("Data has been sent !");
            }
        }
    }

}




