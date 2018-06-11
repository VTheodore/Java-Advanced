package L06FunctionalProgrammingEXC;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.function.*;

public class p11PredicateParty {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] input = in.nextLine().split("\\s+");
        var people = new LinkedList<String>();
        people.addAll(Arrays.asList(input));

        Consumer<List<String>> executeCommands = ppl -> {
            String[] command = in.nextLine().split("\\s+");

            while (!"Party!".equals(command[0])){
                switch (command[1]){
                    case "StartsWith":
                        String[] finalCommand1 = command;
                        foreachName(command[0], people, n -> n.startsWith(finalCommand1[2]));
                        break;
                    case "EndsWith":
                        String[] finalCommand = command;
                        foreachName(command[0], people, n -> n.endsWith(finalCommand[2]));
                        break;
                    case "Length":
                        String[] finalCommand2 = command;
                        foreachName(command[0], people, n -> n.length() == Integer.parseInt(finalCommand2[2]));
                        break;
                }
                command = in.nextLine().split("\\s+");
            }
        };

        Consumer<List<String>> printComingPeople = ppl -> {
            if (!ppl.isEmpty()){
                System.out.printf("%s are going to the party!%n", String.join(", ", ppl));
            }else{
                System.out.println("Nobody is going to the party!");
            }
        };


        executeCommands.accept(people);
        printComingPeople.accept(people);

    }

    private static void foreachName(String command, List<String> people, Function<String, Boolean> condition){
        for (int i = people.size() - 1; i >= 0; i--) {
            if (condition.apply(people.get(i))){
                switch (command){
                    case "Remove":
                        people.remove(people.get(i));
                        break;
                    case "Double":
                        people.add(i, people.get(i));
                        break;
                }
            }
        }
    }
}
