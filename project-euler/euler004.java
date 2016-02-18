import java.util.*;

public class euler004 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testCases = in.nextInt();

        for (int i = 0; i < testCases; i++) {
            int test = in.nextInt();
            solve(test);
        }
    }

    public static void solve(int num) {
        List<Integer> list = new ArrayList<Integer>();

        int sum = 0;
        int reverse = 0;

        for (int i = 100; i <= 999; i++) {
            for (int j = 100; j <= 999; j++) {
                sum = i * j;
                if (sum >= 100000 && sum < num) {
                    reverse = reverse(sum);
                    if (sum == reverse) {
                        list.add(sum);
                    }
                }
            }
        }

        Collections.sort(list);

        System.out.println(list.get(list.size() - 1));
    }

    public static int reverse(int num) {
        int n = num;
        int rev = 0;

        while (n != 0) {
            rev = rev * 10;
            rev = rev + n % 10;
            n = n / 10;
        }

        return rev;
    }
}