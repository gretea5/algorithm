import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Solution {
    private static int n;
    private static int answer;

    private static boolean[][] visited;

    private static final int[] dx = {1, -1, 0, 0, 1, 1, -1, -1};
    private static final int[] dy = {0, 0, 1, -1, 1, -1, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for(int test = 1; test <= t; test++) {
            n = Integer.parseInt(br.readLine());

            visited = new boolean[n][n];

            answer = 0;

            backTrack(0);

            sb.append("#").append(test).append(" ");
            sb.append(answer).append("\n");
        }

        System.out.print(sb);

        br.close();
    }

    private static void backTrack(int depth) {
        if (depth == n) {
            answer += 1;
            return;
        }

        for(int i = 0; i < n; i++) {
            if (check(depth, i)) {
                visited[depth][i] = true;

                backTrack(depth + 1);

                visited[depth][i] = false;
            }
        }
    }

    private static boolean check(int x, int y) {
        for(int d = 0; d < 8; d++) {
            int mx = x;
            int my = y;

            while(true) {
                if (visited[mx][my]) {
                    return false;
                }

                mx += dx[d];
                my += dy[d];

                if (mx < 0 || mx >= n || my < 0 || my >= n) {
                    break;
                }
            }
        }

        return true;
    }
}
