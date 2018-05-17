package L01IntroToJava_Lab;

import java.util.Scanner;

public class P04Greeting {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String firstName = in.nextLine();
        String lastName = in.nextLine();

        if (firstName.isEmpty()){
            firstName = "*****";
        }

        if (lastName.isEmpty()){
            lastName = "*****";
        }

        System.out.printf("Hello, %s %s!", firstName, lastName);
    }
}
