package L05StringProcessing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p03ParseTags {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        var text = new StringBuilder().append(in.readLine());
        int startIndex = text.indexOf("<upcase>");

        while (startIndex != -1){
            int endIndex = text.indexOf("</upcase>");
            String word = text.substring(startIndex + 8, endIndex).toUpperCase();

            text.delete(startIndex, endIndex + 9);
            text.insert(startIndex, word);

            startIndex = text.indexOf("<upcase>");
        }

        System.out.println(text);
    }
}
