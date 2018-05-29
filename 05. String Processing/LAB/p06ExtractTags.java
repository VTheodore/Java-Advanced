package L05StringProcessing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p06ExtractTags {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        Pattern pattern = Pattern.compile("<.+?>");

        while (true){
            String line = in.readLine();
            if ("END".equals(line))break;

            Matcher matcher = pattern.matcher(line);

            while (matcher.find()){
                System.out.println(matcher.group(0));
            }

        }
    }
}
