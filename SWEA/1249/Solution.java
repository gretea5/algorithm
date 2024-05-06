import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.PriorityQueue;

public class Solution {
    private static class Pos {
        int x;
        int y;
        int cost;

        Pos(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }

    private static int n;

    private static int[][] map;
    private static boolean[][] visited;

    private static final int[] dx = {1, -1, 0, 0};
    private static final int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for(int test = 1; test <= t; test++) {
            n = Integer.parseInt(br.readLine());

            map = new int[n][n];
            visited = new boolean[n][n];

            for(int i = 0; i < n; i++) {
                String s = br.readLine();

                for(int j = 0; j < n; j++) {
                    map[i][j] = s.charAt(j) - '0';
                }
            }

            sb.append("#").append(test).append(" ");
            sb.append(bfs()).append("\n");
        }

        System.out.print(sb);

        br.close();
    }

    private static int bfs() {
        PriorityQueue<Pos> pq = new PriorityQueue<>((p1, p2) -> p1.cost - p2.cost);

        pq.add(new Pos(0, 0, 0));
        visited[0][0] = true;

        while(!pq.isEmpty()) {
            Pos cur = pq.remove();

            if (cur.x == n - 1 && cur.y == n - 1) {
                return cur.cost;
            }

            for(int i = 0; i < 4; i++) {
                int mx = cur.x + dx[i];
                int my = cur.y + dy[i];

                if (mx < 0 || mx >= n || my < 0 || my >= n) {
                    continue;
                }

                if (!visited[mx][my]) {
                    pq.add(new Pos(mx, my, cur.cost + map[mx][my]));
                    visited[mx][my] = true;
                }
            }
        }

        return -1;
    }
}
