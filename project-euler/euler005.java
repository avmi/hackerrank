import java.io.*;

public class euler005 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final byte T = Byte.parseByte(br.readLine());
        final byte[] Ns = new byte[T];
        for (byte t = 0; t < T; Ns[t++] = Byte.parseByte(br.readLine())) {
        }
        br.close();

        int[] primes = getPrimes(40);
        byte numPrimes = (byte) primes.length;
        double[] primeLogs = new double[numPrimes];
        for (byte p = 0; p < numPrimes; ++p) {
            primeLogs[p] = Math.log(primes[p]);
        }

        long[] Vs = new long[T];

        for (byte t = 0; t < T; ++t) {
            long v = 1L;
            final byte N = Ns[t];
            final double logN = Math.log(N);

            for (byte p = 0; p < numPrimes && primes[p] <= N; ++p) {
                v *= Math.pow(primes[p], (int) (logN / primeLogs[p]));
            }

            Vs[t] = v;
        }

        StringBuilder sb = new StringBuilder();
        for (byte t = 0; t < T; sb.append(Vs[t++]).append("\n")) {
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
}