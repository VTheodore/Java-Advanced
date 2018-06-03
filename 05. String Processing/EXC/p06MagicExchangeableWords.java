package L05StringProcessingEXC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class p06MagicExchangeableWords {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String[] words = in.readLine().split(" ");

        var firstWord = new HashSet<Character>();
        var secondWord = new HashSet<Character>();

        firstWord = fillSets(firstWord, words[0]);
        secondWord = fillSets(secondWord, words[1]);

        boolean areExchangable = firstWord.size() == secondWord.size();
        System.out.println(areExchangable);

    }

    private static HashSet<Character> fillSets(HashSet<Character> set, String word) {
        for (int i = 0; i < word.length(); i++) {
            set.add(word.charAt(i));
        }

        return set;
    }
}
