import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    private static int n;
    private static int answer;
    
    private static char[][] board;
    private static boolean[][] visited;
    
    private static final int[] dx = {1, 0, -1, 0};
    private static final int[] dy = {0, 1, 0, -1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        
        board = new char[n][n];
        
        for(int i = 0; i < n; i++) {
            String s = br.readLine();
            
            for(int j = 0; j < n; j++) {
                board[i][j] = s.charAt(j);
            }
        }
        
        answer = Integer.MIN_VALUE;
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                char cur = board[i][j];
                
                for(int k = 0; k < 4; k++) {
                    int mx = i + dx[k];
                    int my = j + dy[k];
                    
                    if (mx < 0 || mx >= n || my < 0 || my >= n) {
                        continue;
                    }
                    
                    if (cur != board[mx][my]) {
                        char temp = board[i][j];
                        board[i][j] = board[mx][my];
                        board[mx][my] = temp;
                        
                        find();
                        
                        temp = board[i][j];
                        board[i][j] = board[mx][my];
                        board[mx][my] = temp;
                    }
                }
            }
        }
        
        System.out.print(answer);
        
        br.close();
    }
    
    private static void find() {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                char cur = board[i][j];
                
                for(int k = 0; k < 4; k++) {
                    int mx = i + dx[k];
                    int my = j + dy[k];
                    
                    if (mx < 0 || mx >= n || my < 0 || my >= n) {
                        continue;
                    }
                    
                    if (cur == board[mx][my]) {
                        dfs(i, j, k, 1);
                    }
                }
            }
        }
    }
    
    private static void dfs(int x, int y, int d, int depth) {
        answer = Math.max(answer, depth);
        
        int mx = x + dx[d];
        int my = y + dy[d];
        
        if (mx < 0 || mx >= n || my < 0 || my >= n) {
            return;
        }
        
        if (board[x][y] == board[mx][my]) {
            dfs(mx, my, d, depth + 1);
        }
    }
}
