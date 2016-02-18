import java.util.*;

public class euler002 {
    public static class Fib {
        public long number;
        public boolean isEven;

        public Fib(long number, boolean isEven) {
            this.number = number;
            this.isEven = isEven;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Fib[] fibs = new Fib[81];
        fibs[1] = new Fib(1, false);
        fibs[2] = new Fib(2, true);
        int i = 3;
        int j = 1;
        while (i <= 80) {
            fibs[i] = new Fib(
                    fibs[i - 1].number + fibs[i - 2].number,
                    j % 3 == 0 ? true : false
            );
            i += 1;
            j += 1;
        }

        long[] evenFibs = new long[27];
        i = 1;
        j = 0;
        while (i < fibs.length) {
            if (fibs[i].isEven == true) {
                evenFibs[j] = fibs[i].number;
                j += 1;
            }
            i += 1;
        }

        int t = scanner.nextInt();

        for (int k = 0; k < t; k++) {
            long n = scanner.nextLong();
            long sum = 0;
            i = 0;
            while (i < evenFibs.length && evenFibs[i] < n) {
                sum += evenFibs[i];
                i += 1;
            }

            System.out.println(sum);
        }
    }
}