package L07StreamAPI_EXC;

import javafx.util.Pair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class p02StudentsByFirstAndLastName {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        List<Pair<String, String>> names = new ArrayList<>();

        while (true){
            String[] line = in.readLine().split("\\s+");
            if ("END".equals(line[0]))break;

            Pair<String, String> name = new Pair<>(line[0], line[1]);
            names.add(name);
        }

        names.stream()
                .filter(n -> n.getValue().compareTo(n.getKey()) > 0)
                .forEach(name -> System.out.printf("%s %s%n", name.getKey(), name.getValue()));
    }
}
