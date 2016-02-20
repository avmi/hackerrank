import java.io.*;

public class SubstringDiff {
    public static void main(String[] args) throws IOException {
        StringBuffer sb = new StringBuffer();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (byte T = Byte.parseByte(br.readLine()); T > 0; --T) {
            String[] temp = br.readLine().split(" ");

            short K = Short.parseShort(temp[0]);
            char[] P = temp[1].toCharArray();
            char[] Q = temp[2].toCharArray();

            int L = Integer.max(solve(P, Q, K), solve(Q, P, K));

            sb.append(L + "\n");
        }

        System.out.print(sb);
    }

    private static int solve(char[] a, char[] b, short max) {
        int maxLen = 0;
        int al = a.length;
        int amax = al - max;

        int[] points = new int[al + 2];
        points[0] = -1;

        for (int ia = 0; ia < amax; ++ia) {
            int p = 1;
            int bmax = al - ia;

            for (int ib = 0; ib < bmax; ++ib) {
                if (a[ia + ib] != b[ib]) {
                    points[p++] = ib;
                }
            }
            points[p++] = bmax;

            int offset = Integer.min(max + 1, p - 1);
            for (int ip = offset; ip < p; ++ip) {
                maxLen = Integer.max(maxLen, (points[ip] - points[ip - offset] - 1));
            }

            amax = al - maxLen;
        }

        return maxLen;
    }
}
