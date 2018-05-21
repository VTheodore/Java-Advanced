package L02LinearDataStructuresEXC;

import java.util.Scanner;

public class p01FillTheMatrix {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] tokens = in.nextLine().split(", ");
        int length = Integer.parseInt(tokens[0]);

        int[][] matrix = new int[length][length];

        if (tokens[1].equals("A")) {
            matrix = fillMatrixAType(matrix, length);
        } else {
            matrix = fillMatrixBType(matrix, length);
        }

        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.printf("%d ", anInt);
            }
            System.out.println();
        }
    }

    static int[][] fillMatrixBType(int[][] matrix, int length) {
        boolean goDown = true;
        int count = 1;

        for (int i = 0; i < length; i++) {
            if (goDown) {
                for (int j = 0; j < length; j++) {
                    matrix[j][i] = count;
                    count++;
                }
                goDown = false;

            } else {
                for (int j = length - 1; j >= 0; j--) {
                    matrix[j][i] = count;
                    count++;
                }
                goDown = true;
            }
        }

        return matrix;
    }

    static int[][] fillMatrixAType(int[][] matrix, int length) {
        for (int row = 0; row < length; row++) {
            for (int col = 0; col < length; col++) {
                matrix[row][col] = row + 1 + length * col;
            }
        }

        return matrix;
    }
}
