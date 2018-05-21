package L02LinearDataStructuresEXC;

import java.util.*;

public class p06StringMatrixRotation {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int rotate = Integer.parseInt(in.nextLine().split("[()]")[1]);
        rotate %= 360;

        List<String> words = new ArrayList<>();
        while (true) {
            String input = in.nextLine();
            if (input.equals("END")) break;

            words.add(input);
        }

        int biggestWordLength = getLengthOfBiggestWord(words);

        char[][] matrix = new char[words.size()][biggestWordLength];

        for (int row = 0; row < matrix.length; row++) {
            String paddedWord = padWord(words.get(row), biggestWordLength);

            matrix[row] = paddedWord.toCharArray();
        }

        matrix = getRotatedMatrix(matrix, rotate);

        for (char[] row : matrix) {
            for (char c : row) {
                System.out.printf("%c", c);
            }
            System.out.println();
        }
    }

    static char[][] getRotatedMatrix(char[][] matrix, int rotate) {
        if (rotate == 0) {
            return matrix;
        } else if (rotate == 180) {
            for (int row = 0; row < matrix.length; row++) {
                reverseCharactersInMatrix(matrix[row]);
            }

            reverseMatrix(matrix);
        } else if (rotate == 270) {
            char[][] verticalMatrix = getVerticalMatrix(matrix);
            matrix = verticalMatrix;

            reverseMatrix(matrix);
        } else if (rotate == 90) {
            char[][] verticalMatrix = getVerticalMatrix(matrix);
            matrix = verticalMatrix;

            for (int row = 0; row < matrix.length; row++) {
                reverseCharactersInMatrix(matrix[row]);
            }
        }

        return matrix;
    }

    static void reverseCharactersInMatrix(char[] matrix) {
        for (int i = 0; i < matrix.length / 2; i++) {
            char temp = matrix[i];
            matrix[i] = matrix[matrix.length - i - 1];
            matrix[matrix.length - i - 1] = temp;
        }
    }

    static char[][] getVerticalMatrix(char[][] matrix) {
        char[][] verticalMatrix = new char[matrix[0].length][matrix.length];

        for (int row = 0; row < matrix[0].length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                verticalMatrix[row][col] = matrix[col][row];
            }
        }
        return verticalMatrix;
    }

    static void reverseMatrix(char[][] matrix) {
        for (int i = 0; i < matrix.length / 2; i++) {
            char[] temp = matrix[i];
            matrix[i] = matrix[matrix.length - i - 1];
            matrix[matrix.length - i - 1] = temp;
        }
    }

    static String padWord(String s, int biggestWordLength) {
        StringBuilder paddedWord = new StringBuilder(s);

        if (s.length() < biggestWordLength) {
            int diff = biggestWordLength - s.length();

            for (int i = 0; i < diff; i++) {
                paddedWord.append(" ");
            }
            return paddedWord.toString();
        }

        return paddedWord.toString();
    }

    static int getLengthOfBiggestWord(List<String> words) {
        int biggestLength = 0;
        for (String word : words) {
            int tempLength = word.length();

            if (tempLength > biggestLength) biggestLength = tempLength;
        }

        return biggestLength;
    }
}
