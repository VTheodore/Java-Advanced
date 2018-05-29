package L05StringProcessing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p07ValidUsernames {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        Pattern pattern = Pattern.compile("^[\\w-]{3,16}$");
        var types = new LinkedList<String>();

        while(true){
            String line = in.readLine();
            if ("END".equals(line))break;

            Matcher matcher = pattern.matcher(line);

            String type = matcher.find() ? "valid" : "invalid";
            types.add(type);
        }

        if (types.contains("valid")){
            System.out.println(String.join("\n", types));
        }
    }
}
