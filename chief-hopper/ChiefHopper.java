import java.util.*;

public class ChiefHopper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int[] H = new int[n];
        for (int i = 0; i < n; i++) {
            H[i] = scanner.nextInt();
        }

        long e = 0;
        for (int i = H.length - 1; i >= 0; i--) {
            e = (H[i] + e) / 2 + (H[i] + e) % 2;
        }

        System.out.println(e);
    }
}
