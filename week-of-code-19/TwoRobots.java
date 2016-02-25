import java.util.*;

/*
Submitted a few seconds ago • Score: 29.52 Status: Accepted
Test Case #0:   0.11s Test Case #1:   0.14s Test Case #2:   0.16s Test Case #3:   0.32s Test Case #4:   0.66s
Test Case #5:   0.24s Test Case #6:   0.17s Test Case #7:   0.34s Test Case #8:   0.3s Test Case #9:   0.67s
Test Case #10:   0.8s Test Case #11:   0.81s Test Case #12:   1.22s Test Case #13:   1.51s Test Case #14:   1.6s
 */
public class TwoRobots {

    static int[] X = new int[1001];
    static int[] Y = new int[1001];
    static int[] C = new int[1001];
    static int m;
    static int n;

    static int cost(int l, int r) {
        if (l == 0) {
            return Math.abs(X[r] - Y[r]);
        }
        else {
            return Math.abs(Y[l] - X[r]) + Math.abs(X[r] - Y[r]);
        }
    }

    static int solve() {
        int res = 10000000;

        for (int i = 0; i < n; ++i) {
            res = Math.min(res, C[i]);
        }

        return res;
    }

    static void dump(int v) {
        System.out.format("Dump %d -> %d\n", v - 1, v);
        for (int i = 0; i < v; ++i) {
            System.out.format("%d ", C[i]);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();

        for (int t = 0; t < T; t++) {
            m = scan.nextInt();
            n = scan.nextInt();

            for (int i = 1; i <= n; ++i) {
                X[i] = scan.nextInt();
                Y[i] = scan.nextInt();
            }

            C[0] = 0;
            for (int i = 1; i <= n; ++i) {
                C[i - 1] = C[0] + cost(0, i);

                // left
                for (int j = 1; j < i - 1; ++j) {
                    C[i - 1] = Math.min(C[i - 1], C[j] + cost(j, i));
                }

                // right
                for (int j = 0; j < i - 1; ++j) {
                    C[j] += cost(i - 1, i);
                }

                //dump(i);
            }

            System.out.println(solve());
        }
    }
}
