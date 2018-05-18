package L02LinearDataStructures;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class p05SimpleCalculator {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] tokens = in.nextLine().split("\\s+");

        ArrayDeque<String> stack = new ArrayDeque<>();

        Collections.addAll(stack, tokens);

        while(stack.size() > 1){
            int num1 = Integer.parseInt(stack.pop());
            String operand = stack.pop();
            int num2 = Integer.parseInt(stack.pop());

            switch (operand){
                case "+":
                    stack.push(num1 + num2 + "");
                    break;
                case "-":
                    stack.push(num1 - num2 + "");
                    break;
            }
        }

        System.out.println(stack.peek());

    }
}
