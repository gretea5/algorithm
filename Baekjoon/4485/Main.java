import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    private static class Info {
        int x;
        int y;
        int distance;

        Info(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }

    private static int N;

    private static int[][] board;
    private static int[][] dp;

    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int idx = 1;

        StringBuilder sb = new StringBuilder();

        while(true) {
            N = Integer.parseInt(br.readLine());

            if (N == 0) break;

            board = new int[N][N];
            dp = new int[N][N];

            for(int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                for(int j = 0; j < N; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                    dp[i][j] = Integer.MAX_VALUE;
                }
            }

            bfs(0, 0);

            sb.append("Problem ").append(idx).append(": ").append(dp[N - 1][N - 1]).append("\n");

            idx += 1;
        }

        System.out.print(sb);

        br.close();
    }

    private static void bfs(int x, int y) {
        PriorityQueue<Info> pq = new PriorityQueue<>((i1, i2) -> { return i1.distance - i2.distance; });

        dp[x][y] = board[x][y];
        pq.add(new Info(x, y, board[x][y]));

        while(!pq.isEmpty()) {
            Info cur = pq.remove();

            if(dp[cur.x][cur.y] < cur.distance) continue;

            for(int i = 0; i < 4; i++) {
                int mx = cur.x + dx[i];
                int my = cur.y + dy[i];

                if(mx < 0 || mx >= N || my < 0 || my >= N) continue;

                if(dp[mx][my] > cur.distance + board[mx][my]) {
                    dp[mx][my] = cur.distance + board[mx][my];
                    pq.add(new Info(mx, my, dp[mx][my]));
                }
            }
        }
    }
}
