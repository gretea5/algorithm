import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
public class Main {
    private static int N, maxHeight, area;
    private static int[][] graph;
    private static boolean[][] visited;
    private static int[] dx = {0, 0, -1, 1};
    private static int[] dy = {-1, 1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        maxHeight = Integer.MIN_VALUE;
        graph = new int[N][N];
        visited = new boolean[N][N];
        //입력
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                maxHeight = Math.max(graph[i][j], maxHeight);
            }
        }
        int answer = Integer.MIN_VALUE;
        for(int h = 0; h <= maxHeight; h++)  {
            visited = new boolean[N][N];
            area = 0;
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    if(!visited[i][j] && graph[i][j] > h) {
                        dfs(i, j, h);
                        area++;
                    }
                }
            }
            answer = Math.max(answer, area);
        }
        System.out.print(answer);
        br.close();
    }
    private static void dfs(int x, int y, int height) {
        visited[x][y] = true;
        for(int i = 0; i < 4; i++) {
            int mx = x + dx[i];
            int my = y + dy[i];
            if (mx < 0 || mx >= N || my < 0 || my >= N) {
                continue;
            }
            if(!visited[mx][my] && graph[mx][my] > height) {
                dfs(mx, my, height);
            }
        }
    }
}
