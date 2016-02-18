import java.util.*;

public class ANDProduct {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int T;
        long A, B;

        T = in.nextInt();
        for (int i = 0; i < T; i++) {
            A = in.nextLong();
            B = in.nextLong();

            long from = A;
            long result = B;
            while (from < B) {
                result &= (from++);
            }

            System.out.println(result);
        }
    }
}
