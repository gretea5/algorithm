import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayDeque;
public class Main {
    private static class Pos {
        int x;
        int y;
        int z;
        int distance;
        Pos(int x, int y, int z, int distance) {
            this.x = x;
            this.y = y;
            this.z = z;
            this.distance = distance;
        }
    }
    private static int L, R, C;
    private static char[][][] graph;
    private static boolean[][][] visited;
    private static int[] dx = {1, -1, 0, 0, 0, 0};
    private static int[] dy = {0, 0, 1, -1, 0, 0};
    private static int[] dz = {0, 0, 0, 0, 1, -1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            L = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            if (L == 0 && R == 0 && C == 0) break;
            graph = new char[L][R][C];
            visited = new boolean[L][R][C];
            for (int i = 0; i < L; i++) {
                for (int j = 0; j < R; j++) {
                    String input = br.readLine();
                    for (int h = 0; h < C; h++) {
                        graph[i][j][h] = input.charAt(h);
                    }
                }
                br.readLine();
            }
            for (int i = 0; i < L; i++) {
                for (int j = 0; j < R; j++) {
                    for (int h = 0; h < C; h++) {
                        if(!visited[i][j][h] && graph[i][j][h] == 'S') {
                            int result = bfs(i, j, h);
                            if(result == -1) {
                                sb.append("Trapped!").append("\n");
                            }
                            else {
                                sb.append("Escaped in ").append(result).append(" minute(s).").append("\n");
                            }
                        }
                    }
                }
            }
        }
        System.out.print(sb);
        br.close();
    }
    private static int bfs(int x, int y, int z) {
        ArrayDeque<Pos> queue = new ArrayDeque<>();
        queue.addLast(new Pos(x, y, z, 0));
        visited[x][y][z] = true;
        while(!queue.isEmpty()) {
            Pos cur = queue.removeFirst();
            if(graph[cur.x][cur.y][cur.z] == 'E') {
                return cur.distance;
            }
            for(int i = 0; i < 6; i++) {
                int mx = cur.x + dx[i];
                int my = cur.y + dy[i];
                int mz = cur.z + dz[i];
                if(mx < 0 || mx >= L || my < 0 || my >= R || mz < 0 || mz >= C) {
                    continue;
                }
                if(!visited[mx][my][mz] && (graph[mx][my][mz] == '.' || graph[mx][my][mz] == 'E')) {
                    queue.addLast(new Pos(mx, my, mz, cur.distance + 1));
                    visited[mx][my][mz] = true;
                }
            }
        }
        return -1;
    }
}
