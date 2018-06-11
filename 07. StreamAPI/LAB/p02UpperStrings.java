package L07StreamAPI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class p02UpperStrings {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        Arrays.stream(in.readLine().split("\\s+"))
                .map(String::toUpperCase)
                .forEach(n -> System.out.print(n + " "));
    }
}
