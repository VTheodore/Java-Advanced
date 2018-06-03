package L05StringProcessingEXC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p07LettersChangeNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String[] words = in.readLine().split("\\s+");

        double totalSum = 0;
        Pattern pattern = Pattern.compile("\\d+");

        for (String word : words) {
            char firstChar = word.charAt(0);
            char secondChar = word.charAt(word.length() - 1);

            Matcher matcher = pattern.matcher(word);
            double num = 0;
            if (matcher.find()){
                num = Integer.parseInt(matcher.group(0));
            }

            int firstCharPos = Character.isUpperCase(firstChar) ? firstChar - 64 : firstChar - 96;

            if (Character.isUpperCase(firstChar)){
                num /= firstCharPos;
            }else{
                num *= firstCharPos;
            }

            int secondCharPos = Character.isUpperCase(secondChar) ? secondChar - 64 : secondChar - 96;

            if (Character.isUpperCase(secondChar)){
                num -= secondCharPos;
            }else {
                num += secondCharPos;
            }

            totalSum += num;
        }

        System.out.printf("%.2f", totalSum);
    }
}
