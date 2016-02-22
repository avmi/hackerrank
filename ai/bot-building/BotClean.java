import java.util.*;

public class BotClean {
    static void move(int posr, int posc, String[] board) {
        /*
         * 1. we have bot position
         * 2. if at a dirty location : clean it
         * 3. else check for nearest dirty spot
         * 4. move on the direction
         */
        int bot[] = {posr, posc};

        if (board[posr].charAt(posc) == 'd') {
            System.out.println("CLEAN");
        }
        else {
            int dirtySpot[] = nearest(bot, board);
            int upDown = bot[0] - dirtySpot[0];
            int leftRight = bot[1] - dirtySpot[1];

            if (leftRight != 0) System.out.println((leftRight > 0) ? "LEFT" : "RIGHT");
            else System.out.println((upDown < 0) ? "DOWN" : "UP");

        }
    }

    private static int[] nearest(int[] bot, String[] board) {
        /*
		 * 1. We know : board is 5*5 constant
		 * 2. can compute nearest by brute force in constant time
		 * ----
		 * 1. compute distance of all the remaining dirty spot
		 * 2. sort it
		 * 3. return the location
		 */
        int r, c;
        int listWithDist[][] = new int[25][3];
        int i = 0;
        
        for (r = 0; r < 5; r++) {
            for (c = 0; c < 5; c++) {
                if (board[r].charAt(c) == 'd') {
                    listWithDist[i][0] = getDistance(bot, r, c);
                    listWithDist[i][1] = r;
                    listWithDist[i][2] = c;
                    ++i;
                }
            }
        }

        Arrays.sort(listWithDist, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        for (i = 0; i < 25; i++) {
            if (listWithDist[i][0] == 0) continue;
            else break;
        }

        return new int[]{listWithDist[i][1], listWithDist[i][2]};
    }

    private static int getDistance(int[] bot, int r, int c) {
        return Math.abs(r - bot[0]) + Math.abs(c - bot[1]);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] pos = new int[2];
        String board[] = new String[5];

        for (int i = 0; i < 2; i++) pos[i] = in.nextInt();
        for (int i = 0; i < 5; i++) board[i] = in.next();

        in.close();

        move(pos[0], pos[1], board);
    }
}
