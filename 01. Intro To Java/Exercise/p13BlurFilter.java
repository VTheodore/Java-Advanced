package L01IntroToJavaEXC;

import java.util.Arrays;
import java.util.Scanner;

public class P13BlurFilter {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int blurAmount = Integer.parseInt(in.nextLine());

        int[] matrixSize = Arrays
                .stream(in.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        long[][] matrix = new long[matrixSize[0]][matrixSize[1]];

        for (int i = 0; i < matrixSize[0]; i++) {
            long[] matrixValue = Arrays
                    .stream(in.nextLine().split("\\s+"))
                    .mapToLong(Long::parseLong).toArray();

            matrix[i] = matrixValue;
        }

        int[] targetCell = Arrays
                .stream(in.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        try {
            matrix[targetCell[0] - 1][targetCell[1] - 1] += blurAmount;
        }catch (IndexOutOfBoundsException ex){ }
        try {
            matrix[targetCell[0] - 1][targetCell[1]] += blurAmount;
        }catch (IndexOutOfBoundsException ex){ }
        try {
            matrix[targetCell[0] - 1][targetCell[1] + 1] += blurAmount;
        }catch (IndexOutOfBoundsException ex){ }

        try {
            matrix[targetCell[0]][targetCell[1] - 1] += blurAmount;
        }catch (IndexOutOfBoundsException ex){ }
        try {
            matrix[targetCell[0]][targetCell[1]] += blurAmount;
        }catch (IndexOutOfBoundsException ex){ }
        try {
            matrix[targetCell[0]][targetCell[1] + 1] += blurAmount;
        }catch (IndexOutOfBoundsException ex){ }

        try {
            matrix[targetCell[0] + 1][targetCell[1] - 1] += blurAmount;
        }catch (IndexOutOfBoundsException ex){ }
        try {
            matrix[targetCell[0] + 1][targetCell[1]] += blurAmount;
        }catch (IndexOutOfBoundsException ex){ }
        try {
            matrix[targetCell[0] + 1][targetCell[1] + 1] += blurAmount;
        }catch (IndexOutOfBoundsException ex){ }

        for (int i = 0; i < matrixSize[0]; i++) {
            String result = Arrays.toString(matrix[i]).replace("[", "").replace("]", "").replace(",", "");
            System.out.println(result);
        }
    }
}
