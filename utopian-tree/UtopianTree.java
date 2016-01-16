import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class UtopianTree {

    public static int solve(int T, boolean first, int size) {
        if (T==0) {
            return size;
        }

        if (!first) {
            return solve(T - 1, true, size + 1);
        }
        else {
            return solve(T - 1, false, size * 2);
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inp;
        int cases = Integer.parseInt(inp = br.readLine());

        for(int i=0; i < cases; i++) {
            int year = Integer.parseInt(inp = br.readLine());
            int sol = solve(year,true, 1);
            System.out.println(sol);
        }
    }
}