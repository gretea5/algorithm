import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class Main {
    private static class Pos {
        int x;
        int y;
        int number;
        
        Pos(int x, int y, int number) {
            this.x = x;
            this.y = y;
            this.number = number;
        }
    }
    
    private static int n;
    private static int l;
    private static int r;
    
    private static int[][] map;
    private static boolean[][] visited;
    
    private static final int[] dx = {1, -1, 0, 0};
    private static final int[] dy = {0, 0, 1, -1};
    
    private static ArrayList<Pos> unionPosList;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        
        map = new int[n][n];
        
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            
            for(int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        int answer = 0;
        
        unionPosList = new ArrayList<>();
        
        while(true) {
            //인접한 나라에 국경을 열수 없다?
            if (check()) {
                break;
            }
            
            visited = new boolean[n][n];
            
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    if (!visited[i][j]) {
                        dfs(i, j);
                        
                        int sum = 0;
                        
                        for(Pos p : unionPosList) {
                            sum += p.number;
                        }
                        
                        int avg = sum / unionPosList.size();
                        
                        for(Pos p : unionPosList) {
                            map[p.x][p.y] = avg;
                        }
                        
                        unionPosList.clear();
                    }
                }
            }
            
            answer += 1;
        }
        
        System.out.print(answer);
        
        br.close();
    }
    
    private static void dfs(int x, int y) {
        visited[x][y] = true;
        
        unionPosList.add(new Pos(x, y, map[x][y]));
        
        for(int i = 0; i < 4; i++) {
            int mx = x + dx[i];
            int my = y + dy[i];
            
            if (mx < 0 || mx >= n || my < 0 || my >= n) {
                continue;
            }
            
            int dist = Math.abs(map[x][y] - map[mx][my]);
            
            if (!visited[mx][my] && l <= dist && dist <= r) {
                dfs(mx, my);
            }
        }
    }
    
    private static boolean check() {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                for(int k = 0; k < 4; k++) {
                    int mx = i + dx[k];
                    int my = j + dy[k];
                    
                    if (mx < 0 || mx >= n || my < 0 || my >= n) {
                        continue;
                    }
                    
                    int dist = Math.abs(map[i][j] - map[mx][my]);
                    
                    if (l <= dist && dist <= r) {
                        return false;
                    }
                }
            }
        }
        
        return true;
    }
}
