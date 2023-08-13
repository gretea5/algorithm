import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
public class Main {
    private static int[][] graph;
    private static boolean[][] visited;
    private static int[] dx = {0, 0, 1, -1};
    private static int[] dy = {-1, 1, 0, 0};
    private static int n, m, area;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new int[n][m];
        visited = new boolean[n][m];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                graph[i][j] =  Integer.parseInt(st.nextToken());
            }
        }
        int maxArea = Integer.MIN_VALUE;
        int count = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(!visited[i][j] && graph[i][j] == 1) {
                    area = 0;
                    count++;
                    dfs(i, j);
                    maxArea = Math.max(area, maxArea);
                }
            }
        }
        if (count == 0) {
            System.out.println(0);
            System.out.println(0);
            return;
        }
        System.out.println(count);
        System.out.println(maxArea);
        br.close();
    }
    private static void dfs(int x, int y) {
        visited[x][y] = true;
        area += 1;
        for(int i = 0; i < 4; i++) {
            int mx = x + dx[i];
            int my = y + dy[i];
            if (mx < 0 || mx >= n || my < 0 || my >= m) {
                continue;
            }
            if (!visited[mx][my] && graph[mx][my] == 1) {
                dfs(mx, my);
            }
        }
    }
}
