package L01IntroToJava_Lab;

import java.util.Scanner;

public class P01ReadInput {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String firstWord = in.next();
        String secondWord = in.next();
        int numOne = in.nextInt();
        int numTwo = in.nextInt();
        int numThree = in.nextInt();
        in.nextLine();
        String thirdWord = in.nextLine();

        int sum = numOne + numTwo + numThree;

        System.out.printf("%s %s %s %d", firstWord, secondWord, thirdWord, sum);
    }
}
