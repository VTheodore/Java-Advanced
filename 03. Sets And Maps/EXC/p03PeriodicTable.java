package L03JavaAdvancedSetsAndMapsEXC;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class p03PeriodicTable {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());

        Set<String> elements = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            String[] el = in.nextLine().split("\\s+");

            for (String e : el) {
                elements.add(e);
            }
        }

        for (String element : elements) {
            System.out.printf("%s ", element);
        }
    }
}
