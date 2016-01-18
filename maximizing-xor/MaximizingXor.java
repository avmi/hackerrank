import java.io.*;

public class MaximizingXor {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        short L = Short.parseShort(br.readLine());
        short R = Short.parseShort(br.readLine());
        short max = 0;

        while (L != R) {
            L >>= 1;
            R >>= 1;
            max = (short)((max << 1) + 1);
        }

        System.out.print(max);
    }
}
