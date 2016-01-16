import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] A = br.readLine().toCharArray();
        char[] B = br.readLine().toCharArray();

        int[] diffs = new int['z' - 'a' + 1];
        for(char c : A){
            diffs[c - 'a']++;
        }
        for(char c : B){
            diffs[c - 'a']--;
        }
        int sum = 0;
        for(int diff : diffs){
            sum += (diff < 0) ? -diff : diff;
        }

        System.out.print(sum);
    }
}