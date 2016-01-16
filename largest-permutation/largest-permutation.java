import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String[] inputArr = s.nextLine().split(" ");

        int n = Integer.parseInt(inputArr[0]) ;
        int k = Integer.parseInt(inputArr[1]);
        inputArr = s.nextLine().split(" ");

        int[] input = new int[n];
        for(int j=0; j < n;j++) {
            input[j] = Integer.parseInt(inputArr[j]);
        }

        for(int j=0; j < n; j++) {
            int swapIndex = exist(input[j],j,input);
            if(swapIndex != j) {
                if(k!=0){
                    int temp = input[j];
                    input[j] = input[swapIndex];
                    input[swapIndex]= temp;
                    k--;
                } else {
                    break;
                }
            }
        }

        for(int j=0; j < n; j++) {
            if(j >0) {
                System.out.print(" ");
            }
            System.out.print(input[j]);
        }
    }

    public static int exist(int curr,int index,int[] arr) {
        int output = curr;
        int outputIndex = index;
        for(int i=index+1; i < arr.length;i++){
            if(output < arr[i]){
                output = arr[i];
                outputIndex = i;
            }
        }

        return outputIndex;
    }
}