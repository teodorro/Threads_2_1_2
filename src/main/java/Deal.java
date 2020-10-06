import javax.swing.text.NumberFormatter;

public class Deal {
    private double width;
    private double length;
    private double price;

    public Deal(double width, double length, double price) {
        this.width = width;
        this.length = length;
        this.price = price;
    }

    public double getWidth() {
        return width;
    }

    public double getLength() {
        return length;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return width + " x " + length + " :: " + String.format("%.2f", price) + "$";
    }
}
