import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class p04Ranking {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        Map<String, String> contests = new LinkedHashMap<>();

        while (true){
            String[] line = in.readLine().split(":");
            if ("end of contests".equals(line[0]))break;

            contests.putIfAbsent(line[0], line[1]);
        }

        Map<String, Map<String, Integer>> students = new LinkedHashMap<>();

        while (true){
            String[] line = in.readLine().split("=>");
            if ("end of submissions".equals(line[0]))break;

            String contest = line[0];
            String password = line[1];
            String name = line[2];
            int points = Integer.parseInt(line[3]);

            if (!contests.containsKey(contest))continue;
            if (!contests.get(contest).equals(password))continue;

            if (!students.containsKey(name)){
                students.put(name, new LinkedHashMap<>());
            }

            if (!students.get(name).containsKey(contest)){
                students.get(name).put(contest, 0);
            }

            if (students.get(name).get(contest) < points){
                students.get(name).put(contest, points);
            }
        }

        int totalPoints = 0;
        String winner = "";

        for (String s : students.keySet()) {
            int currPoints = 0;
            for (Integer points : students.get(s).values()) {
                currPoints += points;
            }

            //Problem?
            if (currPoints >= totalPoints){
                totalPoints = currPoints;
                winner = s;
            }
        }

        System.out.printf("Best candidate is %s with total %s points.%n", winner, totalPoints);
        System.out.println("Ranking: ");

        students.entrySet().stream()
                .sorted(Comparator.comparing(Map.Entry::getKey))
                .forEach(n -> {
                    System.out.println(n.getKey());

                    n.getValue().entrySet().stream()
                            .sorted((c1, c2) -> c2.getValue().compareTo(c1.getValue()))
                            .forEach(contest -> {
                                System.out.printf("#  %s -> %d%n", contest.getKey(), contest.getValue());
                            });
                });
    }
}
