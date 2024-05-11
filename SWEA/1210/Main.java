import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Solution {
    private static final int size = 100;
    private static boolean flag;

    private static int[][] board;
    private static boolean[][] visited;

    private static final int[] dx = {0, 0, 1};
    private static final int[] dy = {1, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = 10;

        StringBuilder sb = new StringBuilder();

        for(int test = 1; test <= t; test++) {
            int testNumber = Integer.parseInt(br.readLine());

            board = new int[size][size];
            visited = new boolean[size][size];

            for(int i = 0; i < size; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");

                for(int j = 0; j < size; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int answer = -1;

            for(int i = 0; i < size; i++) {
                visited = new boolean[size][size];

                flag = false;

                dfs(0, i);

                if (flag) {
                    answer = i + 1;
                    break;
                }
            }

            sb.append("#").append(testNumber).append(" ");
            sb.append(answer).append("\n");
        }

        System.out.print(sb);

        br.close();
    }

    private static void dfs(int x, int y) {
        visited[x][y] = true;

        if (board[x][y] == 2) {
            flag = true;
            return;
        }

        int dir = makeDirection(x, y);

        int mx = x + dx[dir];
        int my = y + dy[dir];

        if (mx < 0 || mx >= size || my < 0 || my >= size) {
            return;
        }

        if (board[mx][my] != 0 && !visited[mx][my]) {
            dfs(mx, my);
        }
    }

    private static int makeDirection(int x, int y) {
        for(int d = 0; d < 2; d++) {
            int mx = x + dx[d];
            int my = y + dy[d];

            if (mx < 0 || mx >= size || my < 0 || my >= size) {
                continue;
            }

            if (board[mx][my] != 0 && !visited[mx][my]) {
                return d;
            }
        }

        return 2;
    }
}
