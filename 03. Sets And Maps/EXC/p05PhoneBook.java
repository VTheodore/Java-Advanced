package L03JavaAdvancedSetsAndMapsEXC;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class p05PhoneBook {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Map<String, String> phonebook = new HashMap<>();
        String input = in.nextLine();

        while (!"search".equals(input)){
            String name = input.split("-")[0];
            String number = input.split("-")[1];

            phonebook.put(name, number);
            input = in.nextLine();
        }

        input = in.nextLine();

        while (!"stop".equals(input)){
            if (phonebook.containsKey(input)){
                System.out.printf("%s -> %s%n", input, phonebook.get(input));
            }else{
                System.out.printf("Contact %s does not exist.%n", input);
            }

            input = in.nextLine();
        }
    }
}
