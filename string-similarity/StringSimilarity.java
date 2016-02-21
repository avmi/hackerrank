import java.util.*;

public class StringSimilarity {

    static long stringSimilarity(String a) {

        long sum = a.length();

        int[] z = calc(a);
        for (int i = 1; i < a.length(); i++) {
            sum = sum + z[i];
        }

        return sum;
    }

    static int[] calc(String text) {
        int len = text.length();
        int[] res = new int[len];

        int L = 0, R = 0;
        for (int i = 1; i < len; i++) {
            if (i > R) {
                L = R = i;

                while (R < len && text.charAt(R - L) == text.charAt(R)) {
                    R++;
                }

                res[i] = --R - L + 1;
            } else {
                int k = i - L;

                if (res[k] < R - i + 1) {
                    res[i] = res[k];
                } else {
                    L = i;

                    while (R < len && text.charAt(R - L) == text.charAt(R)) {
                        R++;
                    }

                    res[i] = --R - L + 1;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int T = Integer.parseInt(in.nextLine());

        for (int i = 0; i < T; i++) {
            String _a = in.nextLine();

            long res = stringSimilarity(_a);

            System.out.println(res);
        }
    }
}