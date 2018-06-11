package ExamPrep_I;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Consumer;

public class p01Shockwave {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String[] input = in.readLine().split("\\s+");
        int rows = Integer.parseInt(input[0]);
        int cols = Integer.parseInt(input[1]);

        int[][] matrix = new int[rows][cols];

        while (true){
            String[] inp = in.readLine().split(" ");
            if ("Here".equals(inp[0]))break;

            int x1 = Integer.parseInt(inp[0]);
            int y1 = Integer.parseInt(inp[1]);
            int x2 = Integer.parseInt(inp[2]);
            int y2 = Integer.parseInt(inp[3]);

            addShockwaves(matrix, x1, y1, x2, y2);
        }

        for (int[] row : matrix) {
            for (int i : row) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    private static void addShockwaves(int[][] matrix, int x1, int y1, int x2, int y2) {
        for (int row = x1; row <= x2; row++) {
            for (int col = y1; col <= y2; col++) {
                matrix[row][col] += 1;
            }
        }
    }
}
