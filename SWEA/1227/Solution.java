import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException; 
import java.util.ArrayDeque;

public class Solution {
  private static class Pos {
    int x;
    int y;
    
    Pos(int x, int y) {
      this.x = x; 
      this.y = y;
    }
  }
  
  private static int[][] map;
  private static boolean[][] visited;
  
  private static int[] dx = {1, -1, 0, 0};
  private static int[] dy = {0, 0, 1, -1};
  
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    StringBuilder sb = new StringBuilder();
    
    for(int test = 1; test <= 10; test++) {
      int order = Integer.parseInt(br.readLine());
      
      map = new int[100][100];
      
      int startX = -1;
      int startY = -1;
      
      for(int i = 0; i < 100; i++) {
        String s = br.readLine();
        
        for(int j = 0; j < 100; j++) {
          map[i][j] = s.charAt(j) - '0';
          
          if (map[i][j] == 2) {
            startX = i;
            startY = j;
          }
        }
      }
      
      sb.append("#").append(order).append(" ");
      sb.append(bfs(startX, startY)).append("\n");
    }
    
    System.out.print(sb);
    
    br.close();
  }
  
  private static int bfs(int startX, int startY) {
    visited = new boolean[100][100];
    
    ArrayDeque<Pos> queue = new ArrayDeque<>();
    
    queue.addLast(new Pos(startX, startY));
    visited[startX][startY] = true;
    
    while(!queue.isEmpty()) {
      Pos cur = queue.removeFirst();
      
      int x = cur.x;
      int y = cur.y;
      
      if (map[x][y] == 3) {
        return 1;
      }
      
      for(int i = 0; i < 4; i++) {
        int mx = x + dx[i];
        int my = y + dy[i];
        
        if (mx < 0 || mx >= 100  || my < 0 || my >= 100) {
          continue;
        }
        
        if (!visited[mx][my] && map[mx][my] != 1) {
          queue.addLast(new Pos(mx, my));
          visited[mx][my] = true; 
        }
      }
    }
    
    return 0;
  }
}
