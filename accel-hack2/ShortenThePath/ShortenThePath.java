import java.util.*;

public class ShortenThePath {
    public static void main(String[] args) {
        int T;
        String s;

        Scanner scan = new Scanner(System.in);
        s = scan.nextLine();

        int len = s.length();
        int x = 0;
        int y = 0;

        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);

            if (ch == 'E') x++;
            else if (ch == 'W') x--;
            else if (ch == 'N') y++;
            else if (ch == 'S') y--;
        }

        String result = "";
        for (int i = 0; i < Math.abs(x); i++) {
            if (x < 0) result += "W";
            else result += "E";
        }

        for (int i = 0; i < Math.abs(y); i++) {
            if (y < 0) result += "S";
            else result += "N";
        }

        char chars[] = result.toCharArray();
        Arrays.sort(chars);
        result = new String(chars);

        System.out.println(result);
    }
}
