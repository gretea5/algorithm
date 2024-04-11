import java.io.BufferedReader;
import java.io.InputStreamReader; 
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    private static class Horse {
        int x;
        int y;
        int dir;
        
        Horse(int x, int y, int dir) {
            this.x = x;
            this.y = y;
            this.dir = dir;
        }
    }
    
    private static int n, k;
    
    private static final int[] dx = {0, 0, -1, 1};
    private static final int[] dy = {1, -1, 0, 0};
    
    private static int[][] board;
    private static ArrayList<Integer>[][] horseNums;
    
    private static Horse[] arr;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        
        board = new int[n][n];
        horseNums = new ArrayList[n][n];
        arr = new Horse[k];
        
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            
            for(int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                horseNums[i][j] = new ArrayList<>();
            }
        }
        
        for(int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int dir = Integer.parseInt(st.nextToken()) - 1;
            
            arr[i] = new Horse(x, y, dir);
            
            horseNums[x][y].add(i);
        }
        
        for(int time = 1; time <= 1000; time++) {
            //모든 점들을 움직인다.
            for(int num = 0; num < k; num++) {
                int x = arr[num].x;
                int y = arr[num].y;
                
                int dir = arr[num].dir;
                int numIdx = searchNumsIdx(x, y, num);
                
                int mx = x + dx[dir];
                int my = y + dy[dir];
                
                //즉 현재 말에서 다음 움직일 곳이 파란색이나 끝부분이라면,
                if (mx < 0 || mx >= n || my < 0 || my >= n || board[mx][my] == 2) {
                    //방향을 변경한 값
                    dir = changeDir(dir);
                    
                    //방향 변경 값 갱신
                    arr[num].dir = dir;
                    
                    //방향을 변경했으니 움직일 부분을 다시 구한다.
                    mx = x + dx[dir];
                    my = y + dy[dir];
                    
                    //또 파란색이나 끝부분이라면 움직이지 않는다.
                    if (mx < 0 || mx >= n || my < 0 || my >= n || board[mx][my] == 2) {
                        continue;
                    }
                }
                
                while(horseNums[x][y].size() != numIdx) {
                    //옮겨질 말들의 번호
                    int removeNum = -1;
                    //흰색일 경우,
                    if (board[mx][my] == 0) {
                        removeNum = horseNums[x][y].remove(numIdx);
                    }
                    //빨간색일 경우,
                    else {
                        removeNum = horseNums[x][y].remove(horseNums[x][y].size() - 1);
                    }
                    
                    arr[removeNum].x = mx;
                    arr[removeNum].y = my;
                    
                    horseNums[mx][my].add(removeNum);
                }
                
                if (horseNums[mx][my].size() >= 4) {
                    System.out.print(time);
                    return;
                }
            }
        }
        
        System.out.print(-1);
        
        br.close();
    }
    
    private static int searchNumsIdx(int x, int y, int num) {
        for(int i = 0; i < horseNums[x][y].size(); i++) {
            if (horseNums[x][y].get(i) == num) {
                return i;
            }
        }
        
        return -1;
    }
    
    private static int changeDir(int dir) {
        if (dir == 0) {
            return 1;
        }
        else if (dir == 1) {
            return 0;
        }
        else if (dir == 2) {
            return 3;
        }
        else {
            return 2;
        }
    }
}
