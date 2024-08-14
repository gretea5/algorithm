import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        int[] belts = new int[(2 * n) + 1];
        boolean[] robots = new boolean[n + 1];
        
        int answer = 1;
        
        st = new StringTokenizer(br.readLine(), " ");
        
        for (int i = 1; i <= 2 * n; i++) {
            belts[i] = Integer.parseInt(st.nextToken());
        }
        
        while (true) {
            //벨트가 한 칸 움직임
            int beltEnd = belts[2 * n];
            
            for (int i = 2 * n; i > 1; i--) {
                belts[i] = belts[i - 1];
            }
            
            belts[1] = beltEnd;
            
            for (int i = n; i > 1; i--) {
                robots[i] = robots[i - 1];
            }
            
            robots[1] = false;
            robots[n] = false;
            
            //2번 로봇을 이동시키는 로직
            for (int i = n; i > 1; i--) {
                //내가 이전에서 로봇을 이동시켜야 하는데,
                if (!robots[i] && robots[i - 1] && belts[i] >= 1) {
                    robots[i] = true;
                    robots[i - 1] = false;
                    belts[i] -= 1;
                }
            }
            
            //로봇을 움직였을때, 1번과 n번의 로봇은 버려진다.
            robots[1] = false;
            robots[n] = false;
            
            if (belts[1] > 0) {
                robots[1] = true;
                belts[1] -= 1;
            }
            
            int count = 0;
            
            for (int i = 1; i <= 2 * n; i++) {
                if (belts[i] == 0) {
                    count += 1;
                }
            }
            
            if (count >= k) {
                break;
            }

            answer += 1;
        }
        
        System.out.print(answer);
        
        br.close();
    }
}
