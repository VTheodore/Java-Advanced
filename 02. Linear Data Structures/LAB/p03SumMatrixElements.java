package L02LinearDataStructures;

import java.util.Arrays;
import java.util.Scanner;

public class p03SumMatrixElements {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] tokens = in.nextLine().split(", ");
        int rows = Integer.parseInt(tokens[0]);
        int cols = Integer.parseInt(tokens[1]);

        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            int[] elements = Arrays
                    .stream(in.nextLine().split(", "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            matrix[i] = elements;
        }

        int sum = 0;

        for (int[] row : matrix) {
            for (int col : row) {
                sum += col;
            }
        }

        System.out.println(rows);
        System.out.println(cols);
        System.out.println(sum);

    }
}
