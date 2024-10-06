import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    private static int n;
    private static int sx, sy;
    private static int ex, ey;
    
    private static int direction;
    private static char[][] map;

    private static final int[] dx = {-1, 0, 1, 0};
    private static final int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int test = 1; test <= t; test++) {
            n = Integer.parseInt(br.readLine());
            map = new char[n][n];

            sb.append("#").append(test).append(" ");

            for (int i = 0; i < n; i++) {
                String s = br.readLine();

                for (int j = 0; j < n; j++) {
                    map[i][j] = s.charAt(j);

                    if (map[i][j] == 'X') {
                        sx = i;
                        sy = j;
                        direction = 0;
                    }

                    if (map[i][j] == 'Y') {
                        ex = i;
                        ey = j;
                    }
                }
            }

            int q = Integer.parseInt(br.readLine());

            for (int i = 0; i < q; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");

                Integer.parseInt(st.nextToken());
                char[] command = st.nextToken().toCharArray();

                int originalX = sx;
                int originalY = sy;

                for (char c : command) {
                    switch (c) {
                        case 'A':
                            move();
                            break;

                        case 'L':
                            direction = (direction + 3) % 4;
                            break;

                        case 'R':
                            direction = (direction + 1) % 4;
                            break;
                    }
                }

                if (sx == ex && sy == ey) {
                    sb.append(1).append(" ");
                } else {
                    sb.append(0).append(" ");
                }

                sx = originalX;
                sy = originalY;
                direction = 0;
            }

            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static void move() {
        int mx = sx + dx[direction];
        int my = sy + dy[direction];

        if (mx < 0 || mx >= n || my < 0 || my >= n) return;

        if (map[mx][my] == 'T') return;

        sx = mx;
        sy = my;
    }
}
