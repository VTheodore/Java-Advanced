package L01IntroToJavaEXC;

import java.util.Scanner;

public class p07CharacterMultiplier {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] words = in.nextLine().split("\\s+");
        char[] firstWord = words[0].toCharArray();
        char[] secondWord = words[1].toCharArray();

        int sum = 0;
        boolean haveEqualLength = true;

        for (int i = 0; i < Math.min(firstWord.length, secondWord.length); i++) {
            sum += (int)firstWord[i] * (int)secondWord[i];
        }

        if (firstWord.length > secondWord.length){
            for (int i = secondWord.length; i < firstWord.length; i++) {
                sum += (int)firstWord[i];
            }
        }else if (secondWord.length > firstWord.length){
            for (int i = firstWord.length; i < secondWord.length; i++) {
                sum += (int)secondWord[i];
            }
        }

        System.out.println(sum);
    }
}
