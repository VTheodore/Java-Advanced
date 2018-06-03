package L05StringProcessingEXC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p08MelrahShake {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder input = new StringBuilder().append(in.readLine());
        StringBuilder pattern = new StringBuilder().append(in.readLine());

        while (true){
            int firstMatchIndex = input.indexOf(pattern.toString());
            int secondMatchIndex = input.lastIndexOf(pattern.toString());
            if (firstMatchIndex == -1 || secondMatchIndex == -1 || pattern.length() == 0)break;

            input.delete(firstMatchIndex, firstMatchIndex + pattern.length());
            secondMatchIndex = input.lastIndexOf(pattern.toString());
            input.delete(secondMatchIndex, secondMatchIndex + pattern.length());

            if (pattern.length() > 0){
                pattern.deleteCharAt(pattern.length() / 2);
            }

            System.out.println("Shaked it.");

        }

        System.out.println("No shake.");
        System.out.println(input.toString());
    }
}