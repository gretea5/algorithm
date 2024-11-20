import java.util.ArrayDeque;

class Solution {
    private class Pos {
        int x;
        int y;
        int dist;
        
        Pos(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }    
    
    public int solution(int[][] maps) {
        return bfs(maps);
    }
    
    private int bfs(int[][] maps) {
        final int[] dx = {1, -1, 0, 0};
        final int[] dy = {0, 0, 1, -1};
        
        int n = maps.length;
        int m = maps[0].length;
        
        ArrayDeque<Pos> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][m];
        
        queue.addLast(new Pos(0, 0, 1));
        visited[0][0] = true;
        
        while (!queue.isEmpty()) {
            Pos cur = queue.removeFirst();
            
            int x = cur.x;
            int y = cur.y; 
            int dist = cur.dist;
            
            if (x == n - 1 && y == m - 1) {
                return dist;
            }
            
            for (int i = 0; i < 4; i++) {
                int mx = x + dx[i];
                int my = y + dy[i];
            
                if (mx < 0 || mx >= n || my < 0 || my >= m) continue;
                if (visited[mx][my]) continue;
                
                if (maps[mx][my] == 1) {
                    queue.addLast(new Pos(mx, my, dist + 1));
                    visited[mx][my] = true;
                }
            }
        }
        
        return -1;
    }
}
