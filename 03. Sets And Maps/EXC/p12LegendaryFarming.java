package L03JavaAdvancedSetsAndMapsEXC;

import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.TreeMap;


public class p12LegendaryFarming {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        TreeMap<String, Integer> keyMaterials = new TreeMap<>();
        keyMaterials.put("shards", 0);
        keyMaterials.put("fragments", 0);
        keyMaterials.put("motes", 0);

        TreeMap<String, Integer> junkMaterials = new TreeMap<>();
        String winner = "";
        while (true) {
            String[] tokens = in.nextLine().split("\\s+");

            for (int i = 0; i < tokens.length; i += 2) {
                int quantity = Integer.parseInt(tokens[i]);
                String material = tokens[i + 1].toLowerCase();

                if ("shards".equals(material) || "fragments".equals(material) || "motes".equals(material)) {
                    keyMaterials.put(material, keyMaterials.get(material) + quantity);
                    if (keyMaterials.get(material) >= 250) {
                        switch (material) {
                            case "shards":
                                winner = "Shadowmourne";
                                break;
                            case "fragments":
                                winner = "Valanyr";
                                break;
                            case "motes":
                                winner = "Dragonwrath";
                                break;
                        }

                        keyMaterials.put(material, keyMaterials.get(material) - 250);

                        printResult(keyMaterials, junkMaterials, winner);
                        return;
                    }
                } else {
                    if (!junkMaterials.containsKey(material)) {
                        junkMaterials.put(material, quantity);
                    } else {
                        junkMaterials.put(material, junkMaterials.get(material) + quantity);
                    }
                }
            }
        }
    }

    private static void printResult(TreeMap<String, Integer> keyMaterials, TreeMap<String, Integer> junkMaterials, String winner) {

        System.out.println(winner + " obtained!");
        keyMaterials.entrySet().stream().sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue())).forEach(entry -> {
            System.out.printf("%s: %d%n", entry.getKey(), entry.getValue());
        });

        junkMaterials.entrySet().stream().forEach(entry -> {
            System.out.printf("%s: %d%n", entry.getKey(), entry.getValue());
        });
    }
}
