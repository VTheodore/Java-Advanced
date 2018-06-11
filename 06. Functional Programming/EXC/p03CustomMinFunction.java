package L06FunctionalProgrammingEXC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Function;

public class p03CustomMinFunction {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int[] numbers = Arrays.stream(in.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        Function<int[], Integer> minInteger = nums -> {
            int smallestNum = Integer.MAX_VALUE;
            for (int num : nums) {
                if (num < smallestNum)smallestNum = num;
            }

            return smallestNum;
        };

        System.out.println(minInteger.apply(numbers));
    }
}
