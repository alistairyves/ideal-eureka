import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.lang.StringBuilder;

public class Solution {

    public static void main(String[] args) throws IOException {
        List<String> inputLines = Files.readAllLines(Paths.get("./input.txt"));

        partOne(inputLines);
        partTwo(inputLines);
    }

    static void partOne(List<String> inputLines){

        int[] tracker = new int[]{0,0,0,0,0,0,0,0,0,0,0,0};

        for(String s: inputLines) {
            for(int i = 0; i<12; i++){
                if(s.charAt(i)=='1')
                {
                    tracker[i]++;
                }else{
                    tracker[i]--;
                }
            }

        }
        StringBuilder gamma = new StringBuilder();
        StringBuilder epsilon = new StringBuilder();
        for(int j: tracker){
            if(j>0){
                gamma.append('1');
                epsilon.append('0');
            } else {
                gamma.append('0');
                epsilon.append('1');
            }
        }


        System.out.println("Task1: " + gamma.toString() + " " + epsilon.toString());
        System.out.println("Task1: " + Integer.parseInt(gamma.toString(),2) * Integer.parseInt(epsilon.toString(),2));

    }



    static void partTwo(List<String> inputLines){
        System.out.println("o2: " + getox2(inputLines, 0));
        System.out.println("co2: " + getco2(inputLines, 0));
        System.out.println("Task2: " + Integer.parseInt(getox2(inputLines, 0),2) * Integer.parseInt(getco2(inputLines, 0),2));

    }

    static String getox2(List<String> lines, int position){
        int tracker = 0;
        ArrayList<String> nextLines = new ArrayList<String>();
        for(String line: lines){
            if(line.charAt(position) == '1'){
                tracker++;
            } else{
                tracker--;
            }
        }

        char mostCommon;
        if(tracker >= 0)
            mostCommon = '1';
        else
            mostCommon = '0';

        for(String line: lines){
            if(line.charAt(position) == mostCommon){
                nextLines.add(line);
            }
        }

        if(nextLines.size()==1)
            return nextLines.get(0);

        return getox2(nextLines,position+1);


    }
    static String getco2(List<String> lines, int position){
        int tracker = 0;
        ArrayList<String> nextLines = new ArrayList<String>();
        for(String line: lines){
            if(line.charAt(position) == '1'){
                tracker++;
            } else{
                tracker--;
            }
        }

        char leastCommon;
        if(tracker >= 0)
            leastCommon = '0';
        else
            leastCommon = '1';

        for(String line: lines){
            if(line.charAt(position) == leastCommon){
                nextLines.add(line);
            }
        }

        if(nextLines.size()==1)
            return nextLines.get(0);

        return getco2(nextLines,position+1);


    }
}
