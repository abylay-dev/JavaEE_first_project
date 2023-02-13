package model;

public class Laptop {
    private String model;
    private int price;
    private int count;

    public Laptop() {
    }

    public Laptop(String model, int price, int count) {
        this.model = model;
        this.price = price;
        this.count = count;
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
}
