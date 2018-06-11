import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p03Genome {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        Pattern pattern = Pattern.compile("(?<gene>^[a-z!@#$?]+)=(?<length>\\d+)--(?<count>\\d+)<<(?<name>[a-z]+)$");

        Map<String, Integer> organisms = new LinkedHashMap<>();
        while (true){
            String line = in.readLine();
            if ("Stop!".equals(line))break;

            Matcher matcher = pattern.matcher(line);

            if (matcher.find()) {
                String[] gene = matcher.group("gene").split("[!@#$?]+");
                StringBuilder geneName = new StringBuilder();

                for (String s : gene) {
                    if (!s.equals(""))geneName.append(s);
                }

                int length = Integer.parseInt(matcher.group("length"));
                int count = Integer.parseInt(matcher.group("count"));
                String name = matcher.group("name");

                if (geneName.length() != length) continue;

                if (!organisms.containsKey(name)){
                    organisms.put(name, count);
                }else {
                    organisms.put(name, organisms.get(name) + count);
                }
            }
        }

        organisms.entrySet().stream()
                .sorted((o1, o2) -> o2.getValue().compareTo(o1.getValue()))
                .forEach(org -> {
                    System.out.printf("%s has genome size of %d%n", org.getKey(), org.getValue());
                });
    }
}
