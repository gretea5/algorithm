import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayDeque;

public class Main {
    private static class Pos {
        int x;
        int y;
        int dist;
        int k;
        
        Pos(int x, int y, int dist, int k) {
            this.x = x;
            this.y = y;
            this.dist = dist;
            this.k = k;
        }
    }
    
    private static int n, m, k;
    
    private static int[][] board;
    private static boolean[][][] visited;
    
    private static final int[] dx = {1, -1, 0, 0};
    private static final int[] dy = {0, 0, 1, -1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        
        board = new int[n][m];
        visited = new boolean[n][m][k + 1];
        
        for(int i = 0; i < n; i++) {
            String str = br.readLine();
            
            for(int j = 0; j < m; j++) {
                board[i][j] = str.charAt(j) - '0';
            }
        }
        
        System.out.print(bfs());
        
        br.close();
    }
    
    private static int bfs() {
        ArrayDeque<Pos> queue = new ArrayDeque<>();
        
        queue.addLast(new Pos(0, 0, 1, 0));
        visited[0][0][0] = true;
        
        while(!queue.isEmpty()) {
            Pos cur = queue.removeFirst();
            
            if (cur.x == n - 1 && cur.y == m - 1) {
                return cur.dist;
            }
            
            for(int i = 0; i < 4; i++) {
                int mx = cur.x + dx[i];
                int my = cur.y + dy[i];
                
                if (mx < 0 || mx >= n || my < 0 || my >= m) {
                    continue;
                }
                
                //벽을 만났을때,
                if (board[mx][my] == 1) {
                    if (cur.k < k && !visited[mx][my][cur.k + 1]) {
                        queue.addLast(new Pos(mx, my, cur.dist + 1, cur.k + 1));
                        visited[mx][my][cur.k + 1] = true;
                    }
                }
                //빈칸일때,
                else {
                    if (!visited[mx][my][cur.k]) {
                        queue.addLast(new Pos(mx, my, cur.dist + 1, cur.k));
                        visited[mx][my][cur.k] = true;
                    }
                }
            }
        }
        
        return -1;
    }
}
