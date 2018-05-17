package L01IntroToJavaEXC;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class p08GetFirstOddOrEvenElements {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int[] nums = Arrays
                .stream(in.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        String[] commands = in.nextLine().split("\\s+");

        int numberOfElements = Integer.parseInt(commands[1]);
        String type = commands[2];
        List<Integer> desiredNums = new ArrayList();

        if ("even".equals(type)){
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] % 2 == 0){
                    desiredNums.add(nums[i]);
                }
            }

            printElements(numberOfElements, desiredNums);

        }else if ("odd".equals(type)){
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] % 2 != 0){
                    desiredNums.add(nums[i]);
                }
            }

            printElements(numberOfElements, desiredNums);
        }
    }

    private static void printElements(int numberOfElements, List<Integer> desiredNums) {
        if (numberOfElements >= desiredNums.size()){
            for (int num : desiredNums) {
                System.out.printf("%d ", num);
            }
        }else {
            for (int i = 0; i < numberOfElements; i++) {
                System.out.printf("%d ", desiredNums.get(i));
            }
        }
    }
}
