import java.util.*;

public class TheGreatestInteger {
    public static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        String s;

        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();

        int v = scan.nextInt();
        int max = v;
        int g = v;

        for (int i = 1; i < N; i++) {
            v = scan.nextInt();
            g = gcd(g, v);
            max = Math.max(max, v);
        }

        int M = scan.nextInt();
        int result = max - g * (M - 1);

        System.out.println(result);
    }
}
