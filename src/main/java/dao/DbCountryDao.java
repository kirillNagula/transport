package dao;

import connections.MySqlConnections;
import model.Country;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DbCountryDao {

    public List<Country> get() {
        List<Country> countries = new ArrayList<>();
        try (Connection connection = MySqlConnections.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM country");
            while (result.next()) {
                Country country = new Country();
                country.setId(result.getInt("idCountry"));
                country.setName(result.getString("city"));
                country.setLatitude(result.getDouble("latitude"));
                country.setLongitude(result.getDouble("longitude"));
                country.setAirport(result.getBoolean("isAirport"));
                country.setSeaPort(result.getBoolean("isSeaPort"));
                countries.add(country);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return countries;
    }

    public Country getCityParameters(String city) {
        Country country = new Country();
        try (Connection connection = MySqlConnections.getConnection()) {
            String sql = "SELECT * FROM country WHERE city = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, city);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                country.setId(result.getInt("idCountry"));
                country.setName(result.getString("city"));
                country.setLatitude(result.getDouble("latitude"));
                country.setLongitude(result.getDouble("longitude"));
                country.setAirport(result.getBoolean("isAirport"));
                country.setSeaPort(result.getBoolean("isSeaPort"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return country;
    }

    public void addCity(Country country){
        try(Connection connection = MySqlConnections.getConnection()) {
            String sql = "INSERT INTO country (city, latitude, longitude, isAirport, isSeaPort) VALUES(?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, country.getName());
            statement.setDouble(2, country.getLatitude());
            statement.setDouble(3, country.getLongitude());
            statement.setBoolean(4, country.isAirport());
            statement.setBoolean(5, country.isSeaPort());
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void editCity(Country country){
        try(Connection connection = MySqlConnections.getConnection()) {
            String sql = "UPDATE country SET city = ?, latitude = ?, longitude = ?, isAirport = ?, isSeaPort = ? WHERE idCountry = ?" ;
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, country.getName());
            statement.setDouble(2, country.getLatitude());
            statement.setDouble(3, country.getLongitude());
            statement.setBoolean(4, country.isAirport());
            statement.setBoolean(5, country.isSeaPort());
            statement.setInt(6, country.getId());
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeCity(Country country){
        try(Connection connection = MySqlConnections.getConnection()) {
            String sql = "Delete FROM country  WHERE idCountry = ?" ;
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, country.getId());
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
