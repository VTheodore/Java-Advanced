package L06FunctionalProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.function.Predicate;

public class p03CountUppercaseWords {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String[] words = in.readLine().split(" ");

        Predicate<String> isUppercase = word -> word.charAt(0) == word.toUpperCase().charAt(0);

        var res = new LinkedList<String>();
        for (String word : words) {
            if (isUppercase.test(word)){
                res.add(word);
            }
        }

        System.out.println(res.size());
        System.out.println(String.join("\n", res));
    }
}
