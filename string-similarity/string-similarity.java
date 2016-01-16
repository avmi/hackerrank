import java.io.*;
import java.util.*;

// TODO: Fix timeout in test cases #10 and #11

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Solution context = new Solution();
        int numCases = scanner.nextInt();

        for (int i = 0; i < numCases; i++) {
            String input = scanner.next();
            context.solve(input);
        }
    }

    private void solve(String input) {
        String str = input;
        int len = input.length();
        int count = 0;
        int total = 0;

        for (int i=1; i<len; i++) {
            count=0;
            for (int j=i; j<len; j++) {
                if(str.charAt(j-i)==str.charAt(j)) {
                    count++;
                }
                else {
                    break;
                }
            }

            total += count;
        }

        System.out.println(total+len);
    }
}