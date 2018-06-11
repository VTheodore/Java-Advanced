package L06FunctionalProgrammingEXC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.BiConsumer;

public class p05AppliedArithmetic {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int[] numbers = Arrays.stream(in.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        BiConsumer<int[], String> doArithmetics = (nums, command) -> {

            if ("add".equals(command)){
                for (int i = 0; i < nums.length; i++) {
                    nums[i] += 1;
                }
            }else if ("multiply".equals(command)){
                for (int i = 0; i < nums.length; i++) {
                    nums[i] *= 2;
                }
            }else if ("subtract".equals(command)){
                for (int i = 0; i < nums.length; i++) {
                    nums[i] -= 1;
                }
            }else if ("print".equals(command)){
                for (int num : nums) {
                    System.out.print(num + " ");
                }
                System.out.println();
            }
        };

        while (true){
            String command = in.readLine();
            if (command.equals("end"))break;

            doArithmetics.accept(numbers, command);
        }
    }
}
