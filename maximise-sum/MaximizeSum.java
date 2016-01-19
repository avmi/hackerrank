import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// TODO: test cases #14, 15, 16 are failing

public class MaximizeSum {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int num = scan.nextInt();
        while (num >= 0) {
            int N = scan.nextInt();
            long M = (long) scan.nextInt();
            long[] array = new long[N];

            for (int i = 0; i < N; i++) {
                long temp = ((long) scan.nextInt()) % M;
                if(i == 0) {
                    array[i] = temp;
                }
                else {
                    array[i] = (array[i-1]+temp) % M;
                }
            }

            TreeSet<Long> ts = new TreeSet<Long>();
            long max = 0;

            for (long i: array) {
                if (ts.isEmpty()) {
                    max = i;
                    ts.add(i);
                }
                else {
                    max = Math.max(max, i);
                    Long next = ts.ceiling(i+1);
                    if (next != null) max = Math.max(max, i - next + M);
                    ts.add(i);
                }
            }

            System.out.println(max);

            num--;
        }
    }
}
