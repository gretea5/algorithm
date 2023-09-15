import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayDeque;
public class Main {
    private static class Pos {
        int x;
        int y;
        int k;
        int distance;
        Pos(int x, int y, int k, int distance) {
            this.x = x;
            this.y = y;
            this.k = k;
            this.distance = distance;
        }
    }
    private static int K, W, H;
    private static int[][] map;
    private static boolean[][][] visited;
    private static int[] mx1 = {-2, -1, 1, 2, 2, 1, -1, -2};
    private static int[] my1 = {1, 2, 2, 1, -1, -2, -2, -1};
    private static int[] mx2 = {0, 0, 1, -1};
    private static int[] my2 = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        map = new int[H][W];
        visited = new boolean[H][W][K + 1];
        for(int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < W; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.print(bfs(0, 0));
        br.close();
    }
    private static int bfs(int x, int y) {
        ArrayDeque<Pos> queue = new ArrayDeque<>();
        queue.addLast(new Pos(x, y, 0, 0));
        visited[x][y][0] = true;
        while(!queue.isEmpty()) {
            Pos cur = queue.removeFirst();
            if(cur.x == H - 1 && cur.y == W - 1) {
                return cur.distance;
            }
            //인접한 정점으로 이동할 경우
            for(int i = 0; i < 4; i++) {
                int moveX = cur.x + mx2[i];
                int moveY = cur.y + my2[i];
                if(moveX < 0 || moveX >= H || moveY < 0 || moveY >= W) continue;
                if(!visited[moveX][moveY][cur.k] && map[moveX][moveY] == 0) {
                    queue.addLast(new Pos(moveX, moveY, cur.k, cur.distance + 1));
                    visited[moveX][moveY][cur.k] = true;
                }
            }
            //말처럼 이동할 수 있는 횟수 제한
            if(cur.k < K) {
                for(int i = 0; i < 8; i++) {
                    int moveX = cur.x + mx1[i];
                    int moveY = cur.y + my1[i];
                    if(moveX < 0 || moveX >= H || moveY < 0 || moveY >= W) continue;
                    if(!visited[moveX][moveY][cur.k + 1] && map[moveX][moveY] == 0) {
                        queue.addLast(new Pos(moveX, moveY, cur.k + 1, cur.distance + 1));
                        visited[moveX][moveY][cur.k + 1] = true;
                    }
                }
            }
        }
        return -1;
    }
}
