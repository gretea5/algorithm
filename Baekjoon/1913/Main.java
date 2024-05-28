import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    private static int n;
    private static int k;
    private static int r;
    private static int c;

    private static int[][] board;
    private static boolean[][] visited;

    private static final int[] dx = {1, 0, -1, 0};
    private static final int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());

        board = new int[n][n];
        visited = new boolean[n][n];

        r = -1;
        c = -1;

        dfs(0, 0, n * n, 0);

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                sb.append(board[i][j]).append(" ");
            }
            sb.append("\n");
        }

        sb.append(r).append(" ").append(c);

        System.out.print(sb);

        br.close();
    }

    private static void dfs(int x, int y, int num, int dir) {
        board[x][y] = num;
        visited[x][y] = true;

        if (num == k) {
            r = x + 1;
            c = y + 1;
        }

        if (num == 1) {
            return;
        }

        int mx = x + dx[dir];
        int my = y + dy[dir];

        if (mx < 0 || mx >= n || my < 0 || my >= n || visited[mx][my]) {
            dir = (dir + 1) % 4;

            mx = x + dx[dir];
            my = y + dy[dir];
        }

        dfs(mx, my, num - 1, dir);
    }
}
