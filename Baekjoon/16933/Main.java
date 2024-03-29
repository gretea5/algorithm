import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayDeque;

public class Main {
    private static class Pos {
        int x;
        int y;
        int dist;
        int wall;
        boolean isSun;

        Pos(int x, int y, int dist, int wall, boolean isSun) {
            this.x = x;
            this.y = y;
            this.dist = dist;
            this.wall = wall;
            this.isSun = isSun;
        }
    }

    private static boolean[][][] visited;
    private static int[][] board;

    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};

    private static int N, M, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        visited = new boolean[N][M][K + 1];
        board = new int[N][M];

        for(int i = 0; i < N; i++) {
            String s = br.readLine();

            for(int j = 0; j < M; j++) {
                board[i][j] = s.charAt(j) - '0';
            }
        }

        System.out.print(bfs());

        br.close();
    }

    private static int bfs() {
        ArrayDeque<Pos> queue = new ArrayDeque<>();

        queue.addLast(new Pos(0, 0, 1, 0, true));
        visited[0][0][0] = true;

        while(!queue.isEmpty()) {
            Pos cur = queue.removeFirst();

            if(cur.x == N - 1 && cur.y == M - 1) {
                return cur.dist;
            }

            for(int i = 0; i < 4; i++) {
                int mx = cur.x + dx[i];
                int my = cur.y + dy[i];

                if (mx < 0 || mx >= N || my < 0 || my >= M) continue;
                //벽일 경우,
                if (board[mx][my] == 1) {
                    if (!cur.isSun && cur.wall < K) {
                        queue.addLast(new Pos(cur.x, cur.y, cur.dist + 1, cur.wall, true));
                    }
                    //낮이면서 벽을 부술 수 있으면서 방문이 가능할 경우,
                    else if (cur.isSun && cur.wall < K && !visited[mx][my][cur.wall + 1]) {
                        queue.addLast(new Pos(mx, my, cur.dist + 1, cur.wall + 1,  false));
                        visited[mx][my][cur.wall + 1] = true;
                    }
                }
                //벽이 아닐 경우,
                else {
                    if (!visited[mx][my][cur.wall]) {
                        queue.addLast(new Pos(mx, my, cur.dist + 1, cur.wall, !cur.isSun));
                        visited[mx][my][cur.wall] = true;
                    }
                }
            }
        }

        return -1;
    }
}
