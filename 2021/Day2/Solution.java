import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) throws IOException {
        List<String> inputLines = Files.readAllLines(Paths.get("./input.txt"));

        partOne(inputLines);
        partTwo(inputLines);
    }

    static void partOne(List<String> inputLines){

        int val = 0;
        int horiz = 0;
        int depth = 0;

        for(String s: inputLines) {
            var command = s.split(" ");
            val = Integer.parseInt(command[1]);
            switch (command[0]) {
                case "forward":
                    horiz += val;
                    break;
                case "down":
                    depth += val;
                    break;
                case "up":
                    depth -= val;
                    break;
            }
        }
        System.out.println("Task1: " + horiz + " " + depth);
        System.out.println("Task1: " + horiz * depth);

    }

    static void partTwo(List<String> inputLines){

        int val = 0;
        int horiz = 0;
        int depth = 0;
        int aim = 0;

        for(String s: inputLines) {
            var command = s.split(" ");
            val = Integer.parseInt(command[1]);
            switch (command[0]) {
                case "forward":
                    horiz += val;
                    depth += aim * val;
                    break;
                case "down":
                    aim += val;
                    break;
                case "up":
                    aim -= val;
                    break;
            }
        }
        System.out.println("Task2: " + horiz + " " + depth);
        System.out.println("Task2: " + horiz * depth);
    }
}
