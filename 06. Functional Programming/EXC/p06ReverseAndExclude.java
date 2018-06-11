package L06FunctionalProgrammingEXC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.function.BiPredicate;

public class p06ReverseAndExclude {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int[] numbers = Arrays.stream(in.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int n = Integer.parseInt(in.readLine());

        BiPredicate<Integer, Integer> isValidNum = (num, divisor) -> num % divisor != 0;

        var res = new LinkedList<Integer>();

        for (int i = numbers.length - 1; i >= 0; i--) {
            if (isValidNum.test(numbers[i], n))res.add(numbers[i]);
        }

        for (Integer num : res) {
            System.out.printf("%d ", num);
        }
    }
}
