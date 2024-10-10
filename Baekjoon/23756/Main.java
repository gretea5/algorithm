import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        //초기 각도
        int curPos = Integer.parseInt(br.readLine());
        
        //합
        int sum = 0;
        
        for(int i = 0; i < n; i++) {
            //각도 입력
            int angle = Integer.parseInt(br.readLine());
            
            //돌려야 하는 각도 계산
            int r = Math.abs(angle - curPos);
            
            //반대로 돌린 각도와 돌려야하는 각도중에 최소인 값을 더함
            sum += Math.min(r, 360 - r);
            
            //현재 각도 갱신
            curPos = angle;
        }
        
        //출력
        System.out.print(sum);
        
        br.close();
    }
}
