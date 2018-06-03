package L05StringProcessingEXC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;

public class p05Palindromes {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String[] words = in.readLine().split("[ ,.?!]+");
        var res = new TreeSet<String>();

        for (String word : words) {
            char[] chars = word.toCharArray();

            boolean isPalindrome = getTypeOfWord(chars);

            if (isPalindrome){
                res.add(word);
            }
        }

        System.out.println(res);

    }

    private static boolean getTypeOfWord(char[] chars) {
        boolean isPalindrome = true;

        for (int i = 0; i < chars.length / 2; i++) {
            if (chars[i] != chars[chars.length - 1 - i]){
                isPalindrome = false;
                break;
            }
        }

        return isPalindrome;
    }
}
