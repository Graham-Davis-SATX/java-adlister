import com.mysql.cj.jdbc.Driver;

import java.sql.*;

public class JDBCtest {

    public static void main(String[] args) {
        try {

            DriverManager.registerDriver(new Driver());

            Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost/codeup_test_db?serverTimezone=UTC&useSSL=false",
                    "root",
                    "codeup"
            );


            Statement statement = conn.createStatement();

            String query = "SELECT * FROM albums";

            ResultSet rs = statement.executeQuery(query);

            rs.next();

//            System.out.println(rs.getString(1));
//            System.out.println(rs.getString(2));
//            System.out.println(rs.getString(3));
//            System.out.println(rs.getString(4));
//            System.out.println(rs.getString(5));
//            System.out.println(rs.getString(6));


            ResultSetMetaData rsmd = rs.getMetaData();
            int colCount = rsmd.getColumnCount();
            for (int i = 1; i <= colCount; i += 1) {
                System.out.println(rsmd.getColumnName(i));
            }

        // use Album model

            rs.beforeFirst();
            rs.next();

            Album album = new Album(rs.getLong("id"),
                rs.getString("artist"),
                rs.getString("name"),
                rs.getInt("release_date"),
                rs.getDouble("sales"),
                rs.getString("genre")
            );

            System.out.println(album.getId());
            System.out.println(album.getArtist());
            System.out.println(album.getName());
            System.out.println(album.getReleaseDate());
            System.out.println(album.getReleaseDate());

            // update album record

            Album updateAlbum = new Album(
                    2,
                    "Deftones",
                    "White Pony",
                    2000,
                    10,
                    "alt, metal"
            );

            String updateQuery = String.format("UPDATE albums SET artist = '%s', name = '%s', release_date = %d, sales = %f, genre = '%s' WHERE id = %d",
                    updateAlbum.getArtist(),
                    updateAlbum.getName(),
                    updateAlbum.getReleaseDate(),
                    updateAlbum.getSales(),
                    updateAlbum.getGenre(),
                    updateAlbum.getId()
            );

            boolean success = statement.execute(updateQuery);
            int numberOfRowsEffected = statement.executeUpdate(updateQuery);

            // insert album

            Album brandNewAlbum = new Album(
                "The Cure",
                "Disintegration",
                1989,
                15,
                "alt, goth, rock"
            );

            String insertQuery = String.format("INSERT INTO albums (artist, name, release_date, sales, genre) VALUES ('%s', '%s', %d, %f, '%s')",
                brandNewAlbum.getArtist(),
                brandNewAlbum.getName(),
                brandNewAlbum.getReleaseDate(),
                brandNewAlbum.getSales(),
                brandNewAlbum.getGenre()
            );

            statement.executeUpdate(insertQuery, Statement.RETURN_GENERATED_KEYS);
            rs = statement.getGeneratedKeys();

            if (rs.next()) {
                System.out.println("Inserted id is: " + rs.getLong(1));
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
