package model;

public class Laptop {
    private Integer id;
    private String model;
    private int price;
    private int count;
    private Country country;

    public Laptop() {
    }

    public Laptop(Integer id, String model, int price, int count) {
        this.id = id;
        this.model = model;
        this.price = price;
        this.count = count;
    }

    public Laptop(Integer id, String model, int price, int count, Country country) {
        this.id = id;
        this.model = model;
        this.price = price;
        this.count = count;
        this.country = country;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }

    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }
    public void setCount(int count) {
        this.count = count;
    }

    public Country getCountry() {
        return country;
    }
    public void setCountry(Country country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", price=" + price +
                ", count=" + count +
                ", country=" + country.getName() +
                '}';
    }
}
