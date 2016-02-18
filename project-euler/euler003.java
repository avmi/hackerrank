import java.io.*;

public class euler003 {
    public static void main(String[] args) throws IOException {
        final int[] primes = getPrimes((int) Math.sqrt(1000000000000L));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final byte T = Byte.parseByte(br.readLine());
        final long[] V = new long[T];
        for (int t = 0; t < T; ++t) {
            final long N = Long.parseLong(br.readLine());
            V[t] = getLargestFactor(N, primes);
        }
        br.close();

        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; ++t) {
            sb.append(V[t]).append("\n");
        }

        System.out.print(sb);
    }

    private static int[] getPrimes(int n) {
        final int halfLen = n >> 1;
        final int halfSqrtN = ((int) Math.sqrt(n)) >> 1;
        final boolean[] isComposite = new boolean[halfLen];

        for (int i = 0; i < halfSqrtN; ++i) {
            if (!isComposite[i]) {
                int prime = (i << 1) + 3;
                for (int j = (i << 1) * (i + 3) + 3; j < halfLen; j += prime) {
                    isComposite[j] = true;
                }
            }
        }

        int c = 1;
        for (int i = 0; i < halfLen; c += (isComposite[i++]) ? 0 : 1) {
        }

        int[] primes = new int[c];
        primes[c = 0] = 2;
        for (int i = 0; i < halfLen; ++i) {
            if (!isComposite[i]) {
                primes[++c] = (i << 1) + 3;
            }
        }

        return primes;
    }

    private static long getLargestFactor(long n, int[] primes) {
        int prime = 0;
        final int pLen = primes.length;

        for (int i = 0; i < pLen && n > 1; ++i) {
            if ((n % primes[i]) == 0) {
                prime = primes[i];
                do {
                    n /= prime;
                } while ((n % prime) == 0);
            }
        }

        return (n > 1) ? n : prime;
    }
}