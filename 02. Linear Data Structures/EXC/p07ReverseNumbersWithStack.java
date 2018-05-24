package L02LinearDataStructuresEXC;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class p07ReverseNumbersWithStack {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int[] nums = Arrays.stream(in.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < nums.length; i++) {
            stack.push(nums[i]);
        }

        for (Integer num : stack) {
            System.out.print(num + " ");
        }

    }
}
