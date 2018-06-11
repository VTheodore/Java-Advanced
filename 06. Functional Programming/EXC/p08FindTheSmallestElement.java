package L06FunctionalProgrammingEXC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class p08FindTheSmallestElement {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> numbers = Arrays.stream(in.readLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Function<List<Integer>, Integer> getIndexOfSmallestEl = nums -> {
            int smallestEl = Integer.MAX_VALUE;

            for (Integer num : nums) {
                if (num <= smallestEl) smallestEl = num;
            }

            return nums.lastIndexOf(smallestEl);
        };

        System.out.println(getIndexOfSmallestEl.apply(numbers));
    }
}
