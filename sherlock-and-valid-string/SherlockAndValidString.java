import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

// TODO test cases #11 and #12 failed

class IntComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer v1, Integer v2) {
        return v1 < v2 ? -1 : v1 > v2 ? -1 : 0;
    }
}

public class SherlockAndValidString {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String in = reader.readLine();

        solve(1, in);
    }

    public static <T extends Comparable<T>> void qsort(T[] arr, Comparator<T> cmp, int a, int b) {
        if (a < b) {
            int i = a, j = b;
            T x = arr[(i + j) / 2];

            do {
                while (cmp.compare(arr[i], x) < 0) i++;
                while (cmp.compare(x, arr[j]) < 0) j--;

                if ( i <= j) {
                    T tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                    i++;
                    j--;
                }

            } while (i <= j);

            qsort(arr, cmp, a, j);
            qsort(arr, cmp, i, b);
        }
    }

    private static void solve(int testNumber, String in) {
        char[] c = in.toCharArray();
        int[] count = new int[26];
        int maxRepetitions = 0;
        int maxKey = 0;

        for (int i = 0; i < c.length; ++i) {
            count[c[i] - 'a']++;
        }

        boolean flag = false;
        for (int i = -1; i < 26; ++i) {
            if ((i == -1) || (count[i] != 0)) {
                Integer[] cnt = new Integer[26];
                for (int z = 0; z < count.length; z++) {
                    cnt[z] = count[z];
                }
                if (i >= 0) cnt[i] --;

                SherlockAndValidString.<Integer>qsort(cnt, new IntComparator(), 0, cnt.length-1);

                boolean ok = true;
                for (int j = 0; j < 26; ++j) {
                    if (cnt[j] != 0) {
                        ok &= cnt[j] == cnt[0];
                    }
                }

                if (ok) {
                    flag = true;
                }
            }
        }

        if (flag) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
