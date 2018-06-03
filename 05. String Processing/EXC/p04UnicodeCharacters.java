package L05StringProcessingEXC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p04UnicodeCharacters {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        char[] input = in.readLine().toCharArray();
        StringBuilder res = new StringBuilder();

        for (int i = 0; i < input.length; i++) {
           res.append(String.format("\\u%04x", Character.codePointAt(input, i)));
        }

        System.out.println(res.toString());
    }
}
