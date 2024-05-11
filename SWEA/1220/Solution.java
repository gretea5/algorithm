import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Solution {
    private static int n;
    private static int answer;

    private static int[][] board;
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = 10;

        StringBuilder sb = new StringBuilder();

        for(int test = 1; test <= t; test++) {
            n = Integer.parseInt(br.readLine());

            board = new int[n][n];
            visited = new boolean[n][n];

            for(int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");

                for(int j = 0; j < n; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            answer = 0;

            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    if (board[i][j] == 1 && !visited[i][j]) {
                        dfs(i, j);
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

        if (board[x][y] == 2) {
            answer += 1;
            return;
        }

        int mx = x + 1;
        int my = y;

        if (mx < 0 || mx >= n || my < 0 || my >= n) {
            return;
        }

        dfs(mx, my);
    }
}
