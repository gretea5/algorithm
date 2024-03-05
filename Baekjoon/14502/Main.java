import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    private static int N, M;
    private static int answer;

    private static int[][] board;
    private static boolean[][] visited;

    private static final int[] dx = {1, -1, 0, 0};
    private static final int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][M];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        answer = Integer.MIN_VALUE;

        for(int i = 0; i < N * M; i++) {
            for(int j = i + 1; j < N * M; j++) {
                for(int k = j + 1; k < N * M; k++) {
                    if(board[i % N][i / N] == 0 && board[j % N][j / N] == 0 && board[k % N][k / N] == 0) {
                        board[i % N][i / N] = 1;
                        board[j % N][j / N] = 1;
                        board[k % N][k / N] = 1;
                        spreadVirus();
                        board[i % N][i / N] = 0;
                        board[j % N][j / N] = 0;
                        board[k % N][k / N] = 0;
                    }
                }
            }
        }

        System.out.print(answer);

        br.close();
    }

    private static void spreadVirus() {
        visited = new boolean[N][M];

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(!visited[i][j] && board[i][j] == 2) {
                    dfs(i, j);
                }
            }
        }

        answer = Math.max(answer, calSafeArea());
    }

    private static void dfs(int x, int y) {
        visited[x][y] = true;

        for(int i = 0; i < 4; i++) {
            int mx = x + dx[i];
            int my = y + dy[i];

            if(mx < 0 || mx >= N || my < 0 || my >= M) continue;

            if(!visited[mx][my] && board[mx][my] == 0) {
                dfs(mx, my);
            }
        }
    }

    private static int calSafeArea() {
        int cnt = 0;

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(!visited[i][j] && board[i][j] == 0) cnt += 1;
            }
        }

        return cnt;
    }
}
