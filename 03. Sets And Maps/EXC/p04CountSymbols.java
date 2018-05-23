package L03JavaAdvancedSetsAndMapsEXC;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class p04CountSymbols {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        char[] input = in.nextLine().toCharArray();
        Map<Character, Integer> occurrences = new TreeMap<>();

        for (char c : input) {
            if (!occurrences.containsKey(c)){
                occurrences.put(c, 1);
            }else{
                occurrences.put(c, occurrences.get(c) + 1);
            }
        }

        for (Character ch : occurrences.keySet()) {
            System.out.printf("%c: %d time/s%n",ch, occurrences.get(ch));
        }

    }
}
