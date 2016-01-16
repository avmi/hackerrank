import java.util.*;

public class ManasaAndPrimeGame {
    public static void main(String[] args) {
        int t = nextInt();
        for(int i=0; i<t; i++){
            System.out.println(solve());
        }
    }

    public static int[] values = new int[]{0, 0, 1, 1, 2, 2, 3, 3, 4};

    public static String solve() {
        int n = nextInt();
        long ak;
        long num = 0;

        for (int i=0; i<n; i++) {
            ak = nextLong();
            num ^= values[(int) (ak % values.length)];
        }

        if(num > 0) return "Manasa";

        return "Sandy";
    }

    public static Scanner sc = new Scanner(System.in);

    public static int nextInt() {
        return sc.nextInt();
    }

    public static long nextLong() {
        return sc.nextLong();
    }
}
