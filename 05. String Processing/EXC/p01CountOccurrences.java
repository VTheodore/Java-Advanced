package L05StringProcessingEXC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class p01CountOccurrences {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String input = in.readLine().toLowerCase();
        String toSearch = in.readLine().toLowerCase();

        int startIndex = input.indexOf(toSearch);
        int counter = 0;

        while (startIndex != -1){
            counter++;
            startIndex = input.indexOf(toSearch, startIndex + 1);
        }

        System.out.println(counter);
    }
}
