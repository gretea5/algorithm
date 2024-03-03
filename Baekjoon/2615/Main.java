import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    private static int[][] board;
    private static boolean[][][] visited;

    private static final int[] dx = {0, 0, 1, 1, 1, -1, -1, -1};
    private static final int[] dy = {1, -1, 0, 1, -1, 0, 1, -1};

    private static int cnt;
    private static final int MAX_SIZE = 19;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        board = new int[MAX_SIZE][MAX_SIZE];

        //각 방향에 대한 방문 처리 배열이 없다면, 방문 처리가 중복으로 되어 셀 수 없는 경우가 생김
        visited = new boolean[MAX_SIZE][MAX_SIZE][8];

        for(int i = 0; i < MAX_SIZE; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            for(int j = 0; j < MAX_SIZE; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        cnt = 1;
        int winner = 0;
        int x = 0;
        int y = 0;

        for(int i = 0; i < MAX_SIZE; i++) {
            for(int j = 0; j < MAX_SIZE; j++) {
                for(int k = 0; k < 8; k++) {
                    if(!visited[j][i][k] && board[j][i] != 0) {
                        dfs(j, i, k, board[j][i]);
                        if(cnt == 5) {
                            winner = board[j][i];
                            x = j + 1;
                            y = i + 1;
                        }
                        cnt = 1;
                    }
                }
            }
        }

        if(winner != 0) {
            System.out.println(winner);
            System.out.print(x + " "+ y);
            return;
        }

        System.out.print(winner);

        br.close();
    }

    private static void dfs(int x, int y, int dir, int target) {
        visited[x][y][dir] = true;

        int mx = x + dx[dir];
        int my = y + dy[dir];

        if(mx < 0 || mx >= MAX_SIZE || my < 0 || my >= MAX_SIZE) return;

        if(!visited[mx][my][dir] && board[mx][my] == target) {
            dfs(mx, my, dir, target);
            cnt += 1;
        }
    }
}
