package L05StringProcessing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p05VowelCount {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int counter = 0;
        String text = in.readLine();
        Pattern pattern = Pattern.compile("[aeiouyAEIOUY]");
        Matcher matcher = pattern.matcher(text);

        while (matcher.find())counter++;

        System.out.printf("Vowels: %d%n", counter);
    }
}
