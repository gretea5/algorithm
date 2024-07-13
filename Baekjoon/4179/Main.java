import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayDeque;

class Main {
    private static class Pos {
        int x;
        int y;
        
        Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    private static int r, c;
    
    private static char[][] board;
    
    private static final int[] dx = {1, -1, 0, 0};
    private static final int[] dy = {0, 0, 1, -1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        
        board = new char[r][c];
        
        ArrayDeque<Pos> jihunQueue = new ArrayDeque<>();
        ArrayDeque<Pos> fireQueue = new ArrayDeque<>();
        
        for(int i = 0; i < r; i++) {
            String s = br.readLine();
            
            for(int j = 0; j < c; j++) {
                board[i][j] = s.charAt(j);
                
                //지훈이의 위치를 넣기
                if (board[i][j] == 'J') {
                    jihunQueue.addLast(new Pos(i, j));
                }
                
                //불의 위치를 넣기
                if (board[i][j] == 'F') {
                    fireQueue.addLast(new Pos(i, j));
                }
            }
        }
        
        int time = 1;
        
        while(true) {
            //불을 담고 있는 큐의 크기를 꺼냄
            int fSize = fireQueue.size();
            
            for(int k = 0; k < fSize; k++) {
                Pos cur = fireQueue.removeFirst();
                
                int cx = cur.x;
                int cy = cur.y;
                
                for(int i = 0; i < 4; i++) {
                    int mx = cx + dx[i];
                    int my = cy + dy[i];
                    
                    if (mx < 0 || mx >= r || my < 0 || my >= c) {
                        continue;
                    }
                    
                    if (board[mx][my] != '#' && board[mx][my] != 'F') {
                        board[mx][my] = 'F';
                        fireQueue.addLast(new Pos(mx, my));
                    }
                }
            }
            
            int jSize = jihunQueue.size();
            
            for(int k = 0; k < jSize; k++) {
                Pos cur = jihunQueue.removeFirst();
                
                int cx = cur.x;
                int cy = cur.y;
                
                for(int i = 0; i < 4; i++) {
                    int mx = cx + dx[i];
                    int my = cy + dy[i];
                    
                    if (mx < 0 || mx >= r || my < 0 || my >= c) {
                        System.out.print(time);
                        return;
                    }
                    
                    if (board[mx][my] == '.') {
                        board[mx][my] = 'J';
                        jihunQueue.addLast(new Pos(mx, my));
                    }
                }
            }
            
            if (jihunQueue.isEmpty()) {
                break;
            }
            
            time += 1;
        }
        
        System.out.print("IMPOSSIBLE");
    }
}
