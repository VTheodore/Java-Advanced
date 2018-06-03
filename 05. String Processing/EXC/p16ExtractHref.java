package L05StringProcessingEXC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p16ExtractHref {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        while (true){
            String line = in.readLine();
            if ("END".equals(line))break;

            sb.append(line);
        }

        Pattern pattern = Pattern.compile("<a[^>]+?href\\s*=\\s*(\\\".*?\\\"|'.*?'|.*?)[\\s>]");
        Matcher matcherTags = pattern.matcher(sb);

        while (matcherTags.find()){
            String link = matcherTags.group(1);

            if (link.startsWith("\'") || link.startsWith("\"")){
                link = link.substring(1, link.length() - 1);
            }

            System.out.println(link);
        }
    }
}
