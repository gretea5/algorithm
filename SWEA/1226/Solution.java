import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayDeque;

public class Solution {
    private static class Pos {
        int x;
        int y;

        Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static int[][] map;
    private static boolean[][] visited;

    private static final int[] dx = {0, 0, 1, -1};
    private static final int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = 10;

        StringBuilder sb = new StringBuilder();

        for(int test = 1; test <= t; test++) {
            int testCase = Integer.parseInt(br.readLine());

            map = new int[16][16];
            visited = new boolean[16][16];

            int sx = -1;
            int sy = -1;

            for(int i = 0; i < 16; i++) {
                String s = br.readLine();

                for(int j = 0; j < 16; j++) {
                    map[i][j] = s.charAt(j) - '0';

                    if (map[i][j] == 2) {
                        sx = i;
                        sy = j;
                    }
                }
            }
            sb.append("#").append(testCase).append(" ");
            sb.append(bfs(sx, sy)).append("\n");
        }

        System.out.print(sb);

        br.close();
    }

    private static int bfs(int sx, int sy) {
        ArrayDeque<Pos> queue = new ArrayDeque<>();

        queue.addLast(new Pos(sx, sy));
        visited[sx][sy] = true;

        while(!queue.isEmpty()) {
            Pos cur = queue.removeFirst();

            if (map[cur.x][cur.y] == 3) {
                return 1;
            }

            for(int i = 0; i < 4; i++) {
                int mx = cur.x + dx[i];
                int my = cur.y + dy[i];

                if (mx < 0 || mx >= 16 || my < 0 || my >= 16) {
                    continue;
                }

                if (!visited[mx][my] && map[mx][my] != 1) {
                    queue.addLast(new Pos(mx, my));
                    visited[mx][my] = true;
                }
            }
        }

        return 0;
    }
}
