package L03JavaAdvancedSetsAndMapsEXC;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class p07FixEmails {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Map<String, String> emails = new LinkedHashMap<>();

        while (true){
            String name = in.nextLine();
            if ("stop".equals(name))break;
            String email = in.nextLine();

            if (!(email.endsWith(".com") || email.endsWith(".us") || email.endsWith(".uk"))){
                emails.put(name, email);
            }
        }

        for (String name : emails.keySet()) {
            System.out.printf("%s -> %s%n", name, emails.get(name));
        }
    }
}
