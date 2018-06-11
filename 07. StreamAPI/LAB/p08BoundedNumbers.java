package L07StreamAPI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class p08BoundedNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int[] bounds = Arrays.stream(in.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int lowerBound = Math.min(bounds[0], bounds[1]);
        int upperBound = Math.max(bounds[0], bounds[1]);

        List<Integer> numbers = Arrays.stream(in.readLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());

        numbers.stream()
                .filter(n -> n >=lowerBound && n <= upperBound)
                .forEach(el -> System.out.print(el + " "));
    }
}
