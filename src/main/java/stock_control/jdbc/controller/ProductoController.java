package stock_control.jdbc.controller;

//to get the user and password from other side
import stock_control.mysqldata;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductoController {

	public void modificar(String nombre, String descripcion, Integer id) {
		// TODO
	}

	public void eliminar(Integer id) {
		// TODO
	}

	public List<Map<String, String>> listar() throws SQLException {
		// Conects to the database
		Connection myConnection = DriverManager.getConnection(
			"jdbc:mysql://localhost/stock_control?useTimeZone=true&serverTimeZone=UTC",
			mysqldata.user,
			mysqldata.password
			);

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

    public void guardar(Object producto) {
		// TODO
	}

}
