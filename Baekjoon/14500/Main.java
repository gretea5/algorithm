import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayDeque;

public class Main {
    private static class Pos {
        int x;
        int y;
        int sum;
        int dist;
        
        Pos(int x, int y, int sum, int dist) {
            this.x = x;
            this.y = y;
            this.sum = sum;
            this.dist = dist;
        }
    }
    
    private static int answer;
    private static int n;
    private static int m;
    
    private static boolean[][] visited;
    private static int[][] map;
    
    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, 1, -1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        visited = new boolean[n][m];
        map = new int[n][m];
        
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            
            for(int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        answer = Integer.MIN_VALUE;
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                visited[i][j] = true;
                
                //나머지 4개의 블록의 최대값을 가지는 합을 구하기
                dfs(i, j, map[i][j], 1);
                
                visited[i][j] = false;
                
                //뻐큐 모양 최대값을 가지는 합을 구하기
                backTrack(i, j, 0, map[i][j], 0);
            }
        }
        
        System.out.print(answer);
        
        br.close();
    }
    
    private static void backTrack(int x, int y, int idx, int sum, int depth) {
        if (depth == 3) {
            answer = Math.max(answer, sum);
            return;
        }
        
        for(int i = idx; i < 4; i++) {
            int mx = x + dx[i];
            int my = y + dy[i];
            
            if (!isRange(mx, my)) {
                backTrack(x, y, i + 1, sum + map[mx][my], depth + 1);
            }
        }
    }
    
    private static void dfs(int x, int y, int sum, int depth) {
        if(depth == 4) {
            answer = Math.max(answer, sum);
            return;
        }
        
        for(int i = 0; i < 4; i++) {
            int mx = x + dx[i];
            int my = y + dy[i];
            
            if(isRange(mx, my)) continue;
            
            if(!visited[mx][my]) {
                visited[mx][my] = true;
                
                dfs(mx, my, sum + map[mx][my], depth + 1);
                
                visited[mx][my] = false;
            }
        }
    }
    
    private static boolean isRange(int mx, int my) {
        return mx < 0 || mx >= n || my < 0 || my >= m;
    }
}
