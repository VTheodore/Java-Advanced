package L07StreamAPI_EXC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class p06FilterStudentByPhone {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        Map<String, String> phonesAndNames = new LinkedHashMap<>();

        while (true){
            String[] line = in.readLine().split("\\s+");
            if ("END".equals(line[0]))break;

            String name = line[0] + " " + line[1];
            String phone = line[2];

            phonesAndNames.putIfAbsent(phone, name);
        }

        phonesAndNames.entrySet().stream()
                .filter(n -> n.getKey().startsWith("02") || n.getKey().startsWith("+3592"))
                .forEach(n -> System.out.println(n.getValue()));
    }
}
