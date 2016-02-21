import java.util.*;

public class ChocolateFeast {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();

        for (int i = 0; i < T; i++) {
            int n = in.nextInt();
            int c = in.nextInt();
            int m = in.nextInt();

            int num = n / c;
            int w = num;

            while (w / m > 0) {
                int more = w / m;

                num = num + more;
                w = w % m + more;
            }

            System.out.println(num);
        }

    }
}