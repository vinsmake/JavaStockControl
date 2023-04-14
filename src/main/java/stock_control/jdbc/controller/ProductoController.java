package stock_control.jdbc.controller;

//to get the user and password from other side
import stock_control.mysqldata;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductoController {

	public void modificar(String nombre, String descripcion, Integer id) {
		// TODO
	}

	public void eliminar(Integer id) {
		// TODO
	}

	public List<?> listar() throws SQLException {
		// Conects to the database
		Connection myConnection = DriverManager.getConnection(
			"jdbc:mysql://localhost/stock_control?useTimeZone=true&serverTimeZone=UTC",
			mysqldata.user,
			mysqldata.password
			);

			System.out.println("connecting by Listar()");
			java.sql.Statement statement = myConnection.createStatement();

			//boolean: does the statement is a list or not?
			boolean result = statement.execute("SELECT ProductID, ProductName, ProductDescription, ProductAmount FROM product");

			//if true = it's a list
			System.out.println(result);

			//closes the conection
			myConnection.close();
			System.out.println("Closing by Listar()");

		return new ArrayList<>();
	}

    public void guardar(Object producto) {
		// TODO
	}

}