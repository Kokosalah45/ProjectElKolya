package Controllers;

import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

public class UserView {
    @FXML
    private AnchorPane user;
    static public UsertableClass userInfo;
    static void getuserinfo(UsertableClass user)
    {
        userInfo=user;
        System.out.print(userInfo.getBdate() + " ento bkrhona bas a5rkom t7sdona");
    }

}
