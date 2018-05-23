package L03JavaAdvancedSetsAndMapsEXC;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.Collections.reverseOrder;
import static java.util.Map.Entry.comparingByValue;
import static java.util.stream.Collectors.toMap;

public class p13SrbskoUnleashed {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Pattern p = Pattern.compile("(?<singer>.+) @(?<place>.+) (?<price>\\d+) (?<count>\\d+)");
        Map<String, LinkedHashMap<String, Integer>> info = new LinkedHashMap<>();

        while (true) {
            String input = in.nextLine();
            if ("End".equals(input))break;

            Matcher m = p.matcher(input);

            String singer = "";
            String place = "";
            int price = 0;
            int count = 0;

            if (m.find()) {
                singer = m.group("singer");
                place = m.group("place");
                price = Integer.parseInt(m.group("price"));
                count = Integer.parseInt(m.group("count"));
            } else {
                continue;
            }
            int totalPrice = price * count;

            if (!info.containsKey(place)) {
                LinkedHashMap<String, Integer> singerAndPrice = new LinkedHashMap<>();

                singerAndPrice.put(singer, totalPrice);

                info.put(place, singerAndPrice);
            } else {

                if (!info.get(place).containsKey(singer)) {
                    LinkedHashMap<String, Integer> singerAndPrice = info.get(place);
                    singerAndPrice.put(singer, totalPrice);

                    info.put(place, singerAndPrice);
                }else {
                    LinkedHashMap<String, Integer> singerAndPrice = info.get(place);
                    singerAndPrice.put(singer, singerAndPrice.get(singer) + totalPrice);

                    info.put(place, singerAndPrice);
                }
            }

        }

        for (String place : info.keySet()) {
            Map<String, Integer> sortedMap = info.get(place).entrySet().stream()
                    .sorted(reverseOrder(comparingByValue()))
                    .collect(toMap(Map.Entry::getKey, Map.Entry::getValue,
                            (e1, e2) -> e1, LinkedHashMap::new));

            System.out.println(place);

            for (String name : sortedMap.keySet()) {
                System.out.printf("#  %s -> %d%n", name, sortedMap.get(name));
            }


        }

    }
}
