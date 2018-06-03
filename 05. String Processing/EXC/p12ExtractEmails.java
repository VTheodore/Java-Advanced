package L05StringProcessingEXC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p12ExtractEmails {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String input = in.readLine();
        Pattern pattern = Pattern.compile("(^|(?<=\\s))([a-z0-9]+)([-._]?[a-z0-9]+)*@([a-z0-9]+)([.-][a-z0-9]+)*\\.[a-z0-9]+([-.][a-z0-9])*");
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()){
            System.out.println(matcher.group());
        }
    }
}
