package L03JavaAdvancedSetsAndMapsEXC;

import java.util.*;

public class p02SetsOfElements {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int[] input = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Set<Integer> firstSet = new LinkedHashSet<>();
        Set<Integer> secondSet = new LinkedHashSet<>();

        for (int i = 0; i < input[0]; i++) {
            int num = Integer.parseInt(in.nextLine());

            firstSet.add(num);
        }

        for (int i = 0; i < input[1]; i++) {
            int num = Integer.parseInt(in.nextLine());

            secondSet.add(num);
        }

        for (Integer num : firstSet) {
            if (secondSet.contains(num)){
                System.out.printf("%d ", num);
            }
        }
    }
}
