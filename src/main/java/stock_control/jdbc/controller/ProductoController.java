package stock_control.jdbc.controller;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import stock_control.connectionFactory.ConnectionFactory;

public class ProductoController {

	public void modificar(String nombre, String descripcion, Integer id) {
		// TODO
	}

	public void eliminar(Integer id) {
		// TODO
	}

	public List<Map<String, String>> listar() throws SQLException {
		// Conects to the database
		Connection myConnection = new ConnectionFactory().RecoverConnection();

			System.out.println("connecting by Listar()");
			java.sql.Statement statement = myConnection.createStatement();

			//boolean: does the statement is a list or not?
			statement.execute("SELECT ProductID, ProductName, ProductDescription, ProductAmount FROM product");

			//returns a set type of the answer, which is a list of the result.
			ResultSet resultSet = statement.getResultSet();

			//declare result as an array list mapeable
			ArrayList<Map<String, String>> result = new ArrayList<>();

			//iterates the result set
			while (resultSet.next()) {
				//declare what a row is, in this case, a HashMap
				Map<String, String> row = new HashMap<>();
				//creates a row for every row in the db
				row.put("ProductID", String.valueOf(resultSet.getInt("ProductID")));
				row.put("ProductName", resultSet.getString("ProductName"));
				row.put("ProductDescription", resultSet.getString("ProductDescription"));
				row.put("ProductAmount", resultSet.getString("ProductAmount"));

				//for each valor of resultSet we transfer te info to a map and add it to result.
				result.add(row);
			}

			//closes the conection
			myConnection.close();
			System.out.println("Closing by Listar()");

			return result;
	}

    public void guardar(Map<String, String> producto) throws SQLException {
		Connection myConnection = new ConnectionFactory().RecoverConnection();

		java.sql.Statement statement = myConnection.createStatement();

		statement.execute("INSERT INTO product(ProductName, ProductDescription, ProductAmount)"
		+ " VALUES ('"+ producto.get("ProductName") 
		+ "','" 
		+ producto.get("ProductDescription") 
		+ "'," + producto.get("ProductAmount") + ")", statement.RETURN_GENERATED_KEYS);
		
		
		ResultSet resultSet = statement.getGeneratedKeys();

		while (resultSet.next()) {
			System.out.println(String.format("se inserto el producto con ID " + resultSet.getInt(1)));
		}

		
	}

}
