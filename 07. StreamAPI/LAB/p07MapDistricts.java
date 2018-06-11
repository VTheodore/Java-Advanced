package L07StreamAPI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class p07MapDistricts {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        List<String> citiesAndPop = Arrays.stream(in.readLine().split("\\s+")).collect(Collectors.toList());
        int minFilter = Integer.parseInt(in.readLine());

        Map<String, List<Integer>> districts = new LinkedHashMap<>();

        for (String cityAndPop : citiesAndPop) {
            String city = cityAndPop.split(":")[0];
            int population = Integer.parseInt(cityAndPop.split(":")[1]);

            if (!districts.containsKey(city)){
                districts.put(city, new ArrayList<>());
            }

            districts.get(city).add(population);
        }

        StringBuilder res = new StringBuilder();

        districts.entrySet().stream()
                .filter(city -> {
                    Optional<Integer> sumOfDistricts = city.getValue().stream().reduce((x1, x2)-> x1 + x2);

                    if (sumOfDistricts.isPresent()){
                        if (sumOfDistricts.get() >= minFilter)return true;
                    }

                    return false;
                })
                .sorted((city1, city2) -> {
                    Optional<Integer> sumOfCity1 = city1.getValue().stream().reduce((x1, x2) -> x1 + x2);
                    Optional<Integer> sumOfCity2 = city2.getValue().stream().reduce((x1, x2) -> x1 + x2);

                    return sumOfCity2.map(integer -> integer - sumOfCity1.get()).orElseGet(() -> sumOfCity2.get() - sumOfCity1.get());

                })
        .forEach(city -> {
            res.append(String.format("%s: ", city.getKey()));

            city.getValue().stream()
                    .sorted(Comparator.reverseOrder())
            .limit(5)
            .forEach(dis -> {
                res.append(String.format("%d ", dis));
            });

            res.append(System.lineSeparator());
        });

        System.out.println(res);
    }
}
