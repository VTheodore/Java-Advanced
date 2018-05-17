package L01IntroToJava_Lab;

import java.util.Scanner;

public class P09ExtractBitFromInteger {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] input = in.nextLine().split(" ");

        int num = Integer.parseInt(input[0]);
        int position = Integer.parseInt(input[1]);
        int mask = num >> position;
        int bit = mask & 1;

        System.out.println(bit);
    }
}
