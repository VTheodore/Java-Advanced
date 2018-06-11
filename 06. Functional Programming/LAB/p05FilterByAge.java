package L06FunctionalProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class p05FilterByAge {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());
        var people = new LinkedHashMap<String, Integer>();

        for (int i = 0; i < n; i++) {
            String[] line = in.readLine().split(", ");
            people.putIfAbsent(line[0], Integer.parseInt(line[1]));
        }

        String condition = in.readLine();
        Integer age = Integer.parseInt(in.readLine());
        String format = in.readLine();

        Predicate<Integer> tester = createTester(condition, age);
        Consumer<Map.Entry<String, Integer>> printer = createPrinter(format);

        printFilteredStudent(people, tester, printer);
    }

    private static void printFilteredStudent(LinkedHashMap<String, Integer> people, Predicate<Integer> tester, Consumer<Map.Entry<String, Integer>> printer) {
        for (Map.Entry<String, Integer> person : people.entrySet()) {
            if (tester.test(people.get(person.getKey()))){
                printer.accept(person);
            }
        }
    }

    private static Consumer<Map.Entry<String,Integer>> createPrinter(String format) {
        switch (format){
            case "name age":
                return person -> System.out.printf("%s - %d%n", person.getKey(), person.getValue());
            case "name":
                return person -> System.out.printf("%s%n", person.getKey());
        }

        return person -> System.out.printf("%d%n", person.getValue());
    }

    private static Predicate<Integer> createTester(String condition, Integer age) {
        switch (condition) {
            case "younger":
                return x -> x <= age;
        }
        return x -> x >= age;
    }
}
