import java.util.*;

public class BotSavesPrincess2 {
    static void nextMove(int n, int r, int c, String[] grid) {
        int bot[] = {r, c};
        int princess[] = position(grid);

        int upDown = bot[0] - princess[0];
        int leftRight = bot[1] - princess[1];

        if (upDown != 0) System.out.println((upDown < 0) ? "DOWN" : "UP");
        else System.out.println((leftRight > 0) ? "LEFT" : "RIGHT");
    }

    private static int[] position(String[] grid) {
        int j = -1, i = 0;

        for (; i < grid.length; i++) {
            j = grid[i].indexOf('p');
            if (j >= 0) break;
        }

        return new int[]{i, j};
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n, r, c;

        n = in.nextInt();
        r = in.nextInt();
        c = in.nextInt();
        in.useDelimiter("\n");
        String grid[] = new String[n];

        for (int i = 0; i < n; i++) {
            grid[i] = in.next();
        }
        in.close();

        nextMove(n, r, c, grid);

    }
}