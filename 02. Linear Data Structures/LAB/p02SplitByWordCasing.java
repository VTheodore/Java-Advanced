package L02LinearDataStructures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class p02SplitByWordCasing {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] words = in.nextLine().split("[,;:.!()\"'\\\\/\\[\\]\\s]+");

        List<String> lowerCaseWords = new ArrayList<>();
        List<String> upperCaseWords = new ArrayList<>();
        List<String> mixedCaseWords = new ArrayList<>();


        for (String word : words) {
            if (word.equals(""))continue;

            String type = getTypeOfWord(word);

            switch (type) {
                case "lowercase":
                    lowerCaseWords.add(word);
                    break;
                case "mixedcase":
                    mixedCaseWords.add(word);
                    break;
                case "uppercase":
                    upperCaseWords.add(word);
                    break;
            }
        }

        System.out.printf("Lower-case: %s%n", String.join(", ", lowerCaseWords));
        System.out.printf("Mixed-case: %s%n", String.join(", ", mixedCaseWords));
        System.out.printf("Upper-case: %s%n", String.join(", ", upperCaseWords));
    }

    private static String getTypeOfWord(String word) {
        char[] chars = word.toCharArray();

        for (char ch : chars) {
            if (!((ch >= 65 && ch <= 90) || (ch >= 97 && ch <= 122)))return "mixedcase";
        }

        if (word.equals(word.toUpperCase())){
            return "uppercase";
        }else if (word.equals(word.toLowerCase())){
            return "lowercase";
        }else {
            return "mixedcase";
        }
    }
}
