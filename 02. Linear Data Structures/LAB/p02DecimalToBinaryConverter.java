package L02LinearDataStructures;

import java.util.ArrayDeque;
import java.util.Scanner;

public class p02DecimalToBinaryConverter {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int decimalNum = in.nextInt();
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        if (decimalNum == 0){
            System.out.println("0");
            return;
        }

        while (decimalNum != 0) {
            stack.push(decimalNum % 2);
            decimalNum /= 2;
        }

        while (stack.size() > 0){
            System.out.printf("%d", stack.pop());
        }

        System.out.println();
    }
}
