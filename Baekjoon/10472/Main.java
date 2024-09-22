import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    private static int answer;
    
    private static boolean[][] targetBoard;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int t = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        
        while (t > 0) {
            boolean[][] board = new boolean[3][3];
            
            targetBoard = new boolean[3][3];
            
            for(int i = 0; i < 3; i++) {
                String s = br.readLine();
                
                for(int j = 0; j < 3; j++) {
                    targetBoard[i][j] = s.charAt(j) == '*' ? true : false;
                }
            }
            
            answer = Integer.MAX_VALUE;
            
            backTrack(board, 0, 0);
            
            sb.append(answer).append("\n");
            
            t -= 1;
        }
        
        System.out.print(sb);
        
        br.close();
    }
    
    private static void backTrack(boolean[][] board, int idx, int click) {
        if (check(board)) {
            answer = Math.min(answer, click);
            return;
        }
        
        if (idx >= 9 || answer < click) {
            return;
        }
        
        backTrack(board, idx + 1, click);
        
        int row = idx / 3;
        int col = idx % 3;
        
        click(row, col, board);
        
        backTrack(board, idx + 1, click + 1);
        
        click(row, col, board);
    }
    
    private static boolean check(boolean[][] board) {
        for (int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if (board[i][j] != targetBoard[i][j]) {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    private static void click(int x, int y, boolean[][] board) {
        final int[] dx = {1, -1, 0, 0, 0};
        final int[] dy = {0, 0, 1, -1, 0};
        
        for (int i = 0; i < 5; i++) {
            int mx = x + dx[i];
            int my = y + dy[i];
            
            if (mx < 0 || mx >= 3 || my < 0 || my >= 3) {
                continue;
            }
            
            board[mx][my] = !board[mx][my];
        }
    }
}
