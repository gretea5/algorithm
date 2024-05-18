import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    private static int n;
    private static int m;
    private static int b;
    
    private static int[][] board;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        
        board = new int[n][m];
        
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            
            for(int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                
                min = Math.min(min, board[i][j]);
                max = Math.max(max, board[i][j]);
            }
        }
        
        int maxHeight = -1;
        int minTime = Integer.MAX_VALUE;
        
        //h 높이를 가지는 걸 평탄화를 수행한다고 치자.
        for(int h = max; h >= min; h--) {
            int time = 0;
            int copyB = b;
            
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) {
                    int height = board[i][j];
                    
                    //블록을 제거해  인벤토리에 넣어야지(2초)
                    if (height > h) {
                        time += (height - h) * 2;
                        copyB += (height - h);
                    }
                    //인벤토리에서 블록을 꺼내 채운다.(1초)
                    else if (height < h) {
                        time += (h - height);
                        copyB -= (h - height);
                    }
                }
            }
            
            if (copyB < 0) {
                continue;
            }
            
            if (minTime > time) {
                maxHeight = h;
                minTime = time;
            }
        }
        
        System.out.print(minTime + " " + maxHeight);
        
        br.close();
    }
}
