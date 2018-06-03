package L05StringProcessingEXC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p02SumBigNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder firstNum = new StringBuilder().append(in.readLine());
        StringBuilder secondNum = new StringBuilder().append(in.readLine());

        padNums(firstNum, secondNum);

        boolean isHigherThanTen = false;
        StringBuilder res = new StringBuilder();

        for (int i = firstNum.length() - 1; i >= 0; i--) {
            int digit = 0;

            if (!isHigherThanTen){
                digit = Integer.parseInt(firstNum.charAt(i) + "") + Integer.parseInt(secondNum.charAt(i) + "");
            }else {
                digit = Integer.parseInt(firstNum.charAt(i) + "") + Integer.parseInt(secondNum.charAt(i) + "") + 1;
                isHigherThanTen = false;
            }

            if (digit >= 10){
                digit %= 10;
                isHigherThanTen = true;
                res.append(digit);
            }else{
                res.append(digit);
            }
        }

        if (isHigherThanTen){
            res.append(1);
        }

        res.reverse();
        int resLen = res.length();

        for (int i = 0; i < resLen; i++) {
            if (res.charAt(0) == '0'){
                res.deleteCharAt(0);
            }else{
                break;
            }
        }
        System.out.println(res.toString());
    }

    static void padNums(StringBuilder firstNum, StringBuilder secondNum) {
        int firstNumLen = firstNum.length();
        int secondNumLen = secondNum.length();

        if (firstNumLen > secondNumLen){
            secondNum.reverse();
            for (int i = secondNumLen; i < firstNumLen; i++) {
                secondNum.append(0);
            }
            secondNum.reverse();
        }else if (secondNumLen > firstNumLen){
            firstNum.reverse();
            for (int i = firstNumLen; i < secondNumLen; i++) {
                firstNum.append(0);
            }
            firstNum.reverse();
        }
    }
}
