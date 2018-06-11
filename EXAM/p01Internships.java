import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class p01Internships {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int problemsCount = Integer.parseInt(in.readLine());
        int candidatesCount = Integer.parseInt(in.readLine());

        //Stack
        ArrayDeque<String> problemsStack = new ArrayDeque<>();
        //Queue
        ArrayDeque<String> candidatesQueue = new ArrayDeque<>();

        for (int i = 0; i < problemsCount; i++) {
            String problem = in.readLine();
            problemsStack.push(problem);
        }

        List<String> passedCandidates = new ArrayList<>();
        Pattern pattern = Pattern.compile("^[A-Z][a-z]+ [A-Z][a-z]+$");
        for (int i = 0; i < candidatesCount; i++) {
            String name = in.readLine();
            Matcher matcher = pattern.matcher(name);

            if (!matcher.find())continue;

            candidatesQueue.offer(name);
            passedCandidates.add(name);
        }


        while (problemsStack.size() != 0 && candidatesQueue.size() != 1){
            int problemSum = getSumOfCharacters(Objects.requireNonNull(problemsStack.peek()));
            int candidateSum = getSumOfCharacters(Objects.requireNonNull(candidatesQueue.peek()));

            String problem;
            String candidate;
            if (candidateSum >= problemSum){
                problem = problemsStack.pop();
                candidate = candidatesQueue.poll();

                candidatesQueue.offer(candidate);

                System.out.printf("%s solved %s.%n", candidate, problem);
            }else {
                problem = problemsStack.pop();
                candidate = candidatesQueue.poll();

                problemsStack.addLast(problem);

                System.out.printf("%s failed %s.%n", candidate, problem);
            }
        }


        if (candidatesQueue.size() == 1){
            System.out.printf("%s gets the job!", candidatesQueue.poll());
        }else {
            for (String passedCandidate : passedCandidates.stream().distinct().collect(Collectors.toList())) {
                System.out.printf("%s, ", passedCandidate);
            }
        }
    }

    private static int getSumOfCharacters(String str) {
        int count = 0;

        for (int i = 0; i < str.length(); i++) {
            count += (int) str.charAt(i);
        }

        return count;
    }
}
