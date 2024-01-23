package sanskar.model;

import org.springframework.stereotype.Component;

@Component
public class Vehicle {
    private Tyre tyre;
    private Speaker speaker;
    private final double price;

    public Vehicle(Tyre tyre, Speaker speaker, double v) {
        this.tyre = tyre;
        this.speaker = speaker;
        this.price=generatePrice();
    }

    public double generatePrice()
    {
        return tyre.getPrice()+speaker.getPrice();
    }

    public Tyre getTyre() {
        return tyre;
    }

    public Speaker getSpeaker() {
        return speaker;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "\ntyre=" + tyre +
                ", \nspeaker=" + speaker +
                ", \nprice=" + price +
                '}';
    }
}
