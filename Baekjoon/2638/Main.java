import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayDeque;

public class Main {
    private static class Pos {
        int x;
        int y;
        
        Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    private static int n, m;
    
    private static int[][] board;
    private static boolean[][] visited;
    
    private static final int[] dx = {1, -1, 0, 0};
    private static final int[] dy = {0, 0, 1, -1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        board = new int[n][m];
        
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            
            for(int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        int answer = 0;
        
        while(!isAllMelted()) {
            checkCheese();
            
            meltCheese();
            
            answer += 1;
        }
        
        System.out.print(answer);
        
        br.close();
    }
    
    private static boolean isAllMelted() {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if (board[i][j] != 0) {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    private static void checkCheese() {
        ArrayDeque<Pos> queue = new ArrayDeque<>();
    
        visited = new boolean[n][m];
        
        queue.addLast(new Pos(0, 0));
        visited[0][0] = true;
        
        while(!queue.isEmpty()) {
            Pos cur = queue.removeFirst();
            
            for(int i = 0; i < 4; i++) {
                int mx = cur.x + dx[i];
                int my = cur.y + dy[i];
                
                if (mx < 0 || mx >= n || my < 0 || my >= m) continue;
                
                if (board[mx][my] != 0) {
                    board[mx][my] += 1;
                    continue;
                }
                
                if (board[mx][my] == 0 && !visited[mx][my]) {
                    queue.addLast(new Pos(mx, my));
                    visited[mx][my] = true;
                }
            }
        }
    }
    
    private static void meltCheese() {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                //두번 이상 인접할 경우,
                if (board[i][j] >= 3) {
                    board[i][j] = 0;
                }
                //한번 인접할 경우 치즈가 녹지않아 1로 변경
                else if (board[i][j] == 2) {
                    board[i][j] = 1;
                }
            }
        }
    }
}
