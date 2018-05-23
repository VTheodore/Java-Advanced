package L03JavaAdvancedSetsAndMapsEXC;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class p11LogsAggregator {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = Integer.parseInt(in.nextLine());
        Map<String, TreeMap<String, Integer>> usersAndIps = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String[] tokens = in.nextLine().split("\\s+");
            String ip = tokens[0];
            String user = tokens[1];
            int duration = Integer.parseInt(tokens[2]);

            if (!usersAndIps.containsKey(user)) {
                TreeMap<String, Integer> ipAndDuration = new TreeMap<>();
                ipAndDuration.put(ip, duration);

                usersAndIps.put(user, ipAndDuration);
            } else {
                if (!usersAndIps.get(user).containsKey(ip)) {
                    TreeMap<String, Integer> ipAndDuration = usersAndIps.get(user);
                    ipAndDuration.put(ip, duration);

                    usersAndIps.put(user, ipAndDuration);
                } else {
                    TreeMap<String, Integer> ipAndDuration = usersAndIps.get(user);
                    ipAndDuration.put(ip, ipAndDuration.get(ip) + duration);

                    usersAndIps.put(user, ipAndDuration);
                }
            }
        }


        for (String user : usersAndIps.keySet()) {
            int totalDuration = 0;
            StringBuilder res = new StringBuilder();
            res.append("[");

            for (String ip : usersAndIps.get(user).keySet()) {
                res.append(ip + ", ");
                totalDuration += usersAndIps.get(user).get(ip);
            }

            res.delete(res.lastIndexOf(", "), res.length());
            res.append("]");

            System.out.printf("%s: %d %s%n",user, totalDuration, res);
        }
    }
}
