package Controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dbconnector {
    public static Connection getConnection() throws SQLException {
        String url1 = "jdbc:mysql://mysql-do-user-4609572-0.b.db.ondigitalocean.com:25060/defaultdb";
        String user = "doadmin";
        String password = "hp9y4jxwjcdx6fr8";
        System.out.println("xD");
        Connection con = DriverManager.getConnection(url1,user,password);
        if (con != null) {
            System.out.println("Connected !");
        }

        return con;
    }
}
