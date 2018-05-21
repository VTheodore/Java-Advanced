package L02LinearDataStructuresEXC;

import java.util.Arrays;
import java.util.Scanner;

public class p04MaximalSum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] inp = in.nextLine().split("\\s+");
        int n = Integer.parseInt(inp[0]);
        int m = Integer.parseInt(inp[1]);
        int[][] matrix = new int[n][m];

        for (int row = 0; row < n; row++) {
            int[] input = Arrays
                    .stream(in.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            matrix[row] = input;
        }

        int[] startingIndex = new int[2];
        int sum = Integer.MIN_VALUE;

        for (int row = 0; row < n - 2; row++) {
            int currSum =0;
            for (int col = 0; col < m - 2; col++) {
                int a = matrix[row][col] + matrix[row][col + 1] + matrix[row][col + 2];
                int b = matrix[row + 1][col] + matrix[row + 1][col + 1] + matrix[row + 1][col + 2];
                int c = matrix[row + 2][col] + matrix[row + 2][col + 1] + matrix[row + 2][col + 2];

                currSum = a + b + c;

                if (currSum > sum){
                    sum = currSum;
                    startingIndex[0] = row;
                    startingIndex[1] = col;
                }
            }
        }

        System.out.printf("Sum = %d%n", sum);

        for (int row = startingIndex[0]; row < startingIndex[0] + 3 ; row++) {
            for (int col = startingIndex[1]; col < startingIndex[1] + 3; col++) {
                System.out.printf("%d ", matrix[row][col]);
            }
            System.out.println();
        }


    }
}
