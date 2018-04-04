import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.jdbc.Driver;

public class MySQLAdsDao implements Ads {
    private static Connection connection = null;

    protected MySQLAdsDao(Config config) {
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUsername(),
                    config.getPassword()
            );
            if (connection != null) {
                System.out.println("Connected to database");
            }
        } catch (SQLException e) {
            e.getSQLState();
        }
    }

    @Override
    public List<Ad> all() {
        List<Ad> ads = new ArrayList<>();
        try {
            Statement stmt = connection.createStatement();
            ResultSet results = stmt.executeQuery("SELECT * FROM ads");
            while (results.next()) {
                Ad ad = new Ad(
                        results.getLong("id"),
                        results.getLong("user_id"),
                        results.getString("title"),
                        results.getString("description")
                );
                System.out.println("added item");
                ads.add(ad);
            }
        } catch (SQLException e) {
            e.getSQLState();
        }
        return ads;
    }

    @Override
    public Long insert(Ad ad) {
        String query = "INSERT INTO ads (user_id, title, description) VALUES " +
                "(" + ad.getUserId() + ",'" + ad.getTitle() + "', '" + ad.getDescription() + "')";
        Long id = null;
        try {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = stmt.getGeneratedKeys();
            System.out.println(rs);
            if (rs.next()) {
                id = rs.getLong(1);
                return id;
            }
        } catch (SQLException e) {
            throw new RuntimeException("ERROR inserting ad ", e);
        }
    return null;
    }
}
