package L07StreamAPI_EXC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class p01StudentsByGroup {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        List<String> names = new ArrayList<>();

        while (true){
            String[] line = in.readLine().split("\\s+");
            if ("END".equals(line[0]))break;

            int group = Integer.parseInt(line[2]);

            if (group == 2){
                String name = String.format("%s %s", line[0], line[1]);

                names.add(name);
            }
        }

        names.stream()
                .sorted((x1, x2) -> {
                    String firstName1 = x1.split(" ")[0];
                    String firstName2 = x2.split(" ")[0];

                    return firstName1.compareTo(firstName2);

                })
                .forEach(System.out::println);
    }
}
