package db;

import model.Laptop;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBManager {

    private static Connection con;

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/marketplace", "root", "");
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Laptop> getLaptops() throws SQLException {
        PreparedStatement statement = con.prepareStatement("SELECT * from laptop");
        ResultSet rs = statement.executeQuery();

        List<Laptop> laptops = new ArrayList<>();

        while (rs.next()) {
            Laptop l = new Laptop();
            l.setId(rs.getInt("id"));
            l.setModel(rs.getString("model"));
            l.setPrice(rs.getInt("price"));
            l.setCount(rs.getInt("count"));

            laptops.add(l);
        }

        return laptops;
    }

    public static Laptop getLaptop(int id) {
//        for (Laptop l : laptops) {
//            if (l.getId() == id) {
//                return l;
//            }
//        }
        return null;
    }
}
