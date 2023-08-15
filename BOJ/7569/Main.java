import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayDeque;
public class Main {
    private static class Pos {
        int h;
        int m;
        int n;
        int day;
        Pos(int h, int n, int m, int day) {
            this.h = h;
            this.m = m;
            this.n = n;
            this.day = day;
        }
    }
    private static int[][][] graph;
    private static boolean[][][] visited;
    private static int N, M, H;
    private static int[] dx = {1, -1, 0, 0, 0, 0};
    private static int[] dy = {0, 0, 1, -1, 0, 0};
    private static int[] dz = {0, 0, 0, 0, 1, -1};
    private static ArrayDeque<Pos> queue = new ArrayDeque<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        graph = new int[H][N][M];
        visited = new boolean[H][N][M];
        //입력과 동시에 큐를 넣는다.
        for(int i = 0; i < H; i++) {
            for(int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                for(int k = 0; k < M; k++) {
                    graph[i][j][k] = Integer.parseInt(st.nextToken());
                    //제일 중요했던 부분 토마토가 동시에 익으니까 큐에 다 넣어놓고 day를 계산,
                    if (graph[i][j][k] == 1 && !visited[i][j][k]) {
                        queue.addLast(new Pos(i, j, k, 0));
                        visited[i][j][k] = true;
                        graph[i][j][k] = 0;
                    }
                }
            }
        }
        System.out.print(bfs());
        br.close();
    }
    private static int bfs() {
        while(!queue.isEmpty()) {
            Pos cur = queue.removeFirst();
            for(int i = 0; i < 6; i++) {
                int mx = cur.h + dx[i];
                int my = cur.n + dy[i];
                int mz = cur.m + dz[i];
                if(mx < 0 || mx >= H || my < 0 || my >= N || mz < 0 || mz >= M) {
                    continue;
                }
                if(graph[mx][my][mz] == 0 && !visited[mx][my][mz]) {
                    queue.addLast(new Pos(mx, my, mz, cur.day + 1));
                    visited[mx][my][mz] = true;
                    graph[mx][my][mz] = cur.day + 1;
                }
            }
        }
        int answer = Integer.MIN_VALUE;
        for(int i = 0; i < H; i++) {
            for(int j = 0; j < N; j++) {
                for(int k = 0; k < M; k++) {
                    if(graph[i][j][k] == 0 && !visited[i][j][k]) {
                        return -1;
                    }
                    answer = Math.max(answer, graph[i][j][k]);
                }
            }
        }
        return answer;
    }
}
