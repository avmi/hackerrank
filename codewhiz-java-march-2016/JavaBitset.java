import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Integer N = scan.nextInt();
        Integer M = scan.nextInt();

        BitSet B[] = { new BitSet(N), new BitSet(N), new BitSet(N) };

        for (int i = 0; i < M; i++) {
            String op = scan.next();
            Integer set = scan.nextInt();
            Integer index = scan.nextInt();

            switch (op) {
                case "AND" :
                    B[set].and(B[index]);
                    break;

                case "OR" :
                    B[set].or(B[index]);
                    break;

                case "XOR" :
                    B[set].xor(B[index]);
                    break;

                case "FLIP" :
                    B[set].flip(index);
                    break;

                case "SET" :
                    B[set].set(index);
                    break;
            }

            System.out.format("%d %d\n", B[1].cardinality(), B[2].cardinality());
        }
    }
}