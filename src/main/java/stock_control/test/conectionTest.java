package stock_control.test;

import java.sql.SQLException;

import stock_control.connectionFactory.ConnectionFactory;

import java.sql.Connection;


public class conectionTest {
    public static void main(String[] args) throws SQLException {
        Connection myConnection = new ConnectionFactory().RecoverConnection();
        System.out.println("Closing conection");
myConnection.close();
System.out.println("Conection closed");
    }
}
