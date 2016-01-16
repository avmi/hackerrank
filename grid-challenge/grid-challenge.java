import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int count = scan.nextInt();

        for(int i = 0; i < count; i++) {
            int n = scan.nextInt();
            char[][] buf = new char[n][n];

            for(int j = 0; j < n; j++) {
                String line = scan.next();
                for(int k = 0; k < n; k++) {
                    buf[j][k] = line.charAt(k);
                }
                Arrays.sort(buf[j]);
            }

            boolean ok = true;
            for(int j = 0; j < n && ok; j++) {
                for(int k = 1; k < n && ok; k++) {
                    if(Character.compare(buf[k][j], buf[k-1][j]) < 0) ok = false;
                }
            }

            System.out.println(ok ? "YES" : "NO");
        }
    }
}