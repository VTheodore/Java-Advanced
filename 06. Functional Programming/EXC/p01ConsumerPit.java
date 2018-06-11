package L06FunctionalProgrammingEXC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Consumer;

public class p01ConsumerPit {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String input = in.readLine();

        Consumer<String> printNames = inp -> {
            String[] names = inp.split("\\s+");

            for (String name : names) {
                System.out.println(name);
            }
        };

        printNames.accept(input);
    }
}
