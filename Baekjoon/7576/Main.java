import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
    public static int M, N;
    public static int[][] graph;
    public static boolean[][] visited;
    public static int[] dx = {1, -1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        graph = new int[N][M];
        visited = new boolean[N][M];
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < M; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                if (graph[i][j] == 1) {
                    q.add(new int[]{i, j, 0});
                    graph[i][j] = 0;
                    visited[i][j] = true;
                }
            }
        }
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            for(int i = 0; i < 4; i++) {
                int curX = cur[0];
                int curY = cur[1];
                int days = cur[2];
                int mx = curX + dx[i];
                int my = curY + dy[i];
                if (mx < 0 || my < 0 || mx >= N || my >= M) {
                    continue;
                }
                if(!visited[mx][my] && graph[mx][my] == 0) {
                    q.add(new int[]{mx, my, days + 1});
                    graph[mx][my] = days + 1;
                    visited[mx][my] = true;
                }
            }
        }
        int answer = Integer.MIN_VALUE;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(graph[i][j] == 0 && !visited[i][j]) {
                    System.out.print(-1);
                    return;
                }
                answer = Math.max(answer, graph[i][j]);
            }
        }
        System.out.print(answer);
        br.close();
    }
}
