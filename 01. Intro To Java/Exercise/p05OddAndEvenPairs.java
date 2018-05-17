package L01IntroToJavaEXC;

import java.util.Arrays;
import java.util.Scanner;

public class p05OddAndEvenPairs {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int[] nums = Arrays
                .stream(in.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        if (nums.length % 2 != 0){
            System.out.println("invalid length");
            return;
        }

        for (int i = 0; i < nums.length - 1; i+=2) {
            if (nums[i] % 2 == 0 && nums[i + 1] % 2 == 0){
                System.out.printf("%d, %d -> both are even%n", nums[i], nums[i + 1]);
            }else if (nums[i] % 2 != 0 && nums[i + 1] % 2 != 0){
                System.out.printf("%d, %d -> both are odd%n", nums[i], nums[i + 1]);
            }else {
                System.out.printf("%d, %d -> different%n", nums[i], nums[i + 1]);
            }
        }
    }
}
