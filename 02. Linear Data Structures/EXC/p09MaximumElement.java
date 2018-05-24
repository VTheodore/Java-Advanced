package L02LinearDataStructuresEXC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class p09MaximumElement {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader((System.in)));

        int numberOfCommands = Integer.parseInt(reader.readLine());

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        ArrayDeque<Integer> maxStack = new ArrayDeque<>();

        int maxNumber = Integer.MIN_VALUE;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numberOfCommands; i++) {
            String[] command = reader.readLine().split(" ");
            short typeOfCommand = Short.parseShort(command[0]);

            if (numberOfCommands <= 1 && typeOfCommand != 3) {
                break;
            }

            switch (typeOfCommand) {
                case (1):
                    int currentElement = Integer.parseInt(command[1]);
                    stack.push(currentElement);
                    if (maxNumber < currentElement) {
                        maxNumber = currentElement;
                        maxStack.push(currentElement);
                    }
                    break;
                case (2):
                    int current = stack.pop();
                    if (current == maxNumber) {
                        maxStack.pop();
                        if (maxStack.size() > 0) {
                            maxNumber = maxStack.peek();
                        } else {
                            maxNumber = Integer.MIN_VALUE;
                        }
                    }
                    break;
                case (3):
                    sb.append(maxNumber).append(System.lineSeparator());
                    break;
            }
        }
        System.out.println(sb.toString());
    }
}
