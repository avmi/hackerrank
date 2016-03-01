import java.util.*;

public class LisaWorkbook {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int k = scan.nextInt();

        int t[] = new int[n];
        for (int i = 0; i < n; i++) {
            t[i] = scan.nextInt();
        }

        int count = 0;
        int ofs = 0;
        for (int i = 0; i < n; i++) {
            int p = (int) Math.ceil((double)t[i] / k);

            for (int j = 0; j < p; j++) {

                int ps = (j * k) + 1;
                int pe = ps + k - 1;
                int cur = (i + j + 1) + ofs;

                if ((t[i] >= cur) && ((cur == (i + 1)) || ((cur >= ps) && (cur <= pe)))) {
                    count++;
                }
            }

            ofs += p - 1;
        }

        System.out.println(count);

    }
}
