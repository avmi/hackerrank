import java.util.*;

public class FibonacciLite {
    public static void solve(Long n) {
        if ((n == 0) || (n == 1)) {
            System.out.println(n);
        } else {
            Long prev = 0L;
            Long current = 1L;

            for (int i = 0; i < n; i++) {
                current = current + prev;
                prev = current - prev;
            }

            System.out.println(prev);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        solve(in.nextLong());
    }
}
