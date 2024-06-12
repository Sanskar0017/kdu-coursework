package sanskar.model;

public class Tyre {
    private String name;
    private double price;

    public Tyre(String name, double price) {
        this.name = name;
        this.price = price;
    }


    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Tyre{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
