package dao;

import connections.MySqlConnections;
import model.DistanceInfo;
import model.Transport;
import model.TransportType;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DbDistanceInfoDao {


    public void addDistanceInfo(DistanceInfo distanceInfo){
        try(Connection connection = MySqlConnections.getConnection()) {
            String sql = "INSERT INTO distance_info (cityFrom, cityTo, distance, price, time, transport_id) VALUES(?,?,?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, distanceInfo.getCityFrom());
            statement.setString(2, distanceInfo.getCityTo());
            statement.setDouble(3, distanceInfo.getDistance());
            statement.setInt(4, distanceInfo.getPrice());
            statement.setDouble(5, distanceInfo.getTime());
            statement.setInt(6, distanceInfo.getTransport().getId());
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<DistanceInfo> get(){
        List<DistanceInfo> distanceInfo = new ArrayList<>();
        try(Connection connection = MySqlConnections.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT d.*, t.*, tt.name AS type FROM distance_info d LEFT JOIN transport t ON transport_id = t.id left join transporttype tt ON type_id = tt.id;");
            while (resultSet.next()){
                DistanceInfo distanceInfo1 = new DistanceInfo();
                distanceInfo1.setId(resultSet.getInt("id"));
                distanceInfo1.setCityFrom(resultSet.getString("cityFrom"));
                distanceInfo1.setCityTo(resultSet.getString("cityTo"));
                distanceInfo1.setDistance(resultSet.getDouble("distance"));
                distanceInfo1.setTime(resultSet.getDouble("time"));
                distanceInfo1.setPrice(resultSet.getInt("price"));
                Transport transport = new Transport(resultSet.getInt("transport_id"), resultSet.getString("name"),
                                                    resultSet.getInt("speed"), resultSet.getInt("numPassenger"),
                                                    resultSet.getInt("numWeight"), resultSet.getInt("priceByKm"),
                                                    new TransportType(resultSet.getInt("type_id"), resultSet.getString("type")));
                distanceInfo1.setTransport(transport);
                distanceInfo.add(distanceInfo1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return distanceInfo;
    }
}
