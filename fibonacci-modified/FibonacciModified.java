import java.util.*;
import java.math.*;

public class FibonacciModified {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<BigInteger> fib = new ArrayList<BigInteger>();

        BigInteger A = BigInteger.valueOf(Integer.valueOf(scanner.nextInt()).longValue());
        BigInteger B = BigInteger.valueOf(Integer.valueOf(scanner.nextInt()).longValue());

        fib.add(A);
        fib.add(B);

        int N = scanner.nextInt();
        for (int i = 2; i < N; i++) {
            fib.add((fib.get(i - 1).multiply(fib.get(i - 1))).add(fib.get(i - 2)));
        }

        System.out.println(fib.get(N - 1).toString());
    }
}