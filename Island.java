import java.util.*;

public class Island {

    static class Pair {
        int First;
        int Second;

        public Pair(int First, int Second) {
            this.First = First;
            this.Second = Second;
        }
    }

    public static void BFS(int row, int column, int grid[][], int vis[][]) {
        vis[row][column] = 1;
        Queue<Pair> Q = new LinkedList<>();
        Q.add(new Pair(row, column));

        while (!Q.isEmpty()) {
            int nrow = Q.peek().First;
            int ncolumn = Q.peek().Second;
            Q.poll();

            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    int drow = nrow + i;
                    int dcolumn = ncolumn + j;

                    if (drow >= 0 && drow < 4 && dcolumn >= 0 && dcolumn < 3 &&
                        vis[drow][dcolumn] == 0 && grid[drow][dcolumn] == 1) {
                        Q.add(new Pair(drow, dcolumn));
                        vis[drow][dcolumn] = 1;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        int n = 4, m = 3, Count = 0;
        int grid[][] = {
            {1, 1, 0},
            {1, 0, 0},
            {0, 0, 1},
            {0, 1, 1}
        };
        int vis[][] = new int[4][3];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (vis[i][j] == 0 && grid[i][j] == 1) {
                    Count++;
                    BFS(i, j, grid, vis);
                }
            }
        }

        System.out.println("Number of islands: " + Count);
    }
}
