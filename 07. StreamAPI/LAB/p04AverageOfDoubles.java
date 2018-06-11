package L07StreamAPI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.OptionalDouble;

public class p04AverageOfDoubles {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        OptionalDouble average = Arrays.stream(in.readLine().split("\\s+"))
                .filter(n -> !n.equals(""))
                .mapToDouble(Double::parseDouble)
                .average();

        if (average.isPresent()){
            System.out.printf("%.2f", average.getAsDouble());
        }else {
            System.out.println("No match");
        }
    }
}
