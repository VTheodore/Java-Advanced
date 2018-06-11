package L07StreamAPI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Optional;

public class p06FindAndSumIntegers {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        Optional<Integer> sum = Arrays.stream(in.readLine().split(" "))
                .filter(n -> {
                    try{
                        double num = Double.parseDouble(n);
                        return true;
                    }catch (Exception ex){
                        return false;
                    }
                }).map(Integer::parseInt)
                .reduce((x1, x2) -> x1 + x2);

        if (sum.isPresent()){
            System.out.printf("%d", sum.get());
        }else{
            System.out.println("No match");
        }
    }
}
