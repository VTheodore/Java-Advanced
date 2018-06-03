package L05StringProcessingEXC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p15ValidUsernames {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String[] input = in.readLine().split("[ \\\\\\/()]+");
        Pattern pattern = Pattern.compile("^[a-zA-Z][a-zA-Z0-9_]{2,24}$");

        var usernames = new ArrayList<String>();
        for (String username : input) {
            Matcher matcher = pattern.matcher(username);

            if (matcher.find()){
                usernames.add(username);
            }
        }

        int biggestLength = 0;
        int startIndex = 0;

        for (int i = 1; i < usernames.size(); i++) {
            int currBiggestLength = usernames.get(i).length() + usernames.get(i - 1).length();

            if (currBiggestLength > biggestLength){
                biggestLength = currBiggestLength;
                startIndex = i;
            }
        }

        System.out.println(usernames.get(startIndex - 1));
        System.out.println(usernames.get(startIndex));
    }
}
