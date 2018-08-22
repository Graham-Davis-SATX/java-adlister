import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLAlbumsDao implements Albums {

    private Connection conn;

    public MySQLAlbumsDao(Config config) {
        try {
            DriverManager.registerDriver(new Driver());
            this.conn = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUser(),
                    config.getPass()
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Album> findAll() {
        try {
            Statement stmt = conn.createStatement();
            String findAllQuery = "SELECT * FROM albums";
            ResultSet rs = stmt.executeQuery(findAllQuery);
            return buildAlbums(rs);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("problem with building albums");
        }
    }

    //    private long id;
    //    private String artist;
    //    private String name;
    //    private int releaseDate;
    //    private double sales;
    //    private String genre;
    private List<Album> buildAlbums(ResultSet rs) throws SQLException {
        List<Album> albums = new ArrayList<>();
        while(rs.next()) {
            albums.add(
                    new Album(
                            rs.getLong("id"),
                            rs.getString("artist"),
                            rs.getString("name"),
                            rs.getInt("release_date"),
                            rs.getDouble("sales"),
                            rs.getString("genre")
                    )
            );
        }
        return albums;
    }

}
