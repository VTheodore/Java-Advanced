package L03JavaAdvancedSetsAndMapsEXC;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p09UserLogs {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Pattern pattern = Pattern.compile("=(?<ip>.+) message=.+user=(?<user>.+)");
        Map<String, LinkedHashMap<String, Integer>> usernameAndIp = new TreeMap<>();

        while(true){
            String input = in.nextLine();
            if ("end".equals(input))break;

            Matcher m = pattern.matcher(input);
            String username = "";
            String ip = "";

            if (m.find()){
                username = m.group("user");
                ip = m.group("ip");
            }


            if (!usernameAndIp.containsKey(username)){
                usernameAndIp.put(username, new LinkedHashMap<>());
                usernameAndIp.get(username).put(ip, 1);
            }else {
                if (!usernameAndIp.get(username).containsKey(ip)){
                    usernameAndIp.get(username).put(ip, 1);
                }else{
                    usernameAndIp.get(username).put(ip, usernameAndIp.get(username).get(ip) + 1);
                }
            }
        }

        for (String user : usernameAndIp.keySet()) {
            System.out.println(user + ": ");
            StringBuilder res = new StringBuilder();

            for (String ip : usernameAndIp.get(user).keySet()) {
                res.append(String.format("%s => %d, ", ip, usernameAndIp.get(user).get(ip)));
            }

            res.delete(res.lastIndexOf(", "), res.length());
            res.append(".");
            System.out.println(res);
        }
    }
}
