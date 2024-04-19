import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        int[] arr = new int[n];
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int beforeScore = 0;
        int answer = 0;
        
        for(int result : arr) {
            //0이라면 beforeScore를 0으로 초기화
            if (result == 0) {
                beforeScore = 0;
            }
            //맞았다면,
            else {
                //이전 점수를 1을 증가하고,
                beforeScore += 1;
                
                //더한다.
                answer += beforeScore;
            }
        }
        
        System.out.print(answer);
        
        br.close();
    }
}
