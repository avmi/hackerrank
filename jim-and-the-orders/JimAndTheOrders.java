import java.io.*;
import java.util.*;

public class JimAndTheOrders {
    public static void main(String[] args) throws IOException {
        StringBuffer sb = new StringBuffer();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final short N = Short.parseShort(br.readLine());
        final Node[] nodes = new Node[N];

        for (short i = 0; i < N; ++i) {
            final String[] input = br.readLine().split(" ");
            final int T = Integer.parseInt(input[0]);
            final int D = Integer.parseInt(input[1]);
            nodes[i] = new Node(i + 1, T + D);
        }

        Arrays.sort(nodes, new Comparator<Node>() {
            public int compare(Node a, Node b) {
                return (a.data < b.data) ? -1 :
                        (a.data > b.data) ? 1 :
                                (a.id < b.id) ? -1 : 1;
            }
        });

        for (int i = 0; i < N; ++i) {
            sb.append(nodes[i].id).append(" ");
        }

        System.out.print(sb);
    }

    public static class Node {
        final public int id;
        final public int data;

        public Node(final int id, final int data) {
            this.id = id;
            this.data = data;
        }
    }
}