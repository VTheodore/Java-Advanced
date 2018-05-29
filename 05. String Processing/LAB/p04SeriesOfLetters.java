package L05StringProcessing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p04SeriesOfLetters {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        var text = new StringBuilder().append(in.readLine());
        int i = 0;
        int state = 0;

        while (i < text.length() - 1){
            switch (state){
                case 0:
                    if (text.charAt(i) == text.charAt(i + 1)) {
                        text.deleteCharAt(i);
                    }else {
                        state = 1;
                    }
                    break;
                case 1:
                    i++;
                    state = 0;
                    break;
            }
        }
        System.out.println(text);
    }
}
