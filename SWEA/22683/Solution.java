import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.ArrayDeque;

public class Solution {
    private static class Car {
        int x, y;
        int cutCount;
        int count;
        int dir;

        Car(int x, int y, int cutCount, int count, int dir) {
            this.x = x;
            this.y = y;
            this.cutCount = cutCount;
            this.count = count;
            this.dir = dir;
        }
    }

    private static int n, k;
    private static char[][] map;

    private static final int[] dx = {-1, 0, 1, 0};
    private static final int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int test = 1; test <= t; test++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            map = new char[n][n];

            int sx = -1;
            int sy = -1;

            for (int i = 0; i < n; i++) {
                String s = br.readLine();

                for (int j = 0; j < n; j++) {
                    map[i][j] = s.charAt(j);

                    if (map[i][j] == 'X') {
                        sx = i;
                        sy = j;
                    }
                }
            }

            sb.append("#").append(test).append(" ");
            sb.append(bfs(sx, sy)).append("\n");
        }

        System.out.print(sb);

        br.close();
    }

    private static int bfs(int sx, int sy) {
        boolean[][][] visited = new boolean[n][n][k + 1];

        PriorityQueue<Car> queue = new PriorityQueue<>((c1, c2) -> c1.count - c2.count);

        queue.add(new Car(sx, sy, 0, 0, 0));
        visited[sx][sy][0] = true;

        int min = Integer.MAX_VALUE;

        while (!queue.isEmpty()) {
            Car c = queue.remove();

            if (map[c.x][c.y] == 'Y') {
                return c.count;
            }

            int x = c.x;
            int y = c.y;
            int cutCount = c.cutCount;
            int count = c.count;
            int dir = c.dir;

            for (int i = 0; i < 4; i++) {
                int mx = x + dx[i];
                int my = y + dy[i];

                if (mx < 0 || mx >= n || my < 0 || my >= n) continue;

                int newCount = count;

                if (dir != i) {
                    int dist = Math.abs(dir - i);

                    newCount += (dist == 2 ? 2 : 1);
                }

                // 나무라면 나무 자르기
                if (map[mx][my] == 'T') {
                    if (cutCount + 1 <= k && !visited[mx][my][cutCount + 1]) {
                        queue.add(new Car(mx, my, cutCount + 1, newCount + 1, i));
                        visited[mx][my][cutCount + 1] = true;
                    }
                }
                // 나무가 아니라면 그냥 가기
                else {
                    if (!visited[mx][my][cutCount]) {
                        queue.add(new Car(mx, my, cutCount, newCount + 1, i));
                        visited[mx][my][cutCount] = true;
                    }
                }
            }
        }

        return -1;
    }
}
