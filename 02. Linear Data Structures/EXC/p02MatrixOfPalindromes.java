package L02LinearDataStructuresEXC;

import java.util.Scanner;

public class p02MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] input = in.nextLine().split("\\s+");
        int rows = Integer.parseInt(input[0]);
        int cols = Integer.parseInt(input[1]);
        String[][] matrix = new String[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                String palindrome = getPalindrome(row, col);
                matrix[row][col] = palindrome;
            }
        }

        for (String[] row : matrix) {
            for (String col : row) {
                System.out.print(col + " ");
            }
            System.out.println();
        }

    }

    static String getPalindrome(int row, int col) {
        char mainChar = (char)(97 + row);
        char middleChar = (char)(97 + col + row);

        return "" + mainChar + middleChar + mainChar;
    }
}
