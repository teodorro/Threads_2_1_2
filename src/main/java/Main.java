import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static final int AMOUNT = 10;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        double recommendedPrice = getRecommendedPrice();
        Set<Deal> deals = generateDeals(AMOUNT, recommendedPrice);

        System.out.println("\n=== recommended deals ===");
        deals.stream()
                .filter(it -> it.getPrice() >= recommendedPrice * it.getLength() * it.getWidth())
                .forEach(deal -> System.out.println(deal));
        System.out.println("\n=== suspicious deals ===");
        deals.stream()
                .filter(it -> it.getPrice() < recommendedPrice * it.getLength() * it.getWidth())
                .forEach(deal -> System.out.println(deal));
    }

    private static double getRecommendedPrice(){
        System.out.println("\nPlease, enter recommended price for square meter:");
        while (true) {
            try {
                double price = scanner.nextDouble();
                if (price <= 0){
                    System.out.println("price should be >= 0");
                }
                return price;
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Smth is wrong with input data. Try again, please");
            }
        }
    }

    private static Set<Deal> generateDeals(int amount, double avgMeterPrice){
        Random rand = new Random(System.currentTimeMillis());
        Set<Deal> deals = new HashSet<>();
        for (int i = 0; i < amount; i++) {
            int width = rand.nextInt(99) + 1;
            int length = rand.nextInt(99) + 1;
            double price = width * length * (avgMeterPrice + avgMeterPrice / 5 * (rand.nextDouble() - 0.5));
            deals.add(new Deal(width, length, price));
        }
        return deals;
    }
}
