import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayDeque;
public class Main {
    private static class Pos {
        int x;
        int y;
        int distance;
        Pos(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }
    private static int N, answer;
    private static int[][] map;
    private static boolean[][] visited;
    private static int[] mx = {0, 0, -1, 1};
    private static int[] my = {-1, 1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int areaNumber = 1;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(map[i][j] == 1 && !visited[i][j]) {
                    dfs(i, j, areaNumber);
                    areaNumber += 1;
                }
            }
        }
        answer = Integer.MAX_VALUE;
        for(int i = 1; i <= areaNumber; i++) {
            putBridge(i);
        }
        System.out.print(answer);
        br.close();
    }
    private static void putBridge(int areaNumber) {
        visited = new boolean[N][N];
        ArrayDeque<Pos> queue = new ArrayDeque<>();
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(map[i][j] == areaNumber) {
                    queue.addLast(new Pos(i, j, 0));
                    visited[i][j] = true;
                }
            }
        }
        while(!queue.isEmpty()) {
            Pos cur = queue.removeFirst();
            for(int i = 0; i < 4; i++) {
                int moveX = cur.x + mx[i];
                int moveY = cur.y + my[i];
                if(moveX < 0 || moveX >= N || moveY < 0 || moveY >= N) continue;
                if(map[moveX][moveY] != 0 && map[moveX][moveY] != areaNumber) {
                    answer = Math.min(answer, cur.distance);
                }
                if(map[moveX][moveY] == 0 && !visited[moveX][moveY]) {
                    queue.addLast(new Pos(moveX, moveY, cur.distance + 1));
                    visited[moveX][moveY] = true;
                }
            }
        }
    }
    private static void dfs(int x, int y, int areaNumber) {
        visited[x][y] = true;
        map[x][y] = areaNumber;
        for(int i = 0; i < 4; i++) {
            int moveX = x + mx[i];
            int moveY = y + my[i];
            if(moveX < 0 || moveX >= N || moveY < 0 || moveY >= N) continue;
            if(!visited[moveX][moveY] && map[moveX][moveY] == 1) {
                dfs(moveX, moveY, areaNumber);
            }
        }
    }
}
