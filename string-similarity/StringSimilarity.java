import java.io.*;
import java.util.*;

// TODO: Fix timeout in test cases #10 and #11

public class StringSimilarity {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numCases = scanner.nextInt();

        for (int i = 0; i < numCases; i++) {
            String input = scanner.next();
            System.out.println(solve(input));
        }
    }

    public static int solve(String s) {
        int length = s.length();
        int count = length;

        for (int i = 1; i < length; i++) {
            int len = length - i;
            int j;

            for(j = 0; j < len; j++) {
                if (s.charAt(j) != s.charAt(j + i)) {
                    break;
                }
            }
            count += j;
        }

        return count;
    }
}