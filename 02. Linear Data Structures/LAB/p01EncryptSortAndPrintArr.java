package L02LinearDataStructures;

import java.util.Arrays;
import java.util.Scanner;

public class p01EncryptSortAndPrintArr {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = Integer.parseInt(in.nextLine());
        String[] names = new String[n];

        for (int i = 0; i < n; i++) {
            String name = in.nextLine();
            names[i] = name;
        }
        
        int[] encryptedNames = new int[n];

        for (int i = 0; i < encryptedNames.length; i++) {
            char[] charsInName = names[i].toCharArray();

            for (char c : charsInName) {
                boolean isVowel = getTypeOfCharacter(c);

                if (isVowel){
                    encryptedNames[i] += c * names[i].length();
                }else {
                    encryptedNames[i] += c / names[i].length();
                }
            }
        }

        Arrays.sort(encryptedNames);

        for (int encryptedName : encryptedNames) {
            System.out.println(encryptedName);
        }
    }

    private static boolean getTypeOfCharacter(char c) {
        String ch = c + "";
        switch (ch.toLowerCase()){
            case "a":
            case "e":
            case "i":
            case "o":
            case "u":
                return true;
        }

        return false;
    }
}
