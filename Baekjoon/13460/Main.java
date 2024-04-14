import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    private static class Ball {
        int rx;
        int ry;
        int bx;
        int by;
        int cnt;
        
        Ball(int ry, int rx, int by, int bx, int cnt) {
            this.rx = rx;
            this.ry = ry;
            this.bx = bx;
            this.by = by;
            this.cnt = cnt;
        }
    }
    
    private static int n;
    private static int m;
    
    private static boolean[][][][] visited;
    private static char[][] board;
    
    private static final int[] dy = {-1, 0, 1, 0};
    private static final int[] dx = {0, -1, 0, 1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        board = new char[n][m];
        visited = new boolean[n][m][n][m];
        
        int rx = -1;
        int ry = -1;
        
        int bx = -1;
        int by = -1;
        
        for(int i = 0; i < n; i++) {
            String str = br.readLine();
            
            for(int j = 0; j < m; j++) {
                char ch = str.charAt(j);
                
                if (ch == 'R') {
                    ry = i;
                    rx = j;
                }
                else if (ch == 'B') {
                    by = i;
                    bx = j;
                }
                
                board[i][j] = ch;
            }
        }
        
        int answer = bfs(ry, rx, by, bx);
        
        System.out.print(answer);
        
        br.close();
    }
    
    private static int bfs(int ry, int rx, int by, int bx) {
        ArrayDeque<Ball> queue = new ArrayDeque<>();
        
        queue.addLast(new Ball(ry, rx, by, bx, 0));
        visited[ry][rx][by][bx] = true;
        
        while(!queue.isEmpty()) {
            Ball cur = queue.removeFirst();
            
            if (cur.cnt >= 10) {
                return -1;
            }
            
            for(int dir = 0; dir < 4; dir++) {
                boolean redBallOut = false;
                boolean blueBallOut = false;
                
                int moveRy = cur.ry;
                int moveRx = cur.rx;
                
                while(board[moveRy + dy[dir]][moveRx + dx[dir]] != '#') {
                    moveRy += dy[dir];
                    moveRx += dx[dir];
                    
                    if (board[moveRy][moveRx] == 'O') {
                        redBallOut = true;
                        break;
                    }
                }
                
                int moveBy = cur.by;
                int moveBx = cur.bx;
                
                while(board[moveBy + dy[dir]][moveBx + dx[dir]] != '#') {
                    moveBy += dy[dir];
                    moveBx += dx[dir];
                    
                    if (board[moveBy][moveBx] == 'O') {
                        blueBallOut = true;
                        break;
                    }
                }
                
                //즉 파란색 공이 나갔을때 -1
                if (blueBallOut) {
                    continue;
                }
                
                //빨간색 공이 나갔을때, 
                if (redBallOut && !blueBallOut) {
                    return cur.cnt + 1;
                }
                
                
                //구슬을 이동했을때, 좌표가 동일하다면? 전 좌표를 비교
                if (moveRy == moveBy && moveRx == moveBx) {
                    //위쪽 방향이라면, 원래 컸던 y였던 애가 +1이 되어야함
                    if (dir == 0) {
                        if (cur.ry < cur.by) {
                            moveBy += 1;
                        }
                        else {
                            moveRy += 1;
                        }
                        
                    }
                    //왼쪽 방향이라면, 원래 컸던 x였던 애가 +1이 되어야함
                    else if (dir == 1) {
                        if (cur.rx < cur.bx) {
                            moveBx += 1;
                        }
                        else {
                            moveRx += 1;
                        }
                    }
                    //아래쪽 방향이라면, 원래 작았던 y였던 애가 -1이 되어야함
                    else if (dir == 2) {
                        if (cur.ry < cur.by) {
                            moveRy -= 1;
                        }
                        else {
                            moveBy -= 1;
                        }
                    }
                    //오른쪽 방향이라면, 원래 작았던 x였던 애가 -1이 되어야함
                    else {
                        if (cur.rx < cur.bx) {
                            moveRx -= 1;
                        }
                        else {
                            moveBx -= 1;
                        }
                    }
                }
                
                //그러면 움직인 빨간, 파란 구슬의 좌표를 다 가졌음.
                if (!visited[moveRy][moveRx][moveBy][moveBx]) {
                    queue.addLast(new Ball(moveRy, moveRx, moveBy, moveBx, cur.cnt + 1));
                    visited[moveRy][moveRx][moveBy][moveBx] = true;
                }
            }
        }
        
        return -1;
    }
}
