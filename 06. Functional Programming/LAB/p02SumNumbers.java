package L06FunctionalProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;

public class p02SumNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String[] input = in.readLine().split(", ");

        Function<String, Integer> parseNum = Integer::parseInt;

        var nums = new LinkedList<>();
        int sum = 0;

        for (String s : input) {
            int num = parseNum.apply(s);
            nums.add(num);
            sum += num;
        }

        System.out.println("Count = " + nums.size());
        System.out.println("Sum = " + sum);
    }
}
