import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    private static int[][] board;
    private static int[][] dp;

    private static int M, N;

    private static final int[] dx = {1, -1, 0, 0};
    private static final int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        board = new int[M][N];
        dp = new int[M][N];

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < N; j++) {
                //지점 높이 입력
                board[i][j] = Integer.parseInt(st.nextToken());
                //-1로 초기화
                dp[i][j] = -1;
            }
        }

        //(0, 0)에서 시작했을때 출력
        System.out.print(dfs(0, 0));

        br.close();
    }

    private static int dfs(int x, int y) {
        //도착지에 왔을 경우 한가지 리턴
        if(x == M - 1 && y == N - 1) {
            return 1;
        }

        //도착지에서 x, y로 가는 경우의 수가 기록이 되어 있다면,
        if(dp[x][y] != -1) {
            return dp[x][y];
        }

        //현재 경로에서 가는 경우의 수를 초기화
        dp[x][y] = 0;

        for(int i = 0; i < 4; i++) {
            int mx = x + dx[i];
            int my = y + dy[i];

            //범위에서 벗어날 경우,
            if(mx < 0 || mx >= M || my < 0 || my >= N) continue;

            if(board[x][y] > board[mx][my]) {
                //이전에서 가는 경로의 수에서 모두를 더해 현재로 갈 수 있는 경로의 수를 구한다.
                dp[x][y] += dfs(mx, my);
            }
        }

        return dp[x][y];
    }
}
