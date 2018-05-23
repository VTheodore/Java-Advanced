package L03JavaAdvancedSetsAndMaps;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.*;

public class p05AcademyGraduation {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = Integer.parseInt(in.nextLine());

        Map<String, Double> students = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String name = in.nextLine();
            double[] grades = Arrays.stream(in.nextLine().split("\\s+")).mapToDouble(Double::parseDouble).toArray();
            double average = 0;

            for (double grade : grades) {
                average += grade;
            }

            average /= grades.length;
            students.put(name, average);
        }

        for (String student : students.keySet()) {
            String average = String.format("%.20f", students.get(student));
            average = removeTrailingZeros(average); // Completely unnecessary :)

            System.out.printf("%s is graduated with %s%n", student, average);
        }
    }

    static String removeTrailingZeros(String average) {
        String result = "";

        int index = 0;
        for (int i = average.length() - 1; i >= 0; i--) {
            if (average.charAt(i) != '0'){
                if (average.charAt(i) == '.'){
                    index = i;
                }
                index = i + 1;
                break;
            }
        }
        return average.substring(0, index);
    }
}
