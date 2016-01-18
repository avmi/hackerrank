import java.io.*;
import java.util.*;

public class ClosestNumbers {

    private static long[] get(String elements, int size) {

        String[] arr = elements.trim().split(" ");

        long[] numbers = new long[size];
        int index = 0;

        for (String el : arr) {
            numbers[index++] = Long.parseLong(el);
        }
        return numbers;
    }

    private static long diff(long[] array, int start, int end) {

        if (start == end)
            return Long.MAX_VALUE;
        else if (end - start == 1)
            return (array[end] - array[start]);

        int mid = (start + end) / 2;

        long leftDiff = Math.abs(diff(array, start, mid));
        long rightDiff = Math.abs(diff(array, mid + 1, end));
        long diffMid = Math.abs(array[mid + 1] - array[mid]);

        return Math.min(diffMid, Math.min(leftDiff, rightDiff));
    }

    private static void print(long[] array, int arraySz) {

        long minDiff = diff(array, 0, arraySz - 1);

        for (int i = 0; i < arraySz - 1; i++) {
            if (Math.abs(array[i + 1] - array[i]) == minDiff) {
                System.out.print(array[i] + " " + array[i + 1] + " ");
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        int listSize = Integer.parseInt(input.readLine());
        long[] list = get(input.readLine(), listSize);

        Arrays.sort(list);

        print(list, listSize);

        input.close();
    }
}