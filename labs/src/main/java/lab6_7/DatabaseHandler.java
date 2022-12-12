package lab6_7;

import lab1.Warehouse;
import lab1.WarehouseBuilderImpl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler extends DBSettings{
    Connection dbConnection;
    public Connection getDbConnection() throws ClassNotFoundException, SQLException {
        String connectionString = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName;

        Class.forName("com.mysql.cj.jdbc.Driver");

        dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPass);

        return dbConnection;
    }

    public void createWarehouse(Warehouse warehouse) {
        String insert = "INSERT INTO warehouses(address, city, country) VALUES(?, ?, ?)";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);
            prSt.setString(1, warehouse.getAddress());
            prSt.setString(2, warehouse.getCity());
            prSt.setString(3, warehouse.getCountry());

            prSt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Warehouse> readWarehouses() {
        List<Warehouse> warehouses = new ArrayList<>();
        try {
            String select = "SELECT * FROM warehouses";

            PreparedStatement prSt = getDbConnection().prepareStatement(select);
            ResultSet result = prSt.executeQuery(select);
            int count = 0;

            while (result.next()){
                String address = result.getString("address");
                String city = result.getString("city");
                String country = result.getString("country");
                warehouses.add(new WarehouseBuilderImpl().setAddress(address).setCity(city).setCountry(country).build());
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return warehouses;
    }

    public Warehouse readWarehouseById(int id) {
        Warehouse res = new Warehouse();
        try {
            String select = "SELECT * FROM warehouses WHERE id=" + id;

            PreparedStatement prSt = getDbConnection().prepareStatement(select);
            ResultSet result = prSt.executeQuery(select);
            int count = 0;

            while (result.next()) {
                String address = result.getString("address");
                String city = result.getString("city");
                String country = result.getString("country");
                res = new WarehouseBuilderImpl().setAddress(address).setCity(city).setCountry(country).build();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return res;
    }

    public String deleteWarehouseById(int id) {
        try {
            String delete = "DELETE FROM warehouses WHERE id=" + id;

            PreparedStatement prSt = getDbConnection().prepareStatement(delete);

            int rowsDeleted = prSt.executeUpdate();
            if (rowsDeleted > 0) {
                return "A warehouse was deleted successfully!";
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return "ID not found";
    }

    public String updateWarehouseById(int id, Warehouse warehouse) {
        try {
            String update = "UPDATE warehouses SET address=?, city=?, country=? WHERE id=" + id;

            PreparedStatement prSt = getDbConnection().prepareStatement(update);

            prSt.setString(1, warehouse.getAddress());
            prSt.setString(2, warehouse.getCity());
            prSt.setString(3, warehouse.getCountry());

            int rowsUpdated = prSt.executeUpdate();
            if (rowsUpdated > 0) {
                return "An existing warehouse was updated successfully!";
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return "ID not found";
    }
}
