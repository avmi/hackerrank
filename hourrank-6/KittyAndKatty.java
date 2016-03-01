import java.util.*;

public class KittyAndKatty {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();

        while (T > 0) {
            int n = scan.nextInt();

            System.out.println(((n == 1) || (n % 2 == 0)) ? "Kitty" : "Katty");

            T--;
        }
    }
}
