import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    private static int[][] map;
    
    private static int answer;
    private static boolean isAnswer;
    private static int n, h;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        
        map = new int[h + 1][n + 1];
        
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            //선을 그을때, 왼쪽을 1로 오른쪽을 2로 한다.
            map[a][b] = 1;
            map[a][b + 1] = 2;
        }
        
        isAnswer = false;
        
        for(answer = 0; answer <= 3; answer++) {
            //즉 정답은 0~3이 되고 그게 아니라면 -1을 출력하면 된다.
            drawLine(1, 0);
            
            if (isAnswer) break;
        }
        
        //정답이 있다면, answer출력 그게 아니라면 -1 출력
        System.out.print(isAnswer ? answer : -1);
        
        br.close();
    }

    private static void drawLine(int x, int depth) {
        //정답이 나왔다면,
        if(isAnswer) {
            return;
        }
        
        //answer만큼 선을 그으면 
        if (answer == depth) {
            //사다리가 제대로 가는지 체크를 해본다.
            if (check()) isAnswer = true;
            return;
        }
        
        for(int i = x; i <= h; i++) {
            for(int j = 0; j < n; j++) {
                //즉 내가 선을 그을 수 있다면,
                if (map[i][j] == 0 && map[i][j + 1] == 0) {
                    map[i][j] = 1;
                    map[i][j + 1] = 2;
                    
                    drawLine(i, depth + 1);
                    
                    map[i][j] = 0;
                    map[i][j + 1] = 0;
                }
            }
        }
    }
    
    private static boolean check() {
        for(int i = 1; i <= n; i++) {
            //시작점을 지정(n: 세로줄)
            int x = 1; 
            int y = i;
            
            for(int k = 1; k <= h; k++) {
                //선이 그어져 있을 경우, y를 이동시킨다.
                if (map[x][y] == 1) y += 1;
                else if (map[x][y] == 2) y -= 1;
                
                x += 1;
            }
            
            //이동을 했는데 세로줄이 다르다.
            if (y != i) {
                return false;
            }
        }
        //저 루프에서 false가 아니라면 i에서 i가 나온다는 의미,
        return true;
    }
}
