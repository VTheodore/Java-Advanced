package L01IntroToJava_Lab;

import java.math.BigDecimal;
import java.util.Scanner;

public class P03EuroTrip {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        double quantity = Double.parseDouble(in.nextLine());
        BigDecimal priceInLeva = new BigDecimal(quantity * 1.2);
        BigDecimal exchangeRate = new BigDecimal("4210500000000");
        BigDecimal price = priceInLeva.multiply(exchangeRate);

        System.out.printf("%.2f marks", price);
    }
}
