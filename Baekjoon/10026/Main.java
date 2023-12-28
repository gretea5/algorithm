import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class Main {
    private static char[][] graph;
    private static boolean[][] visited;
    private static int N;
    private static int[] dx = {0, 0, 1, -1};
    private static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        graph = new char[N][N];
        visited = new boolean[N][N];
        for(int i = 0; i < N; i++) {
            String input = br.readLine();
            for(int j = 0; j < N; j++) {
                graph[i][j] = input.charAt(j);
            }
        }
        int normalCount = 0;
        int abnormalCount = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(!visited[i][j]) {
                    normal(i, j, graph[i][j]);
                    normalCount++;
                }
            }
        }
        visited = new boolean[N][N];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(!visited[i][j]) {
                    abnormal(i, j, graph[i][j]);
                    abnormalCount++;
                }
            }
        }
        System.out.print(normalCount + " " + abnormalCount);
        br.close();
    }
    private static void normal(int x, int y, char ch) {
        visited[x][y] = true;
        for(int i = 0; i < 4; i++) {
            int mx = x + dx[i];
            int my = y + dy[i];
            if (mx < 0 || mx >= N || my < 0 || my >= N) {
                continue;
            }
            if(!visited[mx][my] && graph[mx][my] == ch) {
                normal(mx, my, ch);
            }
        }
    }

    private static void abnormal(int x, int y, char ch) {
        visited[x][y] = true;
        for(int i = 0; i < 4; i++) {
            int mx = x + dx[i];
            int my = y + dy[i];
            if (mx < 0 || mx >= N || my < 0 || my >= N) {
                continue;
            }
            if (ch == 'B') {
                if(!visited[mx][my] && graph[mx][my] == 'B') {
                    abnormal(mx, my, ch);
                }
            }
            else {
                if(!visited[mx][my] && (graph[mx][my] == 'G' || graph[mx][my] == 'R')) {
                    abnormal(mx, my, ch);
                }
            }
        }
    }

}
