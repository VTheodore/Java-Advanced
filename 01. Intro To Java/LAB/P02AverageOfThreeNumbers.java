package L01IntroToJava_Lab;

import java.util.Scanner;

public class P02AverageOfThreeNumbers {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        double firstNum = in.nextDouble();
        double secondNum = in.nextDouble();
        double thirdNum = in.nextDouble();
        in.nextLine();

        double average = (firstNum + secondNum + thirdNum) / 3.0;

        System.out.printf("%.2f", average);
    }
}
