import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    private static int n;
    private static int m;
    
    private static int[][] board;
    private static boolean[][] cleaned;
    
    private static final int[] dy = {-1, 0, 1, 0};
    private static final int[] dx = {0, 1, 0, -1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine(), " ");
        
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        
        board = new int[n][m];
        cleaned = new boolean[n][m];
        
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            
            for(int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        moveCleaner(r, c, d);
        
        System.out.print(countCleanArea());
        
        br.close();
    }
    
    private static void moveCleaner(int r, int c, int d) {
        //청소 처리
        cleaned[r][c] = true;
        
        if(check(r, c)) {
            for(int i = 0; i < 4; i++) {
                d = (d + 3) % 4;
                
                int my = r + dy[d];
                int mx = c + dx[d];
                
                if (board[my][mx] == 0 && !cleaned[my][mx]) {
                    moveCleaner(my, mx, d);
                    //리턴을 하는 이유는 다시 돌아와서 방향을 트는것이 아니라,
                    //청소를 안한 빈칸을 찾았으면 바로 끝이기 때문이다.
                    return;
                }
            }
        }
        else {
            int rDir = (d + 2) % 4;
            
            int my = r + dy[rDir];
            int mx = c + dx[rDir];
            
            //벽이 아니라면 이동
            if (board[my][mx] != 1) {
                moveCleaner(my, mx, d);
            }
        }
    }
    
    private static boolean check(int x, int y) {
        for(int i = 0; i < 4; i++) {
            int mx = x + dx[i];
            int my = y + dy[i];
            
            //빈칸이면서, 청소하지 않은 구역이 있다면,
            if (board[mx][my] == 0 && !cleaned[mx][my]) {
                return true;
            }
        }
        
        return false;
    }
    
    private static int countCleanArea() {
        int count = 0;
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if (board[i][j] == 0 && cleaned[i][j]) {
                    count += 1;
                }
            }
        }
        
        return count;
    }
}
