package stock_control.jdbc;

import java.sql.SQLException;

import javax.swing.JFrame;

import stock_control.jdbc.view.ControlDeStockFrame;



public class ControlDeStockMain {

	public static void main(String[] args) throws SQLException {
		ControlDeStockFrame produtoCategoriaFrame = new ControlDeStockFrame();
		produtoCategoriaFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
