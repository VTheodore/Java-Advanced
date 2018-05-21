package L02LinearDataStructuresEXC;

import java.util.Scanner;

public class p05MatrixShuffle {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String dimensions = in.nextLine();
        int rows = Integer.parseInt(dimensions.split("\\s+")[0]);
        int cols = Integer.parseInt(dimensions.split("\\s+")[1]);
        String[][] matrix = new String[rows][cols];

        for (int i = 0; i < rows; i++) {
            String[] elements = in.nextLine().split("\\s+");

            matrix[i] = elements;
        }

        while (true){
            String[] tokens = in.nextLine().split("\\s+");
            if (tokens[0].equals("END"))break;

            if (!tokens[0].equals("swap") || tokens.length != 5){
                System.out.println("Invalid input!");
                continue;
            }

            try {
                int row1 = Integer.parseInt(tokens[1]);
                int col1 = Integer.parseInt(tokens[2]);
                int row2 = Integer.parseInt(tokens[3]);
                int col2 = Integer.parseInt(tokens[4]);

                String tempVal = matrix[row1][col1];
                matrix[row1][col1] = matrix[row2][col2];
                matrix[row2][col2] = tempVal;

            }catch (Exception ex){
                System.out.println("Invalid input!");
                continue;
            }

            for (String[] row : matrix) {
                for (String s : row) {
                    System.out.printf("%s ", s);
                }
                System.out.println();
            }

         }
    }
}
