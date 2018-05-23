package L03JavaAdvancedSetsAndMaps;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class p01ParkingLot {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Set<String> cars = new HashSet<>();

        while (true) {
            String[] input = in.nextLine().split(", ");
            if ("END".equals(input[0])) break;

            String direction = input[0];
            String carNumber = input[1];

            if ("IN".equals(direction)) {
                cars.add(carNumber);
            } else if ("OUT".equals(direction)) {
                cars.remove(carNumber);
            }
        }

        if (cars.isEmpty()) {
            System.out.println("Parking Lot is Empty");
        } else {
            for (String car : cars) {
                System.out.println(car);
            }
        }
    }
}
