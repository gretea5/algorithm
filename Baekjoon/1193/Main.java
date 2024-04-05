import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int x = Integer.parseInt(br.readLine());
        
        int n = 1;
        
        //시그마 공식을 이용해 n이 x보다 같거나 클 경우를 찾는다.(그 경우가 분모의 최댓값)
        while(true) {
            int sum = (n * (n + 1)) / 2;
            
            if (sum >= x) {
                break;
            }
            
            n += 1;
        }
        
        //이전 수
        int before = n - 1;
        
        //n - 1의 합을 구한다.
        int beforeSum = (before * (before + 1)) / 2;
        
        //차이를 구한다(분모에서 뺄 값, 더할 값)
        int distance = x - beforeSum - 1;
        
        //출력
        StringBuilder sb = new StringBuilder();
        
        //짝수일때, 분모가 아래
        if(n % 2 == 0) {
            sb.append(1 + distance).append("/").append(n - distance);
        }
        //홀수일때, 분모가 위
        else {
            sb.append(n - distance).append("/").append(1 + distance);
        }
        
        System.out.print(sb);
        
        br.close();
    }
}
