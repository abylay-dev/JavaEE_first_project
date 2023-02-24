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
            Laptop l = new Laptop(rs.getInt("id"),
                    rs.getString("model"),
                    rs.getInt("price"),
                    rs.getInt("count"));

            laptops.add(l);
        }

        return laptops;
    }

    public static Laptop getLaptop(int id) throws SQLException {
        PreparedStatement statement = con.prepareStatement("SELECT * from laptop where id=?");
        statement.setInt(1, id);

        //PreparedStatement statement = con.prepareStatement("SELECT * from laptop where id=" + id);

        ResultSet rs = statement.executeQuery();

        Laptop l = null;
        while (rs.next()) {
            l = new Laptop(rs.getInt("id"),
                    rs.getString("model"),
                    rs.getInt("price"),
                    rs.getInt("count"));
        }

        return l;
    }

    public static void addProduct(Laptop laptop) throws SQLException {
        PreparedStatement statement = con.prepareStatement("INSERT INTO laptop values (null, ?, ?, ?)");
        statement.setString(1, laptop.getModel());
        statement.setInt(2, laptop.getPrice());
        statement.setInt(3, laptop.getCount());

        statement.executeUpdate();
    }

    public static void updateProduct(Laptop laptop) throws SQLException {
        //TODO
    }
}
