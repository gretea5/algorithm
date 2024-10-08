import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayDeque;

public class Main {
    //위치, 벽 부순 횟수
    private static class Pos {
        int x;
        int y;
        int wallCount;
        
        Pos(int x, int y, int wallCount) {
            this.x = x;
            this.y = y;
            this.wallCount = wallCount;
        }
    }
    
    private static int n, blackCount;
    
    private static char[][] board;
    private static boolean[][][] visited;
    
    private static final int[] dx = {1, -1, 0, 0};
    private static final int[] dy = {0, 0, 1, -1};
    
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        
        board = new char[n][n];
        
        //검정색 칸 갯수
        blackCount = 0;
        
        //배열 입력하면서 검정색 칸 세기
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            
            for(int j = 0; j < n; j++) {
                board[i][j] = s.charAt(j);
                
                if (board[i][j] == '0') {
                    blackCount += 1;
                }
            }
        }
        
        //bfs호출 (0, 0) 시작
        System.out.print(bfs(0, 0));
        
        br.close();
    }
    
    private static int bfs(int sx, int sy) {
        //방문 배열 초기화
        visited = new boolean[n][n][blackCount + 1];
        
        //큐
        ArrayDeque<Pos> queue = new ArrayDeque<>();
        
        //시작점 처리
        queue.addLast(new Pos(sx, sy, 0));
        visited[sx][sy][0] = true;
        
        //최솟값
        int min = Integer.MAX_VALUE;
        
        while (!queue.isEmpty()) {
            //현재 정점의 위치와 벽 부순 횟수
            Pos cur = queue.removeFirst();
            
            int x = cur.x;
            int y = cur.y;
            int wallCount = cur.wallCount;
            
            //최솟값보다 현재 정점이 같거나 크면 볼 필요도 없음(최적화)
            if (min <= wallCount) {
                continue;
            }
            
            //목적지 도달했다면, 벽 부순 횟수 최솟값 갱신(여기에서는 최솟값보다 작은 부순 횟수만 나옴)
            if (x == n - 1 && y == n - 1) {
                min = Math.min(min, wallCount);
                continue;
            }
            
            //움직이기
            for (int i = 0; i < 4; i++) {
                int mx = x + dx[i];
                int my = y + dy[i];
                
                if (mx < 0 || mx >= n || my < 0 || my >= n) continue;
                
                //움직인 칸이 검정색일 경우,
                if (board[mx][my] == '0')  {
                    if (wallCount + 1 <= blackCount && !visited[mx][my][wallCount + 1]) {
                        queue.addLast(new Pos(mx, my, wallCount + 1));
                        visited[mx][my][wallCount + 1] = true;
                    }
                }
                //움직인 칸이 흰색 칸일 경우,
                else {
                    if (!visited[mx][my][wallCount]) {
                        queue.addLast(new Pos(mx, my, wallCount));
                        visited[mx][my][wallCount] = true;
                    }
                }
            }
        }
        
        return min;
    }
}
