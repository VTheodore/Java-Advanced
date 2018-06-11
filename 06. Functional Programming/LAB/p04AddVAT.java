package L06FunctionalProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Function;

public class p04AddVAT {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        double[] prices = Arrays
                .stream(in.readLine().split(", "))
                .mapToDouble(Double::parseDouble)
                .toArray();

        Function<Double, Double> addVAT = num -> num * 1.2;

        System.out.println("Prices with VAT:");
        for (double price : prices) {
            System.out.printf("%1$.2f%n", addVAT.apply(price));
        }
    }
}
