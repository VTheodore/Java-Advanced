package ExamPrep_I;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p04FootballStats {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        Pattern pattern = Pattern.compile("(?<homeTeam>[A-Za-z]+) - (?<awayTeam>[A-Za-z]+) result (?<homeRes>[0-9]+):(?<awayRes>[0-9]+)");
        //home team vs away team - res
        var games = new LinkedHashMap<String, List<String>>();

        while (true){
            String input = in.readLine();
            if ("Season End".equals(input))break;

            Matcher matcher = pattern.matcher(input);
            if (!matcher.find())continue;

            String homeTeam = matcher.group("homeTeam");
            String awayTeam = matcher.group("awayTeam");
            String homeTeamRes = matcher.group("homeRes");
            String awayTeamRes = matcher.group("awayRes");

            if (!games.containsKey(homeTeam)){
                games.put(homeTeam, new ArrayList<>());
            }

            if (!games.containsKey(awayTeam)){
                games.put(awayTeam, new ArrayList<>());
            }

            //RealMadrid - Atletico -> 3:0
            String homeInfo = String.format(" - %s -> %s:%s", awayTeam, homeTeamRes, awayTeamRes);
            String awayInfo = String.format(" - %s -> %s:%s", homeTeam, awayTeamRes, homeTeamRes);

            games.get(homeTeam).add(homeInfo);
            games.get(awayTeam).add(awayInfo);
        }

        String[] printInfo = in.readLine().split(", ");

        for (String team : printInfo) {
            games.get(team)
                    .stream()
                    .sorted(Comparator.comparing(x -> x.split(" -> ")[0]))
                    .forEach(x -> System.out.println(team + x));
        }
    }
}
