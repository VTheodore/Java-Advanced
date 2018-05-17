package L01IntroToJavaEXC;

import java.util.Scanner;

public class p01RectangleArea {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        double width = in.nextDouble();
        double height = in.nextDouble();

        double area = width * height;

        System.out.printf("%.2f", area);
    }
}
