package com.codeup.adlister;

import com.codeup.adlister.models.Album;
import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.Scanner;

public class PreparedStatementsTest {

    public static void main(String[] args) {
        try {

            // ======================== CREATING THE DRIVER and CONNECTION OBJECTS

            DriverManager.registerDriver(new Driver());
            Config config = new Config();
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost/codeup_test_db?serverTimezone=UTC&useSSL=false",
                    "root",
                    "codeup"
            );

            // ======================== PREPARED SEARCH

            Scanner sc = new Scanner(System.in);
            System.out.println("Please enter an album name:");
            String name = sc.nextLine();

            // !!!!!!!!!!!!! EXTREME DANGER !!!!!!!!!!!!!
                // Sgt. Pepper's Lonely Hearts Club Band
                // Thriller' OR 1 = '1
                // Thriller' UNION SELECT *, null, null FROM users WHERE 1 = '1

//                String searchQuery = "SELECT * FROM albums WHERE name = '" + name + "'";
//                PreparedStatement ps = conn.prepareStatement(searchQuery);
//                ResultSet rs = ps.executeQuery();
//
//                while (rs.next()) {
//                    System.out.println(rs.getString(1));
//                    System.out.println(rs.getString(2));
//                    System.out.println(rs.getString(3));
//                    System.out.println(rs.getString(4));
//                    System.out.println(rs.getString(5));
//                    System.out.println(rs.getString(6));
//                }


            // !!! DUE DILIGENCE !!!

//                String safeSearchQuery = "SELECT * FROM albums WHERE name = ?";
//                PreparedStatement ps = conn.prepareStatement(safeSearchQuery);
//                ps.setString(1, name);
//                ResultSet rs = ps.executeQuery();
//
//                while (rs.next()) {
//                    System.out.println(rs.getString(1));
//                    System.out.println(rs.getString(2));
//                    System.out.println(rs.getString(3));
//                    System.out.println(rs.getString(4));
//                    System.out.println(rs.getString(5));
//                    System.out.println(rs.getString(6));
//                }


            // ======================== UPDATE REFACTOR

//            Album updateAlbum = new Album(
//                    2,
//                    "Prince",
//                    "Purple Rain",
//                    1984,
//                    50,
//                    "amazing"
//            );
//
//            String updateQuery = String.format("UPDATE albums SET artist = '%s', name = '%s', release_date = %d, sales = %f, genre = '%s' WHERE id = %d",
//                    updateAlbum.getArtist(),
//                    updateAlbum.getName(),
//                    updateAlbum.getReleaseDate(),
//                    updateAlbum.getSales(),
//                    updateAlbum.getGenre(),
//                    updateAlbum.getId()
//            );
//
//            boolean success = statement.execute(updateQuery);
//            int numberOfRowsEffected = statement.executeUpdate(updateQuery);

            // ======================== INSERTING REFACTOR

//            Album brandNewAlbum = new Album(
//                    "The Cure",
//                    "Disintegration",
//                    1989,
//                    15,
//                    "alt, goth, rock"
//            );
//
//            String insertQuery = String.format("INSERT INTO albums (artist, name, release_date, sales, genre) VALUES ('%s', '%s', %d, %f, '%s')",
//                    brandNewAlbum.getArtist(),
//                    brandNewAlbum.getName(),
//                    brandNewAlbum.getReleaseDate(),
//                    brandNewAlbum.getSales(),
//                    brandNewAlbum.getGenre()
//            );
//
//            statement.executeUpdate(insertQuery, Statement.RETURN_GENERATED_KEYS);
//            rs = statement.getGeneratedKeys();
//
//            if (rs.next()) {
//                System.out.println("Inserted id is: " + rs.getLong(1));
//            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

