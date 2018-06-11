package L07StreamAPI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Optional;

public class p05MinEvenNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        Optional<Double> minEvenNum = Arrays.stream(in.readLine().split("\\s+"))
                .filter(n -> !n.equals(""))
                .map(Double::parseDouble)
                .filter(n -> n % 2 == 0).min(Double::compare);

        if (minEvenNum.isPresent()){
            System.out.printf("%.2f", minEvenNum.get());
        }else{
            System.out.println("No match");
        }
    }
}
