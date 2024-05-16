import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Solution {
    private static class Pos {
        int x;
        int y;

        Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static int cnt;
    private static final int SIZE = 300;

    private static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        board = new int[SIZE][SIZE];

        cnt = 1;

        for(int i = 1; i < SIZE; i++) {
            dfs(1, i);
        }

        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for(int test = 1; test <= t; test++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());

            Pos pPos = find(p);
            Pos qPos = find(q);

            int mx = pPos.x + qPos.x;
            int my = pPos.y + qPos.y;

            sb.append("#").append(test).append(" ");
            sb.append(board[mx][my]).append("\n");
        }

        System.out.print(sb);

        br.close();
    }

    private static void dfs(int x, int y) {
        board[x][y] = cnt;

        int mx = x + 1;
        int my = y - 1;

        if (mx < 0 || mx >= SIZE || my < 0 || my >= SIZE) {
            return;
        }

        cnt += 1;

        dfs(mx, my);
    }

    private static Pos find(int x) {
        for(int i = 1; i < SIZE; i++) {
            for(int j = 1; j < SIZE; j++) {
                if (x == board[i][j]) {
                    return new Pos(i, j);
                }
            }
        }

        return new Pos(-1, -1);
    }
}
