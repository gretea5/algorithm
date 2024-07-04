import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    private static int n;
    private static int m;
    private static int sum;
    
    private static int[][] map;
    
    public static void main(String[] args) throws IOException {
        final int[] dx1 = {1, -1, 0, 0};
        final int[] dy1 = {0, 0, 1, -1};
        
        final int[] dx2 = {1, -1, 1, -1};
        final int[] dy2 = {1, -1, -1, 1};
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int t = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        
        for(int test = 1; test <= t; test++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            
            map = new int[n][n];
            
            for(int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                
                for(int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            
            int answer = Integer.MIN_VALUE;
            
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    sum = map[i][j];
                    
                    for(int d = 0; d < 4; d++) {
                        kill(i, j, d, dx1, dy1, 0);
                    }
                    
                    answer = Math.max(answer, sum);
                }
            }
            
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    sum = map[i][j];
                    
                    for(int d = 0; d < 4; d++) {
                        kill(i, j, d, dx2, dy2, 0);
                    }
                    
                    answer = Math.max(answer, sum);
                }
            }
            
            sb.append("#").append(test).append(" ");
            sb.append(answer).append("\n");
        }
        
        System.out.print(sb);
        
        br.close();
    }
    
    private static void kill(int x, int y, int d, int[] dx, int[] dy, int depth) {
        if (depth == m - 1)  {
            return;
        }
        
        int mx = x + dx[d];
        int my = y + dy[d];
        
        if (mx < 0 || mx >= n || my < 0 || my >= n) {
            return;
        }
        
        //벗어나지 않은 경우,
        sum += map[mx][my];
        
        kill(mx, my, d, dx, dy, depth + 1);
    }
}
