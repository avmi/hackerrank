import java.io.*;
import java.util.*;

public class PriyankaAndToys {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());
        final short[] W = toShortArray(br.readLine().split(" "), N);
        br.close();

        Arrays.sort(W);

        short units = 0;
        for (int i = 0; i < N; ++units) {
            final short maxW = (short) (W[i] + 4);
            while (++i < N && W[i] <= maxW) {
            }
        }

        System.out.print(units);
    }

    private static short[] toShortArray(final String[] A, final int N) {
        short[] B = new short[N];
        for (int i = 0; i < N; ++i) {
            B[i] = Short.parseShort(A[i]);
        }
        return B;
    }
}