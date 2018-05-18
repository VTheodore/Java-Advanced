package L02LinearDataStructures;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class p07MatchingBrackets {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String input = in.nextLine();
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);

            if ('(' == ch) {
                stack.push(i);
            } else if (')' == ch) {
                int startingIndex = stack.pop();
                String expr = input.substring(startingIndex, i + 1);
                System.out.println(expr);
            }
        }
    }
}
