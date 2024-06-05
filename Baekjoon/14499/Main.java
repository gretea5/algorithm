import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    private static int n;
    private static int m;
    private static int x;
    private static int y;
    
    private static int[][] board;
    private static int[] dice;
    
    private static final int[] dx = {0, 0, -1, 1};
    private static final int[] dy = {1, -1, 0, 0};
    
    private static StringBuilder sb;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        board = new int[n][m];
        dice = new int[7];
        
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            
            for(int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        st = new StringTokenizer(br.readLine(), " ");
        
        sb = new StringBuilder();
        
        while(k > 0) {
            int dir = Integer.parseInt(st.nextToken());
            
            rotate(dir);
            
            k -= 1;
        }
        
        System.out.print(sb.toString());
        
        br.close();
    }
    
    private static void rotate(int dir) {
        int mx = x + dx[dir - 1];
        int my = y + dy[dir - 1];
        
        //가지 못할 경우,
        if (mx < 0 || mx >= n || my < 0 || my >= m) {
            return;
        }
        
        int temp = dice[3];
        
        //동쪽
        if (dir == 1) {
            dice[3] = dice[2];
            dice[2] = dice[6];
            dice[6] = dice[4];
            dice[4] = temp;
        }
        //서쪽
        else if (dir == 2) {
            dice[3] = dice[4];
            dice[4] = dice[6];
            dice[6] = dice[2];
            dice[2] = temp;
        }
        //북쪽
        else if (dir == 3) {
            dice[3] = dice[5];
            dice[5] = dice[6];
            dice[6] = dice[1];
            dice[1] = temp;
        }
        //남쪽
        else {
            dice[3] = dice[1];
            dice[1] = dice[6];
            dice[6] = dice[5];
            dice[5] = temp;
        }
        
        if (board[mx][my] != 0)  {
            dice[6] = board[mx][my];
            board[mx][my] = 0;
        }
        else {
            board[mx][my] = dice[6];
        }
        
        //현재 위치 갱신
        x = mx;
        y = my;
        
        sb.append(dice[3]).append("\n");
    }
}
