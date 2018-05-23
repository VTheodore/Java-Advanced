package L03JavaAdvancedSetsAndMapsEXC;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p14DragonArmy {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = Integer.parseInt(in.nextLine());
        Map<String, TreeMap<String, int[]>> dragons = new LinkedHashMap<>();
        Pattern p = Pattern.compile("(?<type>\\w+) (?<name>\\w+) (?<damage>\\S+) (?<health>\\S+) (?<armor>\\S+)");

        for (int i = 0; i < n; i++) {
            String input = in.nextLine();
            Matcher m = p.matcher(input);

            String type = "";
            String name = "";
            int damage = 0;
            int health = 0;
            int armor = 0;

            if (m.find()){
                type = m.group("type");
                name = m.group("name");
                damage = m.group("damage").equals("null") ? 45 : Integer.parseInt(m.group("damage"));
                health = m.group("health").equals("null") ? 250 : Integer.parseInt(m.group("health"));
                armor = m.group("armor").equals("null") ? 10 : Integer.parseInt(m.group("armor"));
            }

            if (!dragons.containsKey(type)){
                int[] stats = new int[3];
                stats[0] = damage;
                stats[1] = health;
                stats[2] = armor;

                TreeMap<String, int[]> dragon = new TreeMap<>();
                dragon.put(name, stats);

                dragons.put(type, dragon);
            }else {
                int[] stats = new int[3];
                stats[0] = damage;
                stats[1] = health;
                stats[2] = armor;

                TreeMap<String, int[]> dragon = dragons.get(type);
                dragon.put(name, stats);

                dragons.put(type, dragon);
            }
        }


        for (String type : dragons.keySet()) {
            double avgDmg = 0;
            double avgHealth = 0;
            double avgArmor = 0;
            StringBuilder res = new StringBuilder();
            int counter = 0;

            for (String name : dragons.get(type).keySet()) {
                avgDmg += dragons.get(type).get(name)[0];
                avgHealth += dragons.get(type).get(name)[1];
                avgArmor += dragons.get(type).get(name)[2];

                res.append(String.format("-%s -> damage: %d, health: %d, armor: %d%n", name, dragons.get(type).get(name)[0], dragons.get(type).get(name)[1], dragons.get(type).get(name)[2]));
                counter++;
            }

            avgDmg /= counter;
            avgHealth /= counter;
            avgArmor /= counter;

            System.out.printf("%s::(%.2f/%.2f/%.2f)%n", type, avgDmg, avgHealth, avgArmor);
            System.out.print(res);
        }

    }
}
