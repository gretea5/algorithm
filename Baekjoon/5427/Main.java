import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayDeque;
public class Main {
    private static class Pos {
        int x;
        int y;
        int time;
        Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
        Pos(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }
    private static int w, h;
    private static char[][] map;
    private static ArrayDeque<Pos> fireQueue, personQueue;
    private static int[] moveX = {0, 0, 1, -1};
    private static int[] moveY = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            map = new char[h][w];
            fireQueue = new ArrayDeque<>();
            personQueue = new ArrayDeque<>();
            for(int i = 0; i < h; i++) {
                String input = br.readLine();
                for(int j = 0; j < w; j++) {
                    map[i][j] = input.charAt(j);
                    if(map[i][j] == '*') fireQueue.addLast(new Pos(i, j));
                    if(map[i][j] == '@') personQueue.addLast(new Pos(i, j, 1));
                }
            }
            sb.append(bfs()).append("\n");
        }
        System.out.print(sb);
        br.close();
    }
    private static String bfs() {
        while(!personQueue.isEmpty()) {
            int size = fireQueue.size();
            for(int k = 0; k < size; k++) {
                Pos cur = fireQueue.removeFirst();
                for(int i = 0; i < 4; i++) {
                    int mx = cur.x + moveX[i];
                    int my = cur.y + moveY[i];
                    if(mx < 0 || mx >= h || my < 0 || my >= w) {
                        continue;
                    }
                    if(map[mx][my] == '.' || map[mx][my] == '@') {
                        fireQueue.addLast(new Pos(mx, my));
                        map[mx][my] = '*';
                    }
                }
            }
            size = personQueue.size();
            for(int k = 0; k < size; k++) {
                Pos cur = personQueue.removeFirst();
                if(cur.x == 0 || cur.x == h - 1 || cur.y == 0 || cur.y == w - 1) {
                    return String.valueOf(cur.time);
                }
                for(int i = 0; i < 4; i++) {
                    int mx = cur.x + moveX[i];
                    int my = cur.y + moveY[i];
                    if(mx < 0 || mx >= h || my < 0 || my >= w) {
                        continue;
                    }
                    if(map[mx][my] == '.') {
                        personQueue.addLast(new Pos(mx, my, cur.time + 1));
                        map[mx][my] = '@';
                    }
                }
            }
        }
        return "IMPOSSIBLE";
    }
}
