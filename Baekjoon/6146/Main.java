import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayDeque;

public class Main {
    private static class Pos {
        int x, y;
        int dist;
        
        Pos(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
    
    private static final int length = 1001;
    private static final int half = 500;
    
    private static int[][] map;
    private static boolean[][] visited;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        int sx = half;
        int sy = half;
        
        int ex = Integer.parseInt(st.nextToken()) + half;
        int ey = Integer.parseInt(st.nextToken()) + half;
        int n = Integer.parseInt(st.nextToken());
        
        map = new int[length][length];
        
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            
            map[x + half][y + half] = 1;
        }
        
        System.out.print(bfs(sx, sy, ex, ey));
        
        br.close();
    }
    
    private static int bfs(int sx, int sy, int ex, int ey) {
        boolean[][] visited = new boolean[length][length];
        
        final int[] dx = {1, -1, 0, 0};
        final int[] dy = {0, 0, 1, -1};
        
        ArrayDeque<Pos> queue = new ArrayDeque<>();
        
        queue.addLast(new Pos(sx, sy, 0));
        visited[sx][sy] = true;
        
        while(!queue.isEmpty()) {
            Pos cur = queue.removeFirst();
            
            if (cur.x == ex && cur.y == ey) {
                return cur.dist;
            }
            
            for (int i = 0; i < 4; i++) {
                int mx = cur.x + dx[i];
                int my = cur.y + dy[i];
                
                if (mx < 0 || mx >= length || my < 0 || my >= length) continue;
                
                if (!visited[mx][my] && map[mx][my] == 0) {
                    queue.addLast(new Pos(mx, my, cur.dist + 1));
                    visited[mx][my] = true;
                }
            }
        }
        
        return -1;
    }
}
