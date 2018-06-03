package L05StringProcessingEXC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p14SumOfAllValues {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        Pattern pattern = Pattern.compile("(?<=^)(?<startKey>[A-Za-z_]+)(?=\\d).*(?<=\\d)(?<endKey>[A-Za-z_]+)(?=$)");

        String keysString = in.readLine();
        String textString = in.readLine();

        Matcher matcher = pattern.matcher(keysString);

        String startKey = "";
        String endKey = "";
        if (matcher.find()){
            startKey = matcher.group("startKey");
            endKey = matcher.group("endKey");
        }else {
            System.out.println("<p>A key is missing</p>");
            return;
        }

        String textPattern = startKey + "(\\d*(?:\\.\\d+)?)" + endKey;
        Pattern pattern1 = Pattern.compile(textPattern);

        Matcher matcher1 = pattern1.matcher(textString);

        double sum = 0;

        while (matcher1.find()){
            String chunk = matcher1.group();
            double num = Double.parseDouble(chunk.replace(startKey, "").replace(endKey, ""));

            sum += num;
        }

        DecimalFormat df = new DecimalFormat("#.##");
        if (sum != 0){
            System.out.printf("<p>The total value is: <em>%s</em></p>\n", df.format(sum));
        }else {
            System.out.println("<p>The total value is: <em>nothing</em></p>\n");
        }

    }
}
