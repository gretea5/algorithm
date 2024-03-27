import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayDeque;

public class Main {
    private static class Pos {
        int x;
        int y;
        int t;
        boolean gFlag;

        Pos(int x, int y, int t, boolean gFlag) {
            this.x = x;
            this.y = y;
            this.t = t;
            this.gFlag = gFlag;
        }
    }

    private static int N, M, T;

    private static boolean[][][] visited;
    private static int[][] board;

    private static final int[] dx = {0, 0, 1, -1};
    private static final int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        visited = new boolean[N][M][2];
        board = new int[N][M];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = bfs();

        if(answer == -1 || answer > T) {
            System.out.print("Fail");
            return;
        }

        System.out.print(answer);

        br.close();
    }

    private static int bfs() {
        ArrayDeque<Pos> queue = new ArrayDeque<>();

        queue.addLast(new Pos(0, 0, 0, false));
        visited[0][0][0] = true;

        while(!queue.isEmpty()) {
            Pos cur = queue.removeFirst();

            if(cur.x == N - 1 && cur.y == M - 1) {
                return cur.t;
            }

            for(int i = 0; i < 4; i++) {
                int mx = cur.x + dx[i];
                int my = cur.y + dy[i];

                if(mx < 0 || mx >= N || my < 0 || my >= M) continue;

                if(!cur.gFlag) {
                    if(!visited[mx][my][0] && board[mx][my] == 0) {
                        queue.addLast(new Pos(mx, my, cur.t + 1, false));
                        visited[mx][my][0] = true;
                    }
                    else if(!visited[mx][my][0] && board[mx][my] == 2) {
                        queue.addLast(new Pos(mx, my, cur.t + 1, true));
                        visited[mx][my][0] = true;
                    }
                }
                else {
                    if(!visited[mx][my][1]) {
                        queue.addLast(new Pos(mx, my, cur.t + 1, true));
                        visited[mx][my][1] = true;
                    }
                }
            }
        }

        return -1;
    }
}
