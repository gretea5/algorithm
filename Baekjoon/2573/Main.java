import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;
public class Main {
    private static int N, M, maxHeight;
    private static int[][] graph;
    private static boolean[][] visited;
    private static int[] dx = {0, 0, 1, -1};
    private static int[] dy = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new int[N][M];
        maxHeight = Integer.MIN_VALUE;
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < M; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                maxHeight = Math.max(maxHeight, graph[i][j]);
            }
        }
        int answer = 0;
        int year = 0;
        while(true) {
            year++;
            meltIce();
            if(calculateArea() >= 2) {
                answer = year;
                break;
            }
            else if(calculateArea() == 0) {
                break;
            }
        }
        System.out.print(answer);
        br.close();
    }
    private static void meltIce() {
        int[][] zeroArr = new int[N][M];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(graph[i][j] > 0) {
                    int zeroCount = 0;
                    for(int h = 0; h < 4; h++) {
                        int mx = i + dx[h];
                        int my = j + dy[h];
                        if(mx < 0 || mx >= N || my < 0 || my >= M) {
                            continue;
                        }
                        if(graph[mx][my] == 0) {
                            zeroCount += 1;
                        }
                    }
                    zeroArr[i][j] = zeroCount;
                }
            }
        }
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                int height = graph[i][j] - zeroArr[i][j];
                if(height < 0) height = 0;
                graph[i][j] = height;
            }
        }
    }
    private static int calculateArea() {
        int count = 0;
        visited = new boolean[N][M];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(!visited[i][j] && graph[i][j] > 0) {
                    dfs(i, j);
                    count++;
                }
            }
        }
        return count;
    }
    private static void dfs(int x, int y) {
        visited[x][y] = true;
        for(int i = 0; i < 4; i++) {
            int mx = x + dx[i];
            int my = y + dy[i];
            if(mx < 0 || mx >= N || my < 0 || my >= M) {
                continue;
            }
            if(!visited[mx][my] && graph[mx][my] > 0) {
                dfs(mx, my);
            }
        }
    }
}
