package L05StringProcessing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p01StudentsResult {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String[] input = in.readLine().split("[-, ]+");

        double average = 0D;

        for (int i = 1; i < input.length; i++) {
            average += Double.parseDouble(input[i]);
        }

        average /= 3;

        System.out.printf("%-10s|%7s|%7s|%7s|%7s|%n", "Name", "JAdv", "JavaOOP", "AdvOOP", "Average");
        System.out.printf("%-10s|%7.2f|%7.2f|%7.2f|%7.4f|%n", input[0], Double.valueOf(input[1]), Double.valueOf(input[2]), Double.valueOf(input[3]), average);

    }
}
