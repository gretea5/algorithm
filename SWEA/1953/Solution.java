import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayDeque;
import java.util.HashSet;

public class Solution {
    private static class Pos {
        int x, y;
        int dist;

        Pos(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

    private static int n, m;

    private static int[][] map;

    private static HashSet<Integer>[]  tSetArr;

    private static final int[] dx = {-1, 0, 1, 0};
    private static final int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        initSetArr();

        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int test = 1; test <= t; test++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());

            map = new int[n][m];

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine(), " ");

                for (int j = 0; j < m; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            sb.append("#").append(test).append(" ");
            sb.append(bfs(r, c, l)).append("\n");
        }

        System.out.print(sb);

        br.close();
    }

    private static int bfs(int r, int c, int l) {
        boolean[][] visited = new boolean[n][m];

        ArrayDeque<Pos> queue = new ArrayDeque<>();

        queue.addLast(new Pos(r, c, 1));
        visited[r][c] = true;

        int count = 0;

        while (!queue.isEmpty()) {
            Pos cur = queue.removeFirst();

            if (cur.dist > l) {
                continue;
            }

            //개수 증가
            count += 1;

            int type = map[cur.x][cur.y];
            int dist = cur.dist;

            for (int dir : tSetArr[type]) {
                int mx = cur.x + dx[dir];
                int my = cur.y + dy[dir];

                if (mx < 0 || mx >= n || my < 0 || my >= m) continue;

                //터널이 없을 경우,
                if (map[mx][my] == 0) continue;

                int reverseDir = (dir + 2) % 4;
                int nextType = map[mx][my];

                if (!visited[mx][my] && tSetArr[nextType].contains(reverseDir)) {
                    queue.addLast(new Pos(mx, my, dist + 1));
                    visited[mx][my] = true;
                }
            }
        }

        return count;
    }


    private static void initSetArr() {
        tSetArr = new HashSet[8];

        for(int i = 0; i < 8; i++) {
            tSetArr[i] = new HashSet<>();
        }

        tSetArr[1].add(0);
        tSetArr[1].add(1);
        tSetArr[1].add(2);
        tSetArr[1].add(3);

        tSetArr[2].add(0);
        tSetArr[2].add(2);

        tSetArr[3].add(1);
        tSetArr[3].add(3);

        tSetArr[4].add(0);
        tSetArr[4].add(1);

        tSetArr[5].add(1);
        tSetArr[5].add(2);

        tSetArr[6].add(2);
        tSetArr[6].add(3);

        tSetArr[7].add(3);
        tSetArr[7].add(0);
    }
}
