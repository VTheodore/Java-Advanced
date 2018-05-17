package L01IntroToJavaEXC;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class p09ByteParty {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = Integer.parseInt(in.nextLine());
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(in.nextLine());

            nums[i] = num;
        }

        while (true) {
            String command = in.nextLine();

            if ("party over".equals(command)) {
                break;
            }

            int token = Integer.parseInt(command.split("\\s+")[0]);
            int position = Integer.parseInt(command.split("\\s+")[1]);

            switch (token) {
                case -1:
                    for (int i = 0; i < nums.length; i++) {
                        nums[i] = (nums[i] ^ (1 << position));
                    }
                    break;
                case 0:
                    for (int i = 0; i < nums.length; i++) {
                        int mask = ~(1 << position);
                        nums[i] = nums[i] & mask;
                    }
                    break;
                case 1:
                    for (int i = 0; i < nums.length; i++) {
                        nums[i] = (nums[i] | (1 << position));
                    }
                    break;
            }
        }

        for (int num : nums) {
            System.out.println(num);
        }
    }
}
