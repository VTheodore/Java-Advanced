import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p02Snake {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());
        String[] commands = in.readLine().split(", ");

        String[][] matrix = new String[n][n];

        int[] snakeStart = new int[2];
        int foodCount = 0;
        for (int row = 0; row < n; row++) {
            String[] line = in.readLine().split("\\s+");

            String[] fixedLine = new String[n];
            int counter = 0;

            for (int i = 0; i < line.length; i++) {
                if (line[i].equals("")){
                    fixedLine[counter] = line[i];

                    counter++;
                }
            }

            for (int col = 0; col < n; col++) {
                matrix[row][col] = line[col];
                if (line[col].equals("s")) {
                    snakeStart[0] = row;
                    snakeStart[1] = col;
                }

                if (line[col].equals("f"))foodCount++;
            }
        }


        int snakeLength = 1;

        for (String command : commands) {
            if (command.equals(""))continue;

            int xDesired = 0;
            int yDesired = 0;
            switch (command) {
                case "left":
                    xDesired = snakeStart[0];
                    yDesired = snakeStart[1] - 1;

                    matrix[snakeStart[0]][snakeStart[1]] = "*";
                    if (yDesired == 0) {
                        yDesired = matrix.length - 1;
                    }

                    if (matrix[xDesired][yDesired].equals("f")) {
                        snakeLength++;
                        foodCount--;
                        matrix[xDesired][yDesired] = "s";
                    } else if (matrix[xDesired][yDesired].equals("e")) {
                        System.out.println("You lose! Killed by an enemy!");
                        return;
                    }

                    break;
                case "right":
                    xDesired = snakeStart[0];
                    yDesired = snakeStart[1] + 1;

                    matrix[snakeStart[0]][snakeStart[1]] = "*";
                    if (yDesired == matrix.length) {
                        yDesired = 0;
                    }

                    if (matrix[xDesired][yDesired].equals("f")) {
                        snakeLength++;
                        foodCount--;
                        matrix[xDesired][yDesired] = "s";
                    } else if (matrix[xDesired][yDesired].equals("e")) {
                        System.out.println("You lose! Killed by an enemy!");
                        return;
                    }
                    break;
                case "up":
                    xDesired = snakeStart[0] - 1;
                    yDesired = snakeStart[1];

                    matrix[snakeStart[0]][snakeStart[1]] = "*";
                    if (xDesired == 0){
                        xDesired = matrix.length - 1;
                    }

                    if (matrix[xDesired][yDesired].equals("f")) {
                        snakeLength++;
                        foodCount--;
                        matrix[xDesired][yDesired] = "s";
                    } else if (matrix[xDesired][yDesired].equals("e")) {
                        System.out.println("You lose! Killed by an enemy!");
                        return;
                    }

                    break;
                case "down":
                    xDesired = snakeStart[0] + 1;
                    yDesired = snakeStart[1];

                    matrix[snakeStart[0]][snakeStart[1]] = "*";
                    if (xDesired == matrix.length){
                        xDesired = 0;
                    }

                    if (matrix[xDesired][yDesired].equals("f")) {
                        snakeLength++;
                        foodCount--;
                        matrix[xDesired][yDesired] = "s";
                    } else if (matrix[xDesired][yDesired].equals("e")) {
                        System.out.println("You lose! Killed by an enemy!");
                        return;
                    }
                    break;
            }

            if (foodCount == 0){
                System.out.printf("You win! Final snake length is %d", snakeLength);
                return;
            }

            snakeStart[0] = xDesired;
            snakeStart[1] = yDesired;
        }

        System.out.printf("You lose! There is still %d food to be eaten.", foodCount);
    }

}
