package L05StringProcessingEXC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p09MatchFullName {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        Pattern pattern = Pattern.compile("^[A-Z][a-z]+ [A-Z][a-z]+$");
        while (true){
            String line = in.readLine();
            if ("end".equals(line))break;

            Matcher matcher = pattern.matcher(line);
            if (matcher.find()){
                System.out.println(line);
            }
        }
    }
}
