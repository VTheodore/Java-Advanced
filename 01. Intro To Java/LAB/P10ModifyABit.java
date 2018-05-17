package L01IntroToJava_Lab;

import java.util.Scanner;

public class P10ModifyABit {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] input = in.nextLine().split(" ");

        int num = Integer.parseInt(input[0]);
        int position = Integer.parseInt(input[1]);
        int bitValue = Integer.parseInt(input[2]);

        int result = 0;

        if (bitValue == 0){
            int mask = ~(1 << position);
            result = num & mask;
        }else if (bitValue == 1){
            int mask = 1 << position;
            result = num | mask;
        }

        System.out.println(result);
    }
}
