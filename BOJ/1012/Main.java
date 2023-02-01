import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;
import java.util.ArrayList;

public class Main {
    public static int[][] graph;
    public static boolean[][] visited;
    public static int N, M, K;
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, 1, -1};
    public static void dfs(int x, int y) {
        visited[x][y] = true;
        for(int i = 0; i < 4; i++) {
            int mx = x + dx[i];
            int my = y + dy[i];
            if(mx < 0 || my < 0 || mx >= N || my >= M) {
                continue;
            }
            if(!visited[mx][my] && graph[mx][my] == 1) {
                dfs(mx, my);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int k = 0; k < T; k++) {
            int count = 0;
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            graph = new int[N][M];
            visited = new boolean[N][M];
            K = Integer.parseInt(st.nextToken());
            for(int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int vy = Integer.parseInt(st.nextToken());
                int vx = Integer.parseInt(st.nextToken());
                graph[vx][vy] = 1;
            }
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < M; j++) {
                    if(!visited[i][j] && graph[i][j] == 1) {
                        dfs(i, j);
                        count++;
                    }
                }
            }
            sb.append(count).append("\n");
        }
        System.out.print(sb.toString());
        br.close();
    }
}
