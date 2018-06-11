package L06FunctionalProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class p01SortEvenNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> nums = Arrays
                .stream(in.readLine().split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        nums.removeIf(n -> n % 2 != 0);

        System.out.println(nums.toString().replace("[", "").replace("]", ""));
        nums.sort(Integer::compareTo);

        System.out.println(nums.toString().replace("[", "").replace("]", ""));
    }
}
