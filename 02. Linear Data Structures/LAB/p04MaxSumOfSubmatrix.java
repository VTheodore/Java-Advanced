package L02LinearDataStructures;

import java.util.Arrays;
import java.util.Scanner;

public class p04MaxSumOfSubmatrix {
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

        int biggestSum = Integer.MIN_VALUE;
        int indexRow = 0;
        int indexCol = 0;

        for (int row = 0; row < rows - 1; row++) {
            int currentBiggest = 0;

            for (int col = 0; col < cols - 1; col++) {
                int a = matrix[row][col] + matrix[row][col + 1];
                int b = matrix[row + 1][col] + matrix[row + 1][col + 1];

                currentBiggest = a + b;

                if (currentBiggest > biggestSum) {
                    biggestSum = currentBiggest;
                    indexRow = row;
                    indexCol = col;
                }
            }
        }

        System.out.printf("%d %d%n", matrix[indexRow][indexCol], matrix[indexRow][indexCol + 1]);
        System.out.printf("%d %d%n", matrix[indexRow + 1][indexCol], matrix[indexRow + 1][indexCol + 1]);
        System.out.println(biggestSum);


    }
}
