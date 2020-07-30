package dao;

import connections.MySqlConnections;
import model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DbUserDao {

    public String getAccess(User user){
        try(Connection connection = MySqlConnections.getConnection()) {
            String sql = "SELECT userAccess FROM users WHERE user = ? AND password = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, user.getName());
            statement.setString(2, user.getPassword());
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                user.setUserAccess(result.getString("userAccess"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user.getUserAccess();
    }
}
