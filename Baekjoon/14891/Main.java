import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    private static int[][] gears;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        gears = new int[4][8];
        
        for(int i = 0; i < 4; i++) {
            char[] arr = br.readLine().toCharArray();
            
            for(int j = 0; j < 8; j++) {
                gears[i][j] = arr[j] - '0';
            }
        }
        
        int k = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            
            int num = Integer.parseInt(st.nextToken()) - 1;
            int dir = Integer.parseInt(st.nextToken());
            
            command(num, dir);
        }
        
        int answer = 0;
        
        for(int i = 0; i < 4; i++) {
            if (gears[i][0] == 1) {
                int score = (int) Math.pow(2, i);
                
                answer += score;
            }
        }
        
        System.out.print(answer);
        
        br.close();
    }
    
    private static void command(int num, int dir) {
        //반대 방향
        int rDir = dir == 1 ? -1 : 1;
        
        //왼쪽 부분 회전
        leftRoll(num - 1, rDir);
        
        //오른쪽 부분 회전
        rightRoll(num + 1, rDir);
        
        //왼쪽, 오른쪽 부분 다 회전시키고 돌리기
        roll(num, dir);
    }
    
    private static void leftRoll(int num, int dir) {
        //역방향
        int rDir = dir == 1 ? -1 : 1;
        
        //끝 부분에 도달했을 경우, 
        if (num < 0) {
            return;
        }
        
        //자신의 오른쪽 부분과 오른쪽의 왼쪽부분이 다르다면,
        if (gears[num][2] != gears[num + 1][6]) {
            //역방향으로 회전
            leftRoll(num - 1, rDir);
            
            roll(num, dir);
        }
    }
    
    private static void rightRoll(int num, int dir) {
        //역방향
        int rDir = dir == 1 ? -1 : 1;
        
        //오른쪽 끝 부분
        if (num > 3) {
            return;
        }
        
        //자신의 왼쪽부분이과 왼쪽의 오른쪽 부분이 다르다면,
        if (gears[num][6] != gears[num - 1][2]) {
            rightRoll(num + 1, rDir);
            
            roll(num, dir);
        }
    }
    
    private static void roll(int num, int dir) {
        //시계방향
        if (dir == 1) {
            int temp = gears[num][7];
            
            for(int i = 7; i > 0; i--) {
                gears[num][i] = gears[num][i - 1];
            }
            
            gears[num][0] = temp;
        }
        //반시계 방향
        else {
            int temp = gears[num][0];
            
            for(int i = 0; i < 7; i++) {
                gears[num][i] = gears[num][i + 1];
            }
            
            gears[num][7] = temp;
        }
    }
}
