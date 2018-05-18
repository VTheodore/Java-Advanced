package L02LinearDataStructures;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class p08HotPotato {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] names = in.nextLine().split("\\s+");
        int n = in.nextInt();

        ArrayDeque<String> queue = new ArrayDeque<>();
        Collections.addAll(queue, names);

        while (queue.size() > 1){
            for (int i = 1; i < n; i++) {
                queue.offer(queue.poll());
            }

            System.out.printf("Removed %s%n", queue.poll());
        }

        System.out.printf("Last is %s%n", queue.poll());
    }
}
