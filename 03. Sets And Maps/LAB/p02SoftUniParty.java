package L03JavaAdvancedSetsAndMaps;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class p02SoftUniParty {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Set<String> guests = new TreeSet<>();
        String reservationNumber = in.nextLine();

        while (!"PARTY".equals(reservationNumber)){
            guests.add(reservationNumber);
            reservationNumber = in.nextLine();
        }

        while (!"END".equals(reservationNumber)){
            guests.remove(reservationNumber);

            reservationNumber = in.nextLine();
        }

        System.out.println(guests.size());
        for (String guest : guests) {
            System.out.println(guest);
        }

    }
}
