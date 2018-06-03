package L05StringProcessingEXC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p03TextFilter {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String[] bannedWords = in.readLine().split(", ");
        StringBuilder text = new StringBuilder().append(in.readLine());

        for (String bannedWord : bannedWords) {
            int bannedWordLen = bannedWord.length();
            String replacementWord = getReplacement(bannedWordLen);

            int startingIndex = text.indexOf(bannedWord);

            while (startingIndex != -1){
                text.replace(startingIndex, startingIndex + bannedWordLen, replacementWord);
                startingIndex = text.indexOf(bannedWord);
            }
        }

        System.out.println(text);
    }

    private static String getReplacement(int bannedWordLen) {
        StringBuilder replacementWord = new StringBuilder();
        for (int i = 0; i < bannedWordLen; i++) {
            replacementWord.append("*");
        }

        return replacementWord.toString();
    }
}
