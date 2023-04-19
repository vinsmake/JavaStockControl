package stock_control.connectionFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;


public class ConnectionFactory {

    private DataSource dataSource;

    public ConnectionFactory(){
        //creates a pool conection using c3p0
        var pooledDataSource = new ComboPooledDataSource();
        pooledDataSource.setJdbcUrl("jdbc:mysql://localhost/stock_control?useTimeZone=true&serverTimeZone=UTC");
        pooledDataSource.setUser("root");
        pooledDataSource.setPassword("@Fyrelicht21");

        //this makes that the limit of conections is 10
        pooledDataSource.setMaxPoolSize(10);

        this.dataSource = pooledDataSource;
    }

    public Connection RecoverConnection() throws SQLException {

        try {
                    //connects to the database
        return this.dataSource.getConnection();
        } catch (SQLException e) {
           throw new RuntimeException(e);
        }


    }
}
