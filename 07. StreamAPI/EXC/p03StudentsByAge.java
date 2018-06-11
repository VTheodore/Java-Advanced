package L07StreamAPI_EXC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;

public class p03StudentsByAge {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        var names = new LinkedHashMap<String, Integer>();

        while (true){
            String[] line = in.readLine().split("\\s+");
            if ("END".equals(line[0]))break;

            String name = String.format("%s %s", line[0], line[1]);
            Integer age = Integer.valueOf(line[2]);

            names.putIfAbsent(name, age);
        }

        names.entrySet().stream()
                .filter(n -> n.getValue() >= 18 && n.getValue() <= 24)
                .forEach(el -> System.out.printf("%s %d%n", el.getKey(), el.getValue()));
    }
}
