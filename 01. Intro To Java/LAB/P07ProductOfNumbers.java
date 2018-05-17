package L01IntroToJava_Lab;

import java.math.BigInteger;
import java.util.Scanner;

public class P07ProductOfNumbers {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int nOld = n;
        int m = in.nextInt();

        BigInteger product = BigInteger.ONE;

        do {
            BigInteger number = new BigInteger("" + n);
            product = product.multiply(number);
            n++;
        }while (n <= m);

        System.out.printf("product[%d..%d] = %d%n", nOld, m, product);
    }
}
