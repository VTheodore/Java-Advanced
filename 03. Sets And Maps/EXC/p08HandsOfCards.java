package L03JavaAdvancedSetsAndMapsEXC;

import java.util.*;

public class p08HandsOfCards {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Map<String, HashSet<String>> players = new LinkedHashMap<>();

        while (true) {
            String input = in.nextLine();
            if ("JOKER".equals(input)) break;

            String name = input.split(":")[0];
            String[] cards = input.split(":")[1].split("[, ]+");

            HashSet<String> cardsDistinct = new HashSet<>();
            Collections.addAll(cardsDistinct, cards);

            if (!players.containsKey(name)) {
                players.put(name, cardsDistinct);
            } else {
                HashSet<String> allCards = players.get(name);
                allCards.addAll(cardsDistinct);

                players.put(name, allCards);
            }
        }

        for (String s : players.keySet()) {
            int score = calculateScore(players.get(s));

            System.out.printf("%s: %d%n", s, score);
        }
    }

    static int calculateScore(HashSet<String> cardsDistinct) {
        int score = 0;

        for (String s : cardsDistinct) {
            if (s.equals("")) continue;
            char powerOfCard = s.charAt(0);
            char typeOfCard = s.charAt(s.length() - 1);

            int multipleCard = 1;
            int multipleType = 1;

            switch (typeOfCard) {
                case 'S':
                    multipleType = 4;
                    break;
                case 'H':
                    multipleType = 3;
                    break;
                case 'D':
                    multipleType = 2;
                    break;
            }

            if (Character.isDigit(powerOfCard)) {
                multipleCard = Integer.parseInt(powerOfCard + "");
                if (powerOfCard == '1'){
                    multipleCard = 10;
                }
            } else {
                switch (powerOfCard) {
                    case 'J':
                        multipleCard = 11;
                        break;
                    case 'Q':
                        multipleCard = 12;
                        break;
                    case 'K':
                        multipleCard = 13;
                        break;
                    case 'A':
                        multipleCard = 14;
                        break;
                }
            }

            score += (multipleCard * multipleType);
        }

        return score;
    }
}
