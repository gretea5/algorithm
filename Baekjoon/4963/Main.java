import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;

public class Main {
    public static int w, h;
    public static int[][] graph;
    public static boolean[][] visited;
    public static int[] dx = {0, 1, 1,  1,  0, -1, -1, -1};
    public static int[] dy = {1, 1, 0, -1, -1, -1,  0,  1};
    public static void dfs(int x, int y) {
        visited[x][y] = true;
        for(int i = 0; i < 8; i++) {
            int mx = x + dx[i];
            int my = y + dy[i];
            if(mx < 0 || my < 0 || mx >= h || my >= w) {
                continue;
            }
            if(!visited[mx][my] && graph[mx][my] == 1) {
                dfs(mx, my);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = -1;
        StringBuilder sb = new StringBuilder();
        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            graph = new int[h][w];
            visited = new boolean[h][w];
            answer = 0;
            if (w == 0 && h == 0) {
                break;
            }
            for(int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for(int j = 0; j < w; j++) {
                    graph[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            for(int i = 0; i < h; i++) {
                for(int j = 0; j < w; j++) {
                    if(graph[i][j] == 1 && !visited[i][j]) {
                        dfs(i, j);
                        answer += 1;
                    }
                }
            }
            sb.append(answer).append("\n");
        }
        System.out.print(sb);
        br.close();
    }
}
