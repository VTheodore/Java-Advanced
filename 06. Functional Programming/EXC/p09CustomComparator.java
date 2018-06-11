package L06FunctionalProgrammingEXC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;

public class p09CustomComparator {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int[] numbers = Arrays.stream(in.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        var evenNumbers = new LinkedList<Integer>();
        var oddNumbers = new LinkedList<Integer>();

        for (int number : numbers) {
            if (number % 2 == 0){
                evenNumbers.add(number);
            }else {
                oddNumbers.add(number);
            }
        }

        evenNumbers.sort(Integer::compareTo);
        oddNumbers.sort(Integer::compareTo);

        for (Integer num : evenNumbers) {
            System.out.printf("%d ", num);
        }

        for (Integer num : oddNumbers) {
            System.out.printf("%d ", num);
        }
    }
}
