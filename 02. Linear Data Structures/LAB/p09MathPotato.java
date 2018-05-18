package L02LinearDataStructures;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class p09MathPotato {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] names = in.nextLine().split("\\s+");
        int n = in.nextInt();

        ArrayDeque<String> queue = new ArrayDeque<>();
        Collections.addAll(queue, names);

        int cycle = 1;
        while (queue.size() > 1){
            for (int i = 1; i < n; i++) {
                queue.offer(queue.poll());
            }



            if (isPrime(cycle)){
                System.out.println("Prime " + queue.peek());
            }
            else {
                System.out.println("Removed " + queue.poll());
            }

            cycle++;
        }

        System.out.printf("Last is %s%n", queue.poll());
    }

    private static boolean isPrime(int num) {
        if (num == 1) return false;

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0){
                return false;
            }
        }

        return true;
    }
}
