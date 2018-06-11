package L07StreamAPI_EXC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class p09StudentsEnrolledIn14or15 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        Map<String, List<Integer>> students = new LinkedHashMap<>();

        while (true){
            String[] line = in.readLine().split("\\s+");
            if ("END".equals(line[0]))break;

            String student = line[0];

            List<Integer> grades = new ArrayList<>();

            for (int i = 1; i < line.length; i++) {
                grades.add(Integer.parseInt(line[i]));
            }

            students.putIfAbsent(student, grades);
        }

        students.entrySet().stream()
                .filter(n -> n.getKey().endsWith("14") || n.getKey().endsWith("15"))
                .forEach(st -> {
                    for (Integer grade : st.getValue()) {
                        System.out.printf("%d ", grade);
                    }

                    System.out.println();
                });
    }
}
