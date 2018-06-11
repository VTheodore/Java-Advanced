package L06FunctionalProgrammingEXC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Predicate;

public class p04FindEvenAndOdds {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int[] bound = Arrays.stream(in.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int lowerBound = bound[0];
        int upperBound = bound[1];

        String type = in.readLine();

        Predicate<Integer> even = num -> num % 2 == 0;

        Predicate<Integer> odd = num -> num % 2 != 0;

        for (int num = lowerBound; num <= upperBound; num++) {
            if (type.equals("even")){
                if (even.test(num)){
                    System.out.print(num + " ");
                }
            }else {
                if (odd.test(num)){
                    System.out.print(num + " ");
                }
            }
        }
    }
}
