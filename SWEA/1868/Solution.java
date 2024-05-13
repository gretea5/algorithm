import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Solution {
    private static int n;

    private static char[][] board;
    private static int[][] cntBoard;
    private static boolean[][] visited;

    private static final int[] dx = {1, -1, 0, 0, 1, -1, -1, 1};
    private static final int[] dy = {0, 0, 1, -1, 1, -1, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for(int test = 1; test <= t; test++) {
            n = Integer.parseInt(br.readLine());

            board = new char[n][n];
            cntBoard = new int[n][n];
            visited = new boolean[n][n];

            for(int i = 0; i < n; i++) {
                String s = br.readLine();

                for(int j = 0; j < n; j++) {
                    board[i][j] = s.charAt(j);
                }
            }

            //지뢰가 아닌 부분에 지뢰의 갯수를 기록
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    if (board[i][j] != '*') {
                        cntBoard[i][j] = cntMine(i, j);
                    }
                }
            }

            //클릭 횟수
            int answer = 0;

            //dfs로 0으로 인접한 부분을 모두 방문처리한다.
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    if (!visited[i][j] && cntBoard[i][j] == 0 && board[i][j] != '*') {
                        dfs(i, j);
                        answer += 1;
                    }
                }
            }

            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    if (!visited[i][j] && board[i][j] != '*' && cntBoard[i][j] > 0) {
                        visited[i][j] = true;
                        answer += 1;
                    }
                }
            }

            sb.append("#").append(test).append(" ");
            sb.append(answer).append("\n");
        }

        System.out.print(sb);

        br.close();
    }

    private static void dfs(int x, int y) {
        visited[x][y] = true;

        for(int i = 0; i < 8; i++) {
            int mx = x + dx[i];
            int my = y + dy[i];

            if (mx < 0 || mx >= n || my < 0 || my >= n) {
                continue;
            }

            //인접한 칸에서 지뢰가 있을 경우, 체크만 해준다.
            if (!visited[mx][my] && cntBoard[mx][my] > 0 && board[mx][my] != '*') {
                visited[mx][my] = true;
                continue;
            }

            //인접한 칸이 지뢰가 없을 경우, dfs 순회
            if (!visited[mx][my] && cntBoard[mx][my] == 0 && board[mx][my] != '*') {
                dfs(mx, my);
            }
        }
    }

    private static int cntMine(int x, int y) {
        int cnt = 0;

        for(int i = 0; i < 8; i++) {
            int mx = x + dx[i];
            int my = y + dy[i];

            if (mx < 0 || mx >= n || my < 0 || my >= n) {
                continue;
            }

            if (board[mx][my] == '*') {
                cnt += 1;
            }
        }

        return cnt;
    }
}
