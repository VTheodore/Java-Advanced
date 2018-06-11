package L07StreamAPI_EXC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class p05FilterStudentsByEmailDomain {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        Map<String, String> nameAndEmail = new LinkedHashMap<>();
        while (true){
            String[] line = in.readLine().split("\\s+");
            if ("END".equals(line[0]))break;

            String name = line[0] + " " + line[1];
            String email = line[2];

            nameAndEmail.putIfAbsent(email, name);
        }

        nameAndEmail.entrySet().stream()
                .filter(e -> e.getKey().endsWith("@gmail.com"))
                .forEach(n -> System.out.println(n.getValue()));
    }
}
