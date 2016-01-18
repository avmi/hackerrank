import java.util.*;

public class SansaAndXor {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int cases = 0;
        if (sc.hasNext()) {
            cases = sc.nextInt();
        }

        while (cases-- > 0) {
            int n = 0;
            if (sc.hasNext()) {
                n = sc.nextInt();
            }

            int[] array = new int[n];
            for (int i = 0; i < n; i++) {
                if (sc.hasNext()) {
                    array[i] = sc.nextInt();
                }
            }

            if (n == 1) {
                System.out.println(array[0]);
                continue;
            }

            if (n % 2 == 0) {
                System.out.println("0");
            }
            else {
                int result = 0;

                for (int i = 0; i < n; i = i + 2) {
                    result ^= array[i];
                }

                System.out.println(result);
            }
        }
    }
}
