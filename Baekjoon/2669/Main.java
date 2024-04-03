import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    private static int[][] board;
    private static boolean[][] visited;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        board = new int[101][101];
        visited = new boolean[101][101];
        
        for(int t = 0; t < 4; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            
            for(int i = x1; i < x2; i++) {
                for(int j = y1; j < y2; j++) {
                    visited[i][j] = true;
                }
            }
        }
        
        int cnt = 0;
        
        for(int i = 0; i < 101; i++) {
            for(int j = 0; j < 101; j++) {
                if (visited[i][j]) cnt += 1;
            }
        }
        
        System.out.print(cnt);
        
        br.close();
    }
}
