package L05StringProcessingEXC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p13SentenceExtractor {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String keyword = in.readLine();
        String input = in.readLine();
        Pattern pattern = Pattern.compile("[A-Z].*?[!.?]");
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()){
            String line = matcher.group();
            String[] words = matcher.group().split("[\\W+]");

            for (String s : words) {
                if (s.equals(keyword)){
                    System.out.println(line);
                    break;
                }
            }

        }
    }
}
