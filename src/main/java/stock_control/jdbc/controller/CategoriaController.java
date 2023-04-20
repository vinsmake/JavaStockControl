package stock_control.jdbc.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import stock_control.connectionFactory.ConnectionFactory;
import stock_control.jdbc.DAO.CategoryDAO;
import stock_control.jdbc.Model.Category;

public class CategoriaController {

    private CategoryDAO categoryDAO;

    public CategoriaController() throws SQLException {
        var factory = new ConnectionFactory();
        this.categoryDAO = new CategoryDAO(factory.RecoverConnection());
    }

	public List<stock_control.jdbc.DAO.Category> listar() {
		return categoryDAO.listar();
	}

    public List<?> cargaReporte() {
        // TODO
        return new ArrayList<>();
    }

}
