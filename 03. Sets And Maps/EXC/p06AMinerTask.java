package L03JavaAdvancedSetsAndMapsEXC;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class p06AMinerTask {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Map<String, Integer> resources = new LinkedHashMap<>();

        while (true){
            String resource = in.nextLine();
            if ("stop".equals(resource))break;

            int quantity = Integer.parseInt(in.nextLine());

            if (!resources.containsKey(resource)){
                resources.put(resource, quantity);
            }else{
                resources.put(resource, resources.get(resource) + quantity);
            }
        }

        for (String s : resources.keySet()) {
            System.out.printf("%s -> %d%n", s, resources.get(s));
        }
    }
}
