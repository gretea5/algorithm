import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
    public static int T, L, answer = 0;
    public static boolean[][] visited;
    public static int[] dx = {-2, -1, 1, 2, -2, -1, 1, 2};
    public static int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for(int j = 0; j < T; j++) {
            L = Integer.parseInt(br.readLine());
            visited = new boolean[L][L];
            answer = 0;
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int curx = Integer.parseInt(st.nextToken());
            int cury = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine(), " ");
            int desx = Integer.parseInt(st.nextToken());
            int desy = Integer.parseInt(st.nextToken());
            Queue<int[]> q = new LinkedList<>();
            q.offer(new int[]{curx, cury, 0});
            visited[curx][cury] = true;
            while (!q.isEmpty()) {
                int[] c = q.poll();
                int cx = c[0];
                int cy = c[1];
                int distance = c[2];
                if(cx == desx && cy == desy) {
                    answer = distance;
                    break;
                }
                for(int i = 0; i < 8; i++) {
                    int mx = cx + dx[i];
                    int my = cy + dy[i];
                    if(mx < 0 || mx >= L || my < 0 || my >= L) {
                        continue;
                    }
                    if(!visited[mx][my]) {
                        q.offer(new int[]{mx, my, distance + 1});
                        visited[mx][my] = true;
                    }
                }
            }
            System.out.println(answer);
        }
        br.close();
    }
}
