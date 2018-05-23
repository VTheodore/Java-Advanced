package L03JavaAdvancedSetsAndMapsEXC;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class p01UniqueUsernames {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = Integer.parseInt(in.nextLine());
        Set<String> usernames = new LinkedHashSet<>(n);

        for (int i = 0; i < n; i++) {
            String username = in.nextLine();

            usernames.add(username);
        }

        for (String username : usernames) {
            System.out.println(username);
        }
    }
}
