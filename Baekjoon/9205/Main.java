import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayDeque;

public class Main {
    private static class Point {
        int x;
        int y;
        
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    private static int n;
    private static Point[] market;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringBuilder sb = new StringBuilder();
        
        int t = Integer.parseInt(br.readLine());
        
        while (t > 0) {
            n = Integer.parseInt(br.readLine());
            
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            
            int sx = Integer.parseInt(st.nextToken());
            int sy = Integer.parseInt(st.nextToken());
            
            market = new Point[n];
            
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                
                market[i] = new Point(x, y);
            }
            
            st = new StringTokenizer(br.readLine(), " ");
            
            int ex = Integer.parseInt(st.nextToken());
            int ey = Integer.parseInt(st.nextToken());
            
            if (bfs(sx, sy, ex, ey)) {
                sb.append("happy");
            }
            else {
                sb.append("sad");
            }
            
            sb.append("\n");
            
            t -= 1;
        }
        
        System.out.print(sb);
        
        br.close();
    }
    
    private static boolean bfs(int sx, int sy, int ex, int ey) {
        if (calDistance(sx, sy, ex, ey) <= 1000) {
            return true;
        }
        
        boolean[] visited = new boolean[n];
        
        ArrayDeque<Point> queue = new ArrayDeque<>();
        
        for (int i = 0; i < n; i++) {
            int x = market[i].x;
            int y = market[i].y;
            
            if (calDistance(sx, sy, x, y) <= 1000) {
                queue.addLast(new Point(x, y));
                visited[i] = true;
            }
        }
        
        while (!queue.isEmpty()) {
            Point cur = queue.removeFirst();
            
            int x = cur.x;
            int y = cur.y;
            
            if (calDistance(x, y, ex, ey) <= 1000) {
                return true;
            }
            
            for (int i = 0; i < n; i++) {
                int dist = calDistance(x, y, market[i].x, market[i].y);
                
                if (!visited[i] && dist <= 1000) {
                    queue.addLast(new Point(market[i].x, market[i].y));
                    visited[i] = true;
                }
            }
        }
        
        return false;
    }
    
    private static int calDistance(int x1, int y1, int x2, int y2) {
        return (int) (Math.abs(x1 - x2) + Math.abs(y1 - y2));
    }
}
