import java.util.*;

public class LonelyInteger {
    private static int SIZE = 101;

    static int get(int[] a) {
        int N = a.length;
        int[] C = new int[SIZE];

        for (int i = 0; i < N; C[a[i++]]++) {

        }

        for (int i = 0; i < SIZE; i++) {
            if (C[i] == 1) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int res;
        int size = Integer.parseInt(in.nextLine());
        int[] buf = new int[size];
        int item;
        String next = in.nextLine();
        String[] next_split = next.split(" ");

        for(int i = 0; i < size; i++) {
            item = Integer.parseInt(next_split[i]);
            buf[i] = item;
        }

        res = get(buf);

        System.out.println(res);
    }
}