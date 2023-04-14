package stock_control.test;

import stock_control.mysqldata;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;

public class conectionTest {
    public static void main(String[] args) throws SQLException {
        Connection myConnection = DriverManager.getConnection("jdbc:mysql://localhost/stock_control?useTimeZone=true&serverTimeZone=UTC",
        mysqldata.user,
        mysqldata.password
          );

        System.out.println("Closing conection");
myConnection.close();
System.out.println("Conection closed");
    }
}
