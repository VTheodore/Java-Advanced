package L02LinearDataStructuresEXC;

import java.util.Arrays;
import java.util.Scanner;

public class p03DiagonalDifference {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = Integer.parseInt(in.nextLine());
        int[][] matrix = new int[n][n];

        for (int row = 0; row < n; row++) {
            int[] input = Arrays
                    .stream(in.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            matrix[row] = input;
        }

        int primaryDiagonal = 0;
        int secondaryDiagonal = 0;

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (row == col){
                    primaryDiagonal += matrix[row][col];
                }

                if (col == n - 1 - row){
                    secondaryDiagonal += matrix[row][col];
                }
            }
        }

        System.out.println(Math.abs(primaryDiagonal - secondaryDiagonal));
    }
}
