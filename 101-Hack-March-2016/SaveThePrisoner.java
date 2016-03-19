import java.util.*;

public class SaveThePrisoner {
    public static int warn(int n, int m, int s) {
        int res = (s + m - 1) % n;
        if (res == 0) return n;
        else return res;
    }

    public static void main(String[] args) {
        int T;

        Scanner scan = new Scanner(System.in);
        T = scan.nextInt();

        for (int i = 0; i < T; i++) {
            int n = scan.nextInt();
            int m = scan.nextInt();
            int s = scan.nextInt();

            System.out.println(warn(n, m, s));
        }
    }
}
