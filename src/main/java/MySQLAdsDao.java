import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.jdbc.Driver;

public class MySQLAdsDao implements Ads {
    private static Connection connection = null;
    private static Config config = new Config();
    private List<Ad> ads;

//    public static void main(String[] args) {
//        try {
//            DriverManager.registerDriver(new Driver());
//            connection = DriverManager.getConnection(
//                    config.getUrl(),
//                    config.getUsername(),
//                    config.getPassword()
//            );
//            Statement stmt = connection.createStatement();
//            ResultSet rs = stmt.executeQuery("select 1 + 1 as result");
//            while (rs.next()) {
//                System.out.println(rs.getInt("result"));
//            }
//            System.out.println("would be all");
//        } catch (SQLException e) {
//            e.getErrorCode();
//        }
//    }

    @Override
    public List<Ad> all() {
        if (ads == null) {
            try {
                DriverManager.registerDriver(new Driver());
                connection = DriverManager.getConnection(
                        config.getUrl(),
                        config.getUsername(),
                        config.getPassword()
                );
                Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM adlister_db.ads");
                while (rs.next()) {
                    long id = rs.getLong("id");
                    long userid = rs.getLong("userid");
                    String title = rs.getString("title");
                    String des = rs.getString("description");
                    Ad ad = new Ad (id, userid, title, des);
                    ads.add(ad);
                }
            } catch (SQLException e) {
                e.getSQLState();
            }
        }
        return ads;
    }

    @Override
    public Long insert(Ad ad) {
        return null;
    }
}
