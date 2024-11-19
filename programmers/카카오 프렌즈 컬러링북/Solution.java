import java.util.ArrayDeque;


class Solution {    
    private class Pos {
        int x;
        int y;
        
        Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    private static boolean[][] visited;
    
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        
        visited = new boolean[m][n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && picture[i][j] != 0) {
                    numberOfArea += 1;
                    
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, bfs(m, n, i, j, picture));
                }
            }
        }
        
        return new int[] {numberOfArea, maxSizeOfOneArea};
    }
    
    private int bfs(int m, int n, int x, int y, int[][] picture) {
        final int[] dx = {1, -1, 0, 0};
        final int[] dy = {0, 0, 1, -1};
        
        ArrayDeque<Pos> queue = new ArrayDeque<>();
        
        queue.addLast(new Pos(x, y));
        visited[x][y] = true;
        
        int size = 0;
        
        while (!queue.isEmpty()) {
            Pos cur = queue.removeFirst();
            
            int curX = cur.x;
            int curY = cur.y;
            
            size += 1;
            
            for (int i = 0; i < 4; i++) {
                int mx = curX + dx[i];
                int my = curY + dy[i];
                
                if (mx < 0 || mx >= m || my < 0 || my >= n) continue;
                
                if (!visited[mx][my] && picture[x][y] == picture[mx][my]) {
                    queue.addLast(new Pos(mx, my));
                    visited[mx][my] = true;
                }
            }
        }
        
        return size;
    }
}
