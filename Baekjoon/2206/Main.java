import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayDeque;
public class Main {
    private static class Pos {
        int x, y, distance;
        boolean broken;
        Pos(int x, int y, int distance, boolean broken) {
            this.x = x;
            this.y = y;
            this.distance = distance;
            this.broken = broken;
        }
    }
    private static int[][] graph;
    private static boolean[][][] visited;
    private static int N, M;
    private static int[] dx = {0, 0, 1, -1};
    private static int[] dy = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new int[N][M];
        visited = new boolean[N][M][2];
        for(int i = 0; i < N; i++) {
            String input = br.readLine();
            for(int j = 0; j < M; j++) {
                graph[i][j] = (int) input.charAt(j) - '0';
            }
        }
        System.out.print(bfs(0, 0));
        br.close();
    }
    private static int bfs(int x, int y) {
        ArrayDeque<Pos> queue = new ArrayDeque<>();
        queue.addLast(new Pos(x, y, 1, false));
        visited[x][y][0] = true;
        visited[x][y][1] = true;
        while(!queue.isEmpty()) {
            Pos cur = queue.removeFirst();
            if(cur.x == N - 1 && cur.y == M - 1) {
                return cur.distance;
            }
            for(int i = 0; i < 4; i++) {
                int mx = cur.x + dx[i];
                int my = cur.y + dy[i];
                if(mx < 0 || mx >= N || my < 0 || my >= M) {
                    continue;
                }
                if(graph[mx][my] == 1) {
                    if(!cur.broken && !visited[mx][my][1]) {
                        queue.addLast(new Pos(mx, my, cur.distance + 1, true));
                        visited[mx][my][1] = true;
                    }
                }
                else {
                    if(!cur.broken && !visited[mx][my][0]) {
                        queue.addLast(new Pos(mx, my, cur.distance + 1, false));
                        visited[mx][my][0] = true;
                    }
                    else if(cur.broken && !visited[mx][my][1]) {
                        queue.addLast(new Pos(mx, my, cur.distance + 1, true));
                        visited[mx][my][1] = true;
                    }
                }
            }
        }
        return -1;
    }
}
