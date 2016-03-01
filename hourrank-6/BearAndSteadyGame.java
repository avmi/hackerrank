import java.util.*;

public class BearAndSteadyGame {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        String str = scan.next();

        int result = n;
        int S = 0;
        int map[] = new int[26];

        while (S < n) {
            int index = str.charAt(S) - 'A';

            map[index]++;

            if (map[index] > n / 4) {
                map[index]--;
                S--;
                break;
            }

            S++;
        }

        if (S == n) {
            result = 0;
        }
        else {
            result = Math.min(result, n - S - 1);

            int E = n - 1;
            while (S >= 0) {
                map[str.charAt(S) - 'A']--;
                S--;

                while (E >= 0) {
                    int edIndex = str.charAt(E) - 'A';

                    map[edIndex]++;
                    E--;

                    if (map[str.charAt(E + 1) - 'A'] > n / 4) {
                        map[str.charAt(++E) - 'A']--;
                        break;
                    }
                }

                result = Math.min(result, E - S);
            }
        }

        System.out.println(result);
    }
}
