package L01IntroToJavaEXC;

import java.util.Scanner;

public class p03FormattingNumbers {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int firstNum = in.nextInt();
        double secondNum = in.nextDouble();
        double thirdNum = in.nextDouble();

        String firstNumInHex = Integer.toHexString(firstNum);
        long firstNumInBinary = Long.parseLong(Integer.toBinaryString(firstNum));

        String firstColumn = getFirstColumn(firstNumInHex);
        String secondColumn = String.format("%010d|", firstNumInBinary);
        String thirdColumn = getThirdColumn(secondNum);
        String fourthColumn = getFourthColumn(thirdNum);

        System.out.println(firstColumn + secondColumn + thirdColumn + fourthColumn);
    }

    static String getFourthColumn(double num) {
        StringBuilder res = new StringBuilder();
        String numAsTxt = String.format("%.3f", num);
        res.append(numAsTxt);

        for (int i = 0; i < 10 - numAsTxt.length(); i++) {
            res.append(' ');
        }

        res.append('|');

        return res.toString();
    }

    static String getThirdColumn(double num) {
        StringBuilder res = new StringBuilder();
        String numAsText = String.format("%.2f", num);

        for (int i = 0; i < 10 - numAsText.length(); i++) {
            res.append(' ');
        }

        res.append(numAsText);
        res.append('|');

        return res.toString();
    }

    static String getFirstColumn(String firstNumInHex) {
        StringBuilder res = new StringBuilder();
        res.append('|');

        res.append(firstNumInHex.toUpperCase());
        for (int i = 0; i < 10 - firstNumInHex.length(); i++) {
            res.append(" ");
        }
        res.append('|');


        return res.toString();
    }
}
