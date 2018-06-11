package L07StreamAPI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class p03FirstName {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        List<String> names = Arrays.asList(in.readLine().split("\\s+"));
        HashSet<Character> letters = new HashSet<>();

        Stream.of(in.readLine().split("\\s+"))
                .map(s -> s.toLowerCase().charAt(0))
                .forEach(c -> letters.add(c));

        Optional<String> firstName = names.stream()
                .filter(n -> letters.contains(n.toLowerCase().charAt(0)))
                .sorted()
                .findFirst();

        if (firstName.isPresent()){
            System.out.println(firstName.get());
        }else {
            System.out.println("No match");
        }
    }
}
