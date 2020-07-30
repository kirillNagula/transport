package dao;

import connections.MySqlConnections;
import model.Country;
import model.Transport;
import model.TransportType;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DbTransportDao {

    public List<Transport> get() {
        List<Transport> transports = new ArrayList<>();
        try (Connection connection = MySqlConnections.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT t.*, tt.name AS transport_type FROM transport t LEFT JOIN transporttype tt ON type_id = tt.id;");
            while (result.next()) {
                Transport transport = new Transport();
                transport.setId(result.getInt("id"));
                transport.setName(result.getString("name"));
                transport.setNumPassenger(result.getInt("numPassenger"));
                transport.setNumWeight(result.getInt("numWeight"));
                transport.setPriceByKm(result.getInt("priceByKm"));
                transport.setSpeed(result.getInt("speed"));
                TransportType transportType = new TransportType(result.getInt("type_id"), result.getString("transport_type"));
                transport.setTransportType(transportType);
                transports.add(transport);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return transports;
    }

    public void addTransport(Transport transport){
        try(Connection connection = MySqlConnections.getConnection()) {
            String sql = "INSERT INTO transport (name, speed, numPassenger, numWeight, priceByKm, type_id) VALUES (?,?,?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,transport.getName());
            statement.setInt(2,transport.getSpeed());
            statement.setInt(3,transport.getNumPassenger());
            statement.setInt(4,transport.getNumWeight());
            statement.setInt(5,transport.getPriceByKm());
            statement.setInt(6, transport.getTransportType().getId());
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void editTransport(Transport transport){
        try(Connection connection = MySqlConnections.getConnection()) {
            String sql = "UPDATE transport SET name = ?, speed = ?, numPassenger = ?, numWeight = ?, priceByKm = ?, type_id = ? WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,transport.getName());
            statement.setInt(2,transport.getSpeed());
            statement.setInt(3,transport.getNumPassenger());
            statement.setInt(4,transport.getNumWeight());
            statement.setInt(5,transport.getPriceByKm());
            statement.setInt(6, transport.getTransportType().getId());
            statement.setInt(7, transport.getId());
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeTransport(Transport transport){
        try(Connection connection = MySqlConnections.getConnection()) {
            String sql = "DELETE FROM transport WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, transport.getId());
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Transport> getWhereAirport(int passenger, int weight){
        List<Transport> transports = new ArrayList<>();
        try(Connection connection = MySqlConnections.getConnection()) {
            String sql = "SELECT t.*, tt.name AS transport_type FROM transport t LEFT JOIN transporttype tt ON type_id = tt.id WHERE type_id = 2 AND numPassenger >= ? AND numWeight >= ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, passenger);
            statement.setInt(2, weight);
            ResultSet result = statement.executeQuery();
            while (result.next()){
                Transport transport = new Transport();
                transport.setId(result.getInt("id"));
                transport.setName(result.getString("name"));
                transport.setNumPassenger(result.getInt("numPassenger"));
                transport.setNumWeight(result.getInt("numWeight"));
                transport.setPriceByKm(result.getInt("priceByKm"));
                transport.setSpeed(result.getInt("speed"));
                TransportType transportType = new TransportType(result.getInt("type_id"), result.getString("transport_type"));
                transport.setTransportType(transportType);
                transports.add(transport);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  transports;
    }

    public List<Transport> getWhereSeaPort(int passenger, int weight){
        List<Transport> transports = new ArrayList<>();
        try(Connection connection = MySqlConnections.getConnection()) {
            String sql = "SELECT t.*, tt.name AS transport_type FROM transport t LEFT JOIN transporttype tt ON type_id = tt.id WHERE type_id = 3 AND numPassenger >= ? AND numWeight >= ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, passenger);
            statement.setInt(2, weight);
            ResultSet result = statement.executeQuery();
            while (result.next()){
                Transport transport = new Transport();
                transport.setId(result.getInt("id"));
                transport.setName(result.getString("name"));
                transport.setNumPassenger(result.getInt("numPassenger"));
                transport.setNumWeight(result.getInt("numWeight"));
                transport.setPriceByKm(result.getInt("priceByKm"));
                transport.setSpeed(result.getInt("speed"));
                TransportType transportType = new TransportType(result.getInt("type_id"), result.getString("transport_type"));
                transport.setTransportType(transportType);
                transports.add(transport);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  transports;
    }
    public List<Transport> getWhereRoad(int passenger, int weight){
        List<Transport> transports = new ArrayList<>();
        try(Connection connection = MySqlConnections.getConnection()) {
            String sql = "SELECT t.*, tt.name AS transport_type FROM transport t LEFT JOIN transporttype tt ON type_id = tt.id WHERE type_id = 1 AND numPassenger >= ? AND numWeight >= ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, passenger);
            statement.setInt(2, weight);
            ResultSet result = statement.executeQuery();
            while (result.next()){
                Transport transport = new Transport();
                transport.setId(result.getInt("id"));
                transport.setName(result.getString("name"));
                transport.setNumPassenger(result.getInt("numPassenger"));
                transport.setNumWeight(result.getInt("numWeight"));
                transport.setPriceByKm(result.getInt("priceByKm"));
                transport.setSpeed(result.getInt("speed"));
                TransportType transportType = new TransportType(result.getInt("type_id"), result.getString("transport_type"));
                transport.setTransportType(transportType);
                transports.add(transport);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  transports;
    }

}
