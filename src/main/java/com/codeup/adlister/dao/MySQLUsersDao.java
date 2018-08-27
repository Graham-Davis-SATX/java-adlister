package com.codeup.adlister.dao;


import com.codeup.adlister.models.User;
import com.mysql.cj.jdbc.Driver;

import java.sql.*;

public class MySQLUsersDao implements Users {
    private Connection connection = null;

    public MySQLUsersDao(Config config) {
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUsername(),
                    config.getPassword()
            );
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database!", e);
        }
    }

    @Override

    public User findByUsername(String username) {
        String query = "SELECT * FROM USERS WHERE username = ?";
        try{
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1,username);
            ps.execute();
            ps.getResultSet();
            ResultSet rs = ps.getResultSet();
            if(rs.next()){
                return new User(
                        rs.getLong("id"),
                        rs.getString("username"),
                        rs.getString("email"),
                        rs.getString("password")
                );
            } else return null;


        } catch (SQLException e) {
            throw new RuntimeException("user already exists", e);
        }
    }

    @Override
    public Long insert(User user) {
        String newUser = "INSERT INTO users(username,email,password) VALUES (?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(newUser, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPassword());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);

        } catch (SQLException e) {
            throw new RuntimeException("Error registering account.", e);
        }
    }
}
