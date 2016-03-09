import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        ArrayList<Integer> L = new ArrayList<Integer>(N);

        for (int i = 0; i < N; i++) {
            L.add(i, scan.nextInt());
        }

        int Q = scan.nextInt();

        for (int i = 0; i < Q; i++) {
            String op = scan.next();
            if (scan.hasNextLine()) scan.nextLine();
            int x = scan.nextInt();

            if (op.startsWith("Insert")) {
                int y = scan.nextInt();
                L.add(x, y);
            }
            else if (op.startsWith("Delete")) {
                L.remove(x);
            }
            if (scan.hasNextLine()) scan.nextLine();
        }

        for (int i = 0; i < L.size(); i++) {
            if (i > 0) System.out.print(" ");
            System.out.print(L.get(i));
        }
    }
}
