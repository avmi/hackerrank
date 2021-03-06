import java.util.*;

public class MarkAndToys {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int len = scan.nextInt();
        int target = scan.nextInt();

        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = scan.nextInt();
        }

        Arrays.sort(arr);

        int sum = 0;
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (sum <= target) {
                sum += arr[i];
                count++;
            }
        }

        System.out.println(count - 1);
    }
}
