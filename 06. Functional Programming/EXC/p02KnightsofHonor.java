package L06FunctionalProgrammingEXC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Consumer;

public class p02KnightsofHonor {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String inp = in.readLine();

        Consumer<String> printKnights = input -> {
            String[] knights = input.split("\\s+");

            for (String knight : knights) {
                System.out.println("Sir " + knight);
            }
        };

        printKnights.accept(inp);
    }
}
