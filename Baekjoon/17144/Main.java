import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    private static int upperX;
    private static int upperY;
    private static int lowerX;
    private static int lowerY;
    
    private static int r;
    private static int c;
    
    private static int[][] board;
    
    private static final int[] dx = {0, -1, 0, 1};
    private static final int[] dy = {1, 0, -1, 0};
    
    private static final int[] dx1 = {0, 1, 0, -1};
    private static final int[] dy1 = {1, 0, -1, 0};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        
        board = new int[r][c];
        
        boolean isUpper = true;
        
        for(int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            
            for(int j = 0; j < c; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                
                if (board[i][j] == -1 && isUpper) {
                    upperX = i;
                    upperY = j;
                    isUpper = false;
                }
                else if (board[i][j] == -1 && !isUpper) {
                    lowerX = i;
                    lowerY = j;
                }
            }
        }
        
        while(t > 0) {
            //미세 먼지를 퍼트리는 로직
            spread();
            
            //순환시키기
            rotate();
            
            t -= 1;
        }
        
        int answer = 0;
        
        //남아있는 미세먼지 양
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                if (board[i][j] > 0) {
                    answer += board[i][j];
                }
            }
        }
    
        System.out.print(answer);
        
        br.close();
    }
    
    private static void spread() {
        //새로운 배열 만들기,
        int[][] copyBoard = new int[r][c];
        
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                if (board[i][j] > 0) {
                    //확산 방향 개수
                    int cnt = 0;
                    
                    //확산 양
                    int div = board[i][j] / 5;
                    
                    for(int k = 0; k < 4; k++) {
                        int mx = i + dx[k];
                        int my = j + dy[k];
                        
                        if (mx < 0 || mx >= r || my < 0 || my >= c || board[mx][my] == -1) {
                            continue;
                        }
                        
                        copyBoard[mx][my] += div;
                        
                        cnt += 1;
                    }
                    
                    //남은 미세먼지양
                    board[i][j] -= (div * cnt);
                    
                    //남은 미세먼지양만큼 더해주기,
                    copyBoard[i][j] += board[i][j];
                }
            }
        }
        
        //배열 갱신
        board = copyBoard;
    }
    
    private static void rotate() {
        //테두리만 바뀌니까, 일단 배열을 복사해서 가져오고, 테두리 값만 변경
        int[][] copyBoard = copyArr(board);
        
        int dir = 0;
        
        //시작점(위)
        int curX = upperX + dx[dir];
        int curY = upperY + dy[dir];
        
        //무조건 비는자리
        copyBoard[curX][curY] = 0;
        
        //반시계방향 회전
        while(true) {
            if (curX == upperX && curY == upperY) {
                break;
            }
            
            int mx = curX + dx[dir];
            int my = curY + dy[dir];
            
            if (mx < 0 || mx >= r || my < 0|| my >= c) {
                dir = (dir + 1) % 4;
                
                mx = curX + dx[dir];
                my = curY + dy[dir];
            }
            
            copyBoard[mx][my] = board[curX][curY];
            
            curX = mx;
            curY = my;
        }
        
        dir = 0;
        
        //시작점(아래)
        curX = lowerX + dx1[dir];
        curY = lowerY + dy1[dir];
        
        //무조건 비는자리
        copyBoard[curX][curY] = 0;
        
        //시계 방향 회전
        while(true) {
            if (curX == lowerX && curY == lowerY) {
                break;
            }
            
            int mx = curX + dx1[dir];
            int my = curY + dy1[dir];
            
            if (mx < 0 || mx >= r || my < 0|| my >= c) {
                dir = (dir + 1) % 4;
                
                mx = curX + dx1[dir];
                my = curY + dy1[dir];
            }
            
            copyBoard[mx][my] = board[curX][curY];
            
            curX = mx;
            curY = my;
        }
        
        //공기청정기 표시
        copyBoard[upperX][upperY] = -1;
        copyBoard[lowerX][lowerY] = -1;
        
        //배열 갱신
        board = copyBoard;
    }
    
    //배열 깊은 복사 
    private static int[][] copyArr(int[][] arr) {
        int[][] copyBoard = new int[r][c];
        
        for(int i = 0; i < r; i++) {
            copyBoard[i] = arr[i].clone();
        }
        
        return copyBoard;
    }
}
