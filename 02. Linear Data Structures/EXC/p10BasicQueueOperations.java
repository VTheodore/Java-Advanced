package L02LinearDataStructuresEXC;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class p10BasicQueueOperations {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] input = in.nextLine().split("\\s+");

        int elToEnque = Integer.parseInt(input[0]);
        int elToDeque = Integer.parseInt(input[1]);
        int checkIfPresent = Integer.parseInt(input[2]);

        ArrayDeque<Integer> queue = new ArrayDeque<>();

        int[] elements = Arrays.stream(in.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < elToEnque; i++) {
            queue.offer(elements[i]);
        }

        for (int i = 0; i < elToDeque; i++) {
            queue.poll();
        }

        if (queue.isEmpty()){
            System.out.println(0);
        }else if (queue.contains(checkIfPresent)){
            System.out.println(true);
        }else{
            System.out.println(Collections.min(queue));
        }

    }
}
