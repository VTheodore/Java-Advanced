package L02LinearDataStructuresEXC;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class p08BasicStackOperations {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] tokens = in.nextLine().split("\\s+");

        int elToPush = Integer.parseInt(tokens[0]);
        int elToPop = Integer.parseInt(tokens[1]);
        int checkIfPresent = Integer.parseInt(tokens[2]);

        int[] nums = Arrays.stream(in.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();


        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < elToPush; i++) {
            stack.push(nums[i]);
        }

        for (int i = 0; i < elToPop; i++) {
            stack.pop();
        }

        if (stack.isEmpty()){
            System.out.println(0);
        }else if (stack.contains(checkIfPresent)){
            System.out.println(true);
        }else {
            int smallest = Integer.MAX_VALUE;

            for (int i = 0; i < stack.size(); i++) {
                int currSmallest = stack.pop();

                if (currSmallest < smallest){
                    smallest = currSmallest;
                }
            }

            System.out.println(smallest);
        }

    }
}
