import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) throws IOException {
        List<String> inputLines = Files.readAllLines(Paths.get("./input.txt"));
        var inputIntegers = inputLines.stream().map(Integer::parseInt).collect(Collectors.toList());



        partOne(inputIntegers);
        partTwo(inputIntegers);
    }

    static void partOne(List<Integer> inputIntegers){
        int current, sum = 0;
        int lastDepth= inputIntegers.get(0);

        for(int i = 1; i<inputIntegers.size(); i++){
            current = inputIntegers.get(i);
            if(current > lastDepth)
                sum++;
            lastDepth=current;
        }

        System.out.println("Task1: " + sum);
    }

    static void partTwo(List<Integer> inputIntegers){
        int current, sum = 0;
        int lastSum= inputIntegers.get(0) + inputIntegers.get(1) + inputIntegers.get(2);

        for(int i = 1; i<inputIntegers.size()-2; i++){
            current = inputIntegers.get(i) + inputIntegers.get(i+1) + inputIntegers.get(i+2);
            if(current > lastSum)
                sum++;
            lastSum=current;
        }

        System.out.println("Task2: " + sum);
    }
}
