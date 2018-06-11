package ExamPrep_I;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p03Ascent {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        Pattern pattern = Pattern.compile("(?<type>[,_])(?<msg>[a-zA-Z]+)(?<power>[0-9])");
        var decodedMessages = new LinkedHashMap<String, String>();

        while (true){
            StringBuilder line = new StringBuilder().append(in.readLine());
            if ("Ascend".equals(line))break;

            Matcher matcher = pattern.matcher(line);
            while (matcher.find()){
            }
            for (Map.Entry<String, String> decodedMsg : decodedMessages.entrySet()) {

            }
        }
    }
}
