package stock_control.jdbc.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import stock_control.connectionFactory.ConnectionFactory;
import stock_control.jdbc.Model.Product;

public class ProductDAO {
    final private Connection myConnection;

    public ProductDAO(Connection myConnection) {
        this.myConnection = myConnection;
    }

    public void registerProduct(Product newProduct) {
        // connects with the database

        try (myConnection) {
            // Now we have the trasnaction control. Not jdbc. So, we can decide when the
            // commit is complete.
            myConnection.setAutoCommit(false);

            // this avitates the injection of code in sql
            final java.sql.PreparedStatement statement = myConnection.prepareStatement(
                    "INSERT INTO product " + "(ProductName, ProductDescription, ProductAmount) "
                            + " VALUES (?, ?, ?) ",
                    java.sql.Statement.RETURN_GENERATED_KEYS);
            // try to excecute the statement
            try (statement) {

                executeRegister(newProduct, statement);
                // try to excecute the commit
                myConnection.commit();

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);

        }
    }

    private void executeRegister(Product newProduct,
            java.sql.PreparedStatement statement) throws SQLException {
        // here we set the data
        statement.setString(1, newProduct.getProductName());
        statement.setString(2, newProduct.getProductDescription());
        statement.setInt(3, newProduct.getProductAmount());
        statement.execute();
        final ResultSet resultSet = statement.getGeneratedKeys();
        try (resultSet) {
            while (resultSet.next()) {
                newProduct.setProductId(resultSet.getInt(1));
                System.out.println(String.format("se inserto el producto con ID: ", newProduct.getProductId()));
            }
        }
    }

    public List<Product> Listar() throws SQLException {
        // declare result as an array list mapeable
        List<Product> result = new ArrayList<>();

        // Conects to the database
        final Connection myConnection = new ConnectionFactory().RecoverConnection();

        try (myConnection) {

            final java.sql.PreparedStatement statement = myConnection.prepareStatement(

                    // boolean: does the statement is a list or not?
                    "SELECT ProductID, ProductName, ProductDescription, ProductAmount FROM product");

            try (statement) {
                statement.execute();

                // returns a set type of the answer, which is a list of the result.
                final ResultSet resultSet = statement.getResultSet();

                try (resultSet) {
                    while (resultSet.next()) {
                        Product row = new Product(
                                resultSet.getInt("ProductId"),
                                resultSet.getString("ProductName"),
                                resultSet.getString("ProductDescription"),
                                resultSet.getInt("ProductAmount"));

                        // result.
                        result.add(row);
                    }
                }
            }
            return result;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
