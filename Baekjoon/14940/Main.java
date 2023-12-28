import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
    public static int w, h;
    public static int[][] graph;
    public static boolean[][] visited;
    public static int[][] answer;
    public static int[] dx = {1, -1, 0, 0 };
    public static int[] dy = {0, 0, -1, 1};
    public static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y, 0});
        visited[x][y] = true;
        answer[x][y] = 0;
        while(!q.isEmpty()) {
            int[] arr = q.poll();
            for(int i = 0; i < 4; i++) {
                int mx = arr[0] + dx[i];
                int my = arr[1] + dy[i];
                int count = arr[2];
                if(mx < 0 || my < 0 || mx >= h || my >= w) {
                    continue;
                }
                if(graph[mx][my] == 0) {
                    answer[mx][my] = 0;
                }
                if(graph[mx][my] == 1 && !visited[mx][my]) {
                    q.offer(new int[]{mx, my, count + 1});
                    visited[mx][my] = true;
                    answer[mx][my] = count + 1;
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        graph = new int[h][w];
        answer = new int[h][w];
        visited = new boolean[h][w];
        int startX = 0, startY = 0;
        for(int i = 0; i < h; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < w; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                if(graph[i][j] == 2) {
                    startX = i;
                    startY = j;
                }
                else if (graph[i][j] == 0) {
                    answer[i][j] = 0;
                }
                else {
                    answer[i][j] = -1;
                }
            }
        }
        bfs(startX, startY);
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < h; i++) {
            for(int j = 0; j < w; j++) {
                sb.append(answer[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
        br.close();
    }
}
