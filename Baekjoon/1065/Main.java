import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        int answer = 0;
        
        for(int i = 1; i <= n; i++) {
            //등차수열 이루는지 체크
            if (check(i)) {
                answer += 1;
            }
        }
        
        //출력
        System.out.print(answer);
        
        br.close();
    }
    
    private static boolean check(int num) {
        //한자리의 숫자는 무조건 참
        if (num < 10) {
            return true;
        }
        
        //num을 문자 배열 형태로 만든다.
        char[] arr = String.valueOf(num).toCharArray();
        
        //숫자의 차이를 담을 배열
        int[] dist = new int[arr.length - 1];
        
        for(int i = 1; i < arr.length; i++) {
            int c1 = arr[i - 1] - '0';
            int c2 = arr[i] - '0';
            
            dist[i - 1] = c2 - c1;
        }
        
        //n을 꺼낸다.
        int n = dist[0];
        
        //다르다면 등차수열 아님 => false
        for (int i = 1; i < dist.length; i++) {
            if (n != dist[i]) {
                return false;
            }
        }
        
        return true;
    }
}
