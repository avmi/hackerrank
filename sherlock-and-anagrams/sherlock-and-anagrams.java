import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        int[] frequency = new int[26];
        Scanner stdin = new Scanner(System.in);

        int cases = Integer.parseInt(stdin.nextLine());
        int sum = 0;

        String caseString = "";
        for (int a = 0; a < cases; a++) {
            sum = 0;
            caseString = stdin.nextLine();
            for (int start1 = 0; start1 < caseString.length(); start1++) {
                for (int start2 = start1; start2 < caseString.length(); start2++) {
                    for(int length = 1; length <= caseString.length() - Math.max(start1,  start2); length++){
                        if(start1 != start2){
                            String s1 = caseString.substring(start1, start1+length);
                            String s2 = caseString.substring(start2, start2+length);
                            if (check(s1, s2)) {
                                sum++;
                            }
                        }
                    }
                }
            }
            System.out.println(sum);
        }
    }

    public static int count(String inputString, char testingChar) {
        int sum = 0;
        for (int a = 0; a < inputString.length(); a++) {
            if (inputString.charAt(a) == testingChar) {
                sum++;
            }
        }
        return sum;
    }

    public static boolean check(String s1, String s2){
        boolean result = true;
        for(int a = 0; a < 26; a++){
            if (count(s1, (char) (a + 96)) != count(s2, (char) (a + 96))){
                result = false;
            }
        }
        return result;
    }
}