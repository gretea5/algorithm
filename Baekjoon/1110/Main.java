import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String s = br.readLine();
        
        //수가 10보다 작다면 앞에 0을 붙임
        if (s.length() == 1) {
            s = "0" + s;
        }
        
        int o1 = s.charAt(0) - '0';
        int o2 = s.charAt(1) - '0';
        
        int c1 = o1;
        int c2 = o2;
        
        int answer = 0;
        
        while(true) {
            int sum = (c1 + c2) % 10;
            
            c1 = c2;
            c2 = sum;
            
            answer += 1;
            
            if (o1 == c1 && o2 == c2) {
                break;
            }
        }
        
        System.out.print(answer);
        
        br.close();
    }
}
