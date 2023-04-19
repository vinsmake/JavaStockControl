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
import stock_control.jdbc.DAO.ProductDAO;
import stock_control.jdbc.Model.Product;

public class ProductoController {

	private ProductDAO productDAO;

	public ProductoController() throws SQLException {
		this.productDAO = new ProductDAO(new ConnectionFactory().RecoverConnection());
	}

	public int modificar(Integer id, String nombre, String descripcion, Integer cantidad) throws SQLException {
		final Connection myConnection = new ConnectionFactory().RecoverConnection();
		try (myConnection) {

			final java.sql.PreparedStatement statement = myConnection.prepareStatement(

					"UPDATE product SET "
							+ " ProductName = '" + nombre + "'"
							+ ", ProductDescription = '" + descripcion + "'"
							+ ", ProductAmount = " + cantidad
							+ " WHERE ProductId = " + id

			);

			try (statement) {

				statement.execute();
				int updateCount = statement.getUpdateCount();
				myConnection.close();
				return updateCount;
			}
		}
	}

	public int eliminar(Integer id) throws SQLException {
		final Connection myConnection = new ConnectionFactory().RecoverConnection();
		try (myConnection) {
			final java.sql.PreparedStatement statement = myConnection.prepareStatement(
					"DELETE FROM product WHERE ProductID = " + id);
			try (statement) {
				statement.execute();
				myConnection.close();
				return statement.getUpdateCount();
			}
		}
	}

	public List<Product> listar() throws SQLException {

		return productDAO.Listar();


	}

	public void guardar(Product newProduct) {

		productDAO.registerProduct(newProduct);
	}

}
