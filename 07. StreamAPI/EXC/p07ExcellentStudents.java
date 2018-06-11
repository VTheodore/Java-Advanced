package L07StreamAPI_EXC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class p07ExcellentStudents {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        Map<String, List<Integer>> studentsAndGrades = new LinkedHashMap<>();

        while (true){
            String[] line = in.readLine().split("\\s+");
            if ("END".equals(line[0]))break;

            String name = line[0] + " " + line[1];

            List<Integer> grades = new ArrayList<>();

            for (int i = 2; i < line.length; i++) {
                grades.add(Integer.parseInt(line[i]));
            }

            studentsAndGrades.putIfAbsent(name, grades);
        }

        studentsAndGrades.entrySet().stream()
                .filter(n -> n.getValue().contains(6))
                .forEach(st -> System.out.println(st.getKey()));
    }
}
