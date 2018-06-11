package L07StreamAPI_EXC;

import javafx.util.Pair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class p04SortStudents {
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
                .sorted((n1, n2) -> {
                    int lastNameComparator = n1.getValue().compareTo(n2.getValue());

                    if (lastNameComparator != 0)return lastNameComparator;

                    return n2.getKey().compareTo(n1.getKey());
                })
                .forEach(n -> System.out.printf("%s %s%n", n.getKey(), n.getValue()));
    }
}
