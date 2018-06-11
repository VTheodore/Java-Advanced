package ExamPrep_I;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class p02LittleAlchemy {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> input = Arrays.stream(in.readLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        ArrayDeque<Integer> queue = new ArrayDeque<>(input);

        int goldCount = 0;

        while (true) {
            String[] command = in.readLine().split("\\s+");
            if ("Revision".equals(command[0])) break;

            if ("Apply".equals(command[0])) {
                int end = Integer.parseInt(command[2]);
                for (int i = 0; i < end; i++) {
                    if (queue.isEmpty()) break;
                    int stone = queue.poll();

                    stone -= 1;

                    if (stone == 0) {
                        goldCount++;
                    } else {
                        queue.offer(stone);
                    }
                }
            } else {
                if (goldCount != 0) {
                    int stone = Integer.parseInt(command[2]);
                    queue.offer(stone);
                    goldCount--;
                }
            }
        }

        int queueSize = queue.size();
        for (int i = 0; i < queueSize; i++) {
            System.out.print(queue.poll() + " ");
        }
        System.out.println();

        System.out.println(goldCount);
    }
}
