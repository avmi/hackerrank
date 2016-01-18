import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// TODO. Test cases fails - 9, 10, 14

public class CoinChangeProblem {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int M = scan.nextInt();
        int[] coins = new int[M];
        for (int i = 0; i < M; i++) {
            coins[i] = scan.nextInt();
        }
        System.out.println(max(coins, N));
    }

    public static int max(int[] coins, int N) {
        int[] num = new int[N+1];

        num[0] = 1;
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j < num.length; j++) {
                num[j] += num[j - coins[i]];
            }
        }

        return num[N];
    }
}
