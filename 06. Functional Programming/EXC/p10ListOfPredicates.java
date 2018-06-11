package L06FunctionalProgrammingEXC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.BiPredicate;

public class p10ListOfPredicates {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());
        int[] divisors = Arrays.stream(in.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        BiPredicate<Integer, int[]> isValid = (num, div) -> {
            for (int divisor : div) {
                if (num % divisor != 0) return false;
            }
            
            return true;
        };

        for (int num = 1; num <= n; num++) {
            if (isValid.test(num, divisors)) System.out.printf("%d ", num);
        }
    }
}
