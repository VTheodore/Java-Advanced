package L03JavaAdvancedSetsAndMaps;

import java.util.*;

public class p03VoinaTheNumberGame {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        LinkedHashSet<Integer> firstPlayer = getPlayerNumbers(in);
        LinkedHashSet<Integer> secondPlayer = getPlayerNumbers(in);

        for (int i = 0; i < 50; i++) {
            int firstNumber = firstPlayer.iterator().next();
            firstPlayer.remove(firstNumber);

            int secondNumber = secondPlayer.iterator().next();
            secondPlayer.remove(secondNumber);


            if (firstNumber > secondNumber) {
                firstPlayer.add(firstNumber);
                firstPlayer.add(secondNumber);
            } else if (secondNumber > firstNumber) {
                secondPlayer.add(firstNumber);
                secondPlayer.add(secondNumber);
            }

            if (firstPlayer.isEmpty() || secondPlayer.isEmpty()){
                System.out.println(secondPlayer.isEmpty() ? "First player win!" : "Second player win!");
                return;
            }
        }

        System.out.println("Draw!");
    }

    private static LinkedHashSet<Integer> getPlayerNumbers(Scanner in) {
        LinkedHashSet<Integer> res = new LinkedHashSet<>();
        String[] input = in.nextLine().split("\\s+");

        for (String s : input) {
            res.add(Integer.parseInt(s));
        }

        return res;
    }
}