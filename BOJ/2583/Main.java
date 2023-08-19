import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Collections;
import java.util.ArrayList;
public class Main {
    private static int M, N, K;
    private static int[][] graph;
    private static boolean[][] visited;
    private static int area, count;
    private static int[] dx = {0, 0, -1, 1};
    private static int[] dy = {-1, 1, 0, 0};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        graph = new int[M][N];
        visited = new boolean[M][N];
        for(int h = 0; h < K; h++) {
            st = new StringTokenizer(br.readLine(), " ");
            int sx = Integer.parseInt(st.nextToken());
            int sy = Integer.parseInt(st.nextToken());
            int ex = Integer.parseInt(st.nextToken());
            int ey = Integer.parseInt(st.nextToken());
            for(int i = sy; i < ey; i++) {
                for(int j = sx; j < ex; j++) {
                    graph[i][j] = 1;
                }
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        count = 0;
        for(int i = 0; i < M; i++) {
            for(int j = 0; j < N; j++) {
                if(!visited[i][j] && graph[i][j] == 0) {
                    area = 0;
                    count++;
                    dfs(i, j);
                    list.add(area);
                }
            }
        }
        Collections.sort(list);
        System.out.println(count);
        for(int area: list) {
            System.out.print(area + " ");
        }
        br.close();
    }
    private static void dfs(int x, int y) {
        visited[x][y] = true;
        area++;
        for(int i = 0; i < 4; i++) {
            int mx = x + dx[i];
            int my = y + dy[i];
            if(mx < 0 || mx >= M || my < 0 || my >= N) {
                continue;
            }
            if(!visited[mx][my] && graph[mx][my] == 0) {
                dfs(mx, my);
            }
        }
    }
}
