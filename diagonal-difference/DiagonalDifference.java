import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class DiagonalDifference {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int len = in.nextInt();
        int sum1 = 0;
        int sum2 = 0;
        for(int i = 0; i < len; i++){
            for(int j = 0; j < len; j++){
                int num = in.nextInt();

                if (i == j){
                    sum1 += num;
                }
                if(i + j == len-1){
                    sum2 += num;
                }
            }
        }

        System.out.print(Math.abs(sum1 - sum2));
    }
}
