package L01IntroToJava_Lab;

import java.util.Scanner;

public class P05TransportPrice {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        double travelDistance = Double.parseDouble(in.nextLine());
        String timeOfDay = in.nextLine();

        double price = 0.0;

        if (travelDistance >= 20 && travelDistance < 100) {
            price = travelDistance * 0.09; //price
        } else if (travelDistance >= 100) {
            price = travelDistance * 0.06;
        } else {
            if ("day".equals(timeOfDay)) {
                price = 0.7 + 0.79 * travelDistance;
            }else if ("night".equals(timeOfDay)){
                price = 0.7 + 0.9 * travelDistance;
            }
        }

        System.out.printf("%.2f", price);
    }
}
