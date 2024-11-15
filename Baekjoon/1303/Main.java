import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayDeque;

public class Main {
    private static class Pos {
        int x;
        int y;

        Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static int n, m;
    private static char[][] map;
    private static boolean[][] visited;

    private static final char WHITE = 'W';
    private static final char BLUE = 'B';

    private static final int[] dx = {1, -1, 0, 0};
    private static final int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new char[m][n];
        visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            String s = br.readLine();

            for (int j = 0; j < n; j++) {
                map[i][j] = s.charAt(j);
            }
        }

        int myTeamPower = 0;
        int otherTeamPower = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j]) continue;

                if (map[i][j] == WHITE) {
                    myTeamPower += (int) Math.pow(bfs(i, j, WHITE), 2);
                }
                else {
                    otherTeamPower += (int) Math.pow(bfs(i, j, BLUE), 2);
                }
            }
        }

        System.out.print(myTeamPower + " " + otherTeamPower);

        br.close();
    }

    private static int bfs(int sx, int sy, char target) {
        ArrayDeque<Pos> queue = new ArrayDeque<>();

        queue.addLast(new Pos(sx, sy));
        visited[sx][sy] = true;

        int cnt = 0;

        while (!queue.isEmpty()) {
            Pos cur = queue.removeFirst();

            cnt += 1;

            int x = cur.x;
            int y = cur.y;

            for (int i = 0; i < 4; i++) {
                int mx = x + dx[i];
                int my = y + dy[i];

                if (mx < 0 || mx >= m || my < 0 || my >= n) continue;
                if (visited[mx][my]) continue;

                if (map[mx][my] == target) {
                    queue.addLast(new Pos(mx, my));
                    visited[mx][my] = true;
                }
            }
        }

        return cnt;
    }
}
