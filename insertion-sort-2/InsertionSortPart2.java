import java.io.*;
import java.util.*;

public class Solution {

    public static void sort(int[] arr, int s) {
        for (int i = 0; i < s - 1; i++) {
            int j = i + 1;
            while (j > 0) {
                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j];

                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                    j--;
                }
                else {
                    break;
                }
            }

            print(arr);
        }
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        int[] ar = new int[s];
        for (int i = 0; i < s; i++) {
            ar[i] = in.nextInt();
        }

        sort(ar, s);
    }

    private static void print(int[] arr) {
        for (int n : arr) {
            System.out.print(n + " ");
        }
        System.out.println("");
    }
}