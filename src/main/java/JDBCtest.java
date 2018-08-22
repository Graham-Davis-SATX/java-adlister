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
                    rs.getDate("release_date").toLocalDate(),
                    rs.getDouble("sales"),
                    rs.getString("genre")
            );

            System.out.println(album.getId());
            System.out.println(album.getArtist());
            System.out.println(album.getName());
            System.out.println(album.getReleaseDate());
            System.out.println(album.getReleaseDate());

            // update album record



        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
