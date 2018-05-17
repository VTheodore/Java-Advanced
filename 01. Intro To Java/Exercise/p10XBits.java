package L01IntroToJavaEXC;

import java.util.Scanner;

public class p10XBits {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] binaries = new String[8];

        for (int i = 0; i < 8; i++) {
            String binary = String.format("%32s", Integer.toBinaryString(Integer.parseInt(in.nextLine()))).replace(' ', '0');
            binaries[i] = binary;
        }

        int counter = 0;

        for (int i = 0; i < binaries.length - 2; i++) {
            for (int j = 0; j < binaries[i].length() - 2; j++) {
                String a = binaries[i].charAt(j) + "" + binaries[i].charAt(j + 1) + binaries[i].charAt(j + 2);
                String b = binaries[i + 1].charAt(j) + "" + binaries[i + 1].charAt(j + 1) + binaries[i + 1].charAt(j + 2);
                String c = binaries[i + 2].charAt(j) + "" + binaries[i + 2].charAt(j + 1) + binaries[i + 2].charAt(j + 2);

                if ("101".equals(a) && "010".equals(b) && "101".equals(c)) {
                    counter++;
                }
            }
        }

        System.out.println(counter);
    }
}
