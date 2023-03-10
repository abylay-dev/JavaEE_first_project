package db;

import model.Country;
import model.Laptop;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBManager {

    private static Connection con;
    private static PreparedStatement statement;

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/marketplace", "root", "");
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Laptop> getLaptops() throws SQLException {
        statement = con.prepareStatement("SELECT l.*, c.name from laptop l left join country c on c.code=l.country_code");
        ResultSet rs = statement.executeQuery();

        List<Laptop> laptops = new ArrayList<>();

        while (rs.next()) {
            Laptop l = new Laptop(rs.getInt("l.id"),
                    rs.getString("l.model"),
                    rs.getInt("l.price"),
                    rs.getInt("l.count"),
                    new Country(rs.getString("l.country_code"),
                            rs.getString("c.name")));

            laptops.add(l);
        }

        return laptops;
    }

    public static Laptop getLaptop(int id) throws SQLException {
        statement = con.prepareStatement("SELECT l.* from laptop l inner join country c on c.code=l.country_code where id=?");
        statement.setInt(1, id);

        //PreparedStatement statement = con.prepareStatement("SELECT * from laptop where id=" + id);

        ResultSet rs = statement.executeQuery();

        Laptop l = null;
        while (rs.next()) {
            l = new Laptop(rs.getInt("l.id"),
                    rs.getString("l.model"),
                    rs.getInt("l.price"),
                    rs.getInt("l.count"),
                    new Country(rs.getString("l.country_code"),
                            rs.getString("c.name")));
        }

        return l;
    }

    public static void addProduct(Laptop laptop, String country_code) throws SQLException {
        statement = con.prepareStatement("INSERT INTO laptop values (null, ?, ?, ?, ?)");
        statement.setString(1, laptop.getModel());
        statement.setInt(2, laptop.getPrice());
        statement.setInt(3, laptop.getCount());
        statement.setString(4, country_code);

        statement.executeUpdate();
    }

    public static void updateProduct(Laptop laptop, String country_code) throws SQLException {
        //TODO
    }

    public static int deleteProduct(int id) throws SQLException {
        statement = con.prepareStatement("DELETE FROM laptop WHERE id=" + id);
        return statement.executeUpdate();
    }

    public static List<Country> getCountries() throws SQLException {
        statement = con.prepareStatement("SELECT * from country");

        ResultSet rs = statement.executeQuery();

        List<Country> countries = new ArrayList<>();
        while (rs.next()) {
            Country c = new Country(rs.getString("code"),
                    rs.getString("name"));

            countries.add(c);
        }
        return countries;
    }


}
