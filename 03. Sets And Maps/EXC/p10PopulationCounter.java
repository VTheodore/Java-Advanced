package L03JavaAdvancedSetsAndMapsEXC;

import java.util.*;

import static java.util.Collections.reverseOrder;
import static java.util.Map.Entry.comparingByValue;
import static java.util.stream.Collectors.toMap;

public class p10PopulationCounter {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Map<String, LinkedHashMap<String, Long>> countries = new LinkedHashMap<>();
       

        while (true){
            String input = in.nextLine();

            if ("report".equals(input))break;

            String city = input.split("\\|")[0];
            String country = input.split("\\|")[1];
            long population = Long.parseLong(input.split("\\|")[2]);

            if (!countries.containsKey(country)){
                LinkedHashMap<String, Long> cityAndPopulation = new LinkedHashMap<>();
                cityAndPopulation.put(city, population);
                
                countries.put(country, cityAndPopulation);
            }else {
                if (!countries.get(country).containsKey(city)){
                    LinkedHashMap<String, Long> cityAndPopulation = countries.get(country);
                    cityAndPopulation.put(city, population);
                    
                    countries.put(country, cityAndPopulation);
                }else {
                    LinkedHashMap<String, Long> cityAndPopulation = countries.get(country);
                    cityAndPopulation.put(city, cityAndPopulation.get(city) + population);

                    countries.put(country, cityAndPopulation);
                }
            }
        }

        
        LinkedHashMap<String, Long> countryAndPopulation = new LinkedHashMap<>();

        for (String country : countries.keySet()) {
            long totalPopulation = 0;
            for (Long population : countries.get(country).values()) {
                totalPopulation += population;
            }

            countryAndPopulation.put(country, totalPopulation);
        }


        countries.entrySet().stream()
                .sorted((c1, c2) -> countryAndPopulation.get(c2.getKey()).compareTo(countryAndPopulation.get(c1.getKey())))
                .forEach(country -> {
                    System.out.printf("%s (total population: %d)%n", country.getKey(), countryAndPopulation.get(country.getKey()));
                    country.getValue().entrySet()
                            .stream().sorted((t1, t2) -> t2.getValue().compareTo(t1.getValue())).forEach(city -> {
                        System.out.printf("=>%s: %d%n", city.getKey(), city.getValue());
                    });
                });

    }
}
