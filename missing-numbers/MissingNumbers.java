import java.io.*;
import java.util.*;

public class MissingNumbers {
    private static int R = 100;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] C = new int[2 * R];

        int N = Integer.parseInt(br.readLine());
        String[] temp = br.readLine().split(" ");
        int offset = Integer.parseInt(temp[0]) - R;
        for(int i = 0; i < N; i++){
            short v = Short.parseShort(temp[i]);
            C[v - offset]--;
        }

        int M = Integer.parseInt(br.readLine());
        temp = br.readLine().split(" ");
        for(int i = 0; i < M; i++){
            short v = Short.parseShort(temp[i]);
            C[v - offset]++;
        }

        StringBuffer str = new StringBuffer();
        for(int i = 0; i < C.length; i++){
            if (C[i] != 0){
                str.append((i + offset) + " ");
            }
        }

        System.out.print(str);
    }
}
