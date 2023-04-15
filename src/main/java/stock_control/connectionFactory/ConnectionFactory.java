package stock_control.connectionFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    public Connection RecoverConnection() throws SQLException {

        String url = "mysql://localhost/stock_control?useTimeZone=true&serverTimeZone=UTC";
        String user = "root";
        String password = "@Fyrelicht21";

        return DriverManager.getConnection("jdbc:" + url, user, password);

    }
}
