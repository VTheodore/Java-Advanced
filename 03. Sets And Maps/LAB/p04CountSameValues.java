package L03JavaAdvancedSetsAndMaps;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class p04CountSameValues {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] numbers = in.nextLine().split("\\s+");
        Map<String, Integer> occurrences = new HashMap<>();

        for (String number : numbers) {
            if (!occurrences.containsKey(number)){
                occurrences.put(number, 1);
            }else {
                occurrences.put(number, occurrences.get(number) + 1);
            }
        }

        for (String num : occurrences.keySet()) {
            System.out.printf("%s - %d times%n", num, occurrences.get(num));
        }

    }
}
