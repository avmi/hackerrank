import java.io.*;
import java.util.*;
import java.math.*;

public class Solution {
    static Scanner in;
    static int n;
    static final BigInteger two = new BigInteger("2");
    static BigInteger [] ways = new BigInteger[32];
    static BigInteger [] fr = new BigInteger[10];
    static BigInteger [] cfr = new BigInteger[1024];
    static BigInteger [] memo = new BigInteger[1024];
    static int [] count = new int[1024];

    public static void main(String [] args) {
        in = new Scanner(System.in);
        ways[0] = BigInteger.ZERO;
        ways[1] = ways[2] = BigInteger.ONE;

        for (int i = 3; i < 32; i ++) {
            ways[i] = new BigInteger(Integer.toString(i)).pow(i - 2);
        }

        int nC = in.nextInt();
        for (int i = 0; i < nC; i++) {
            solve();
        }
    }

    public static BigInteger get(int m) {
        if (memo[m].compareTo(BigInteger.ZERO) > 0) {
            return memo[m];
        }

        BigInteger result = BigInteger.ZERO;
        for (int mask1 = 1; mask1 < m; mask1 ++) {
            if ((mask1 & m) != mask1) continue;
            int mask2 = m - mask1;
            result = result.add(get(mask1).multiply(get(mask2).multiply(cfr[mask1].multiply(cfr[mask2]))));
        }

        result = result.divide(two.multiply(new BigInteger(Integer.toString(count[m])).subtract(BigInteger.ONE)));
        return memo[m] = result;
    }

    public static void solve() {
        n = in.nextInt();

        for (int i = 0; i < (1 << n); i ++) {
            memo[i] = BigInteger.ZERO;
        }

        for (int i = 0; i < n; i ++) {
            int k = in.nextInt();
            memo[1 << i] = ways[k];
            fr[i] = new BigInteger(Integer.toString(k));
        }

        for (int i = 0; i < (1 << n); i ++) {
            cfr[i] = BigInteger.ZERO;
            count[i] = 0;
            for (int j = 0; j < n; j ++) {
                if (((i >> j) & 1) > 0) {
                    cfr[i] = cfr[i].add(fr[j]);
                    count[i] ++;
                }
            }
        }

        System.out.println(get((1 << n) - 1).mod(new BigInteger("1000000007")).toString());
    }
}