import java.io.*;
import java.util.*;

public class euler001 {
    public static long sum(int limit) {
        long i = 3;
        long j = 5;
        long s = --limit / i;
        long t = limit / j;
        long u = limit / (i * j);
        long sum = (i * (s * (s + 1) / 2)) + (j * (t * (t + 1) / 2)) - ((i * j) * (u * (u + 1) / 2));

        return sum;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int[] input = new int[N];

        for (int i = 0; i < N; i++) {
            input[i] = scan.nextInt();
        }

        for (int i = 0; i < N; i++) {
            System.out.println(sum(input[i]));
        }
    }
}
