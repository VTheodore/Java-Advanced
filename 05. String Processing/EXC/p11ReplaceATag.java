package L05StringProcessingEXC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p11ReplaceATag {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder res = new StringBuilder();
        while (true){
            String line = in.readLine();
            if ("END".equals(line))break;

            res.append(line);
            res.append("\n");
        }

        String result = res.toString();

        result = result.replaceAll("<a", "[URL");
        result = result.replaceAll("(href=.*?)>", "$1]");
        result = result.replaceAll("</a>", "[/URL]");
        System.out.println(result);
    }
}
