package stock_control.jdbc.DAO;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.sql.Connection;
import java.sql.PreparedStatement;



public class CategoryDAO {

    private Connection myConnection;

    public CategoryDAO(Connection myConnection) {
        this.myConnection = myConnection;
    }

    public List<Category> listar() {
        List<Category> resultado = new ArrayList<>();

        try {
            PreparedStatement statement = myConnection.prepareStatement(
                    "SELECT CategoryId, CategoryName FROM category");

            try (statement) {
                final java.sql.ResultSet resultSet = statement.executeQuery();
                try (resultSet) {
                    while (resultSet.next()) {
                        var category = new Category(
                                resultSet.getInt("CategoryId"),
                                resultSet.getString("CategoryName"));

                        resultado.add(category);
                    }
                };

            };
        } catch (Exception e) {
            throw new RuntimeException(e);
        };

        return resultado;
    }};

