package L01IntroToJavaEXC;

import java.util.*;
import java.util.stream.Collectors;

public class p11GameOfNames {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = Integer.parseInt(in.nextLine());
        String[] inputs = new String[2 * n];
        LinkedHashMap<String, Integer> playersAndScores = new LinkedHashMap<>();

        for (int i = 0; i < 2 * n ; i++) {
            String input = in.nextLine();
            inputs[i] = input;
        }

        for (int i = 1; i <= 2 * n; i++) {
            if (i % 2 != 0){
                playersAndScores.put(inputs[i - 1], 0);
            }else {
                playersAndScores.put(inputs[i - 2], Integer.parseInt(inputs[i - 1]));
            }
        }

        for (String name : playersAndScores.keySet()) {
            char[] lettersInName = name.toCharArray();

            for (char c : lettersInName) {
                if (c % 2 != 0){
                    playersAndScores.put(name, playersAndScores.get(name) - (int)c);
                }else {
                    playersAndScores.put(name, playersAndScores.get(name) + (int)c);
                }
            }
        }


        Map<String,Integer> sorted =
                playersAndScores.entrySet().stream()
                        .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                        .collect(Collectors.toMap(
                                Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        for (String s : sorted.keySet()) {
            System.out.printf("The winner is %s - %d points", s, sorted.get(s));
            break;
        }
    }
}
