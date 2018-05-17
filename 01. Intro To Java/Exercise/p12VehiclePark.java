package L01IntroToJavaEXC;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class p12VehiclePark {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] input = in.nextLine().split("\\s+");

        List<String> vehicles = new ArrayList<>(Arrays.asList(input));

        int soldVehicles = 0;

        while (true){
            String command = in.nextLine();

            if (command.equals("End of customers!")){
                break;
            }

            String typeOfVehicle = command.split("\\s+")[0].toLowerCase();
            int seats = Integer.parseInt(command.split("\\s+")[2]);

            String desiredVehicle = "";
            int price = 0;

            if (typeOfVehicle.equals("car")){
                desiredVehicle = "c" + seats;
                price = 99 * seats;
            }else if (typeOfVehicle.equals("bus")){
                desiredVehicle = "b" + seats;
                price = 98 * seats;
            }else if (typeOfVehicle.equals("van")){
                desiredVehicle = "v" + seats;
                price = 118 * seats;
            }

            if (vehicles.contains(desiredVehicle)){
               vehicles.remove(desiredVehicle);
                System.out.printf("Yes, sold for %d$%n", price);
                soldVehicles++;
            }else {
                System.out.println("No");
            }
        }

        System.out.printf("Vehicles left: %s%n", String.join(", ", vehicles));
        System.out.printf("Vehicles sold: %d%n", soldVehicles);
    }
}
