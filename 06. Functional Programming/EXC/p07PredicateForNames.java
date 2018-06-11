package L06FunctionalProgrammingEXC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.BiPredicate;

public class p07PredicateForNames {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int length = Integer.parseInt(in.readLine());
        String[] names = in.readLine().split("\\s+");

        BiPredicate<String, Integer> isValidName = (name, len) -> name.length() <= len;

        for (String name : names) {
            if (isValidName.test(name, length)) System.out.println(name);
        }
    }
}
