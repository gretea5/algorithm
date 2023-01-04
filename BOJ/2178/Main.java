import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
    public static int N;
    public static int M;
    public static int graph[][];
    public static boolean visited[][];

    public static int mx[] = {1, -1, 0, 0};
    public static int my[] = {0, 0, -1, 1};

    public static int bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        int count = 1;
        q.offer(new int[]{x, y});
        visited[x][y] = true;
        graph[x][y] = 1;
        while(true) {
            int arr[] = q.poll();
            int vx = arr[0];
            int vy = arr[1];
            if(vx == N - 1 && vy == M - 1)  break;
            for(int i = 0; i < 4; i++) {
                int x1 = vx + mx[i];
                int x2 = vy + my[i];
                if(x1 < 0 || x2 < 0 || x1 > N - 1 || x2 > M - 1) {
                    continue;
                }
                if(graph[x1][x2] == 1 && !visited[x1][x2]) {
                    q.offer(new int[]{x1, x2});
                    visited[x1][x2] = true;
                    graph[x1][x2] = graph[vx][vy] + 1;
                }
            }
        }
        return graph[N - 1][M - 1];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new int[N][M];
        visited = new boolean[N][M];
        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            for(int j = 0; j < M; j++) {
                graph[i][j] = (int) str.charAt(j) - '0';
            }
        }
        System.out.print(bfs(0, 0));
        br.close();
    }
}
