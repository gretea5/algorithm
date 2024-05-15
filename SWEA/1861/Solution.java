import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class Solution {
    private static class Point {
        int x;
        int y;
        int number;

        Point(int x, int y, int number) {
            this.x = x;
            this.y = y;
            this.number = number;
        }
    }

    private static int n;
    private static int dist;

    private static int[][] board;
    private static boolean[][] visited;

    private static final int[] dx = {1, -1, 0, 0};
    private static final int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for(int test = 1; test <= t; test++) {
            n = Integer.parseInt(br.readLine());

            board = new int[n][n];
            visited = new boolean[n][n];

            ArrayList<Point> arr = new ArrayList<>();

            for(int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");

                for(int j = 0; j < n; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());

                    arr.add(new Point(i, j, board[i][j]));
                }
            }

            Collections.sort(arr, (p1, p2) -> {
                return p1.number - p2.number;
            });

            //이동거리, 작은 번호 순

            int distance = Integer.MIN_VALUE;
            int number = -1;

            for(Point p : arr) {
                if (!visited[p.x][p.y]) {
                    dist = 0;

                    dfs(p.x, p.y);

                    //p.x, p.y에서 시작 했을때, dist가 작
                    if (distance < dist) {
                        distance = dist;
                        number = p.number;
                    }
                }
            }

            sb.append("#").append(test).append(" ");
            sb.append(number).append(" ");
            sb.append(distance).append(" ").append("\n");
        }

        System.out.print(sb);

        br.close();
    }

    private static void dfs(int x, int y) {
        visited[x][y] = true;

        dist += 1;

        for(int i = 0; i < 4; i++) {
            int mx = x + dx[i];
            int my = y + dy[i];

            if (mx < 0 || mx >= n || my < 0 || my >= n) {
                continue;
            }

            if (!visited[mx][my] && board[x][y] + 1 == board[mx][my]) {
                dfs(mx, my);
            }
        }
    }
}
