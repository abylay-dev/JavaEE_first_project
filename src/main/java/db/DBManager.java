package db;

import model.Laptop;

import java.util.ArrayList;
import java.util.List;

public class DBManager {
    private static final List<Laptop> laptops = new ArrayList<>();

    static {
        laptops.add(new Laptop("Acer nitro", 400000, 20));
        laptops.add(new Laptop("Asus ZenBook", 500000, 10));
        laptops.add(new Laptop("HP Omen", 600000, 13));
    }

    public static List<Laptop> getLaptops() {
        return laptops;
    }
}
