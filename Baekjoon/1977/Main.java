import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int m = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        
        int sum = 0;
        int min = Integer.MAX_VALUE;
        
        int num = 1;
        
        while(true) {
            if (num > n) {
                break;
            }
            
            int squareNumber = num * num;
            
            if (m <= squareNumber && squareNumber <= n) {
                min = Math.min(min, squareNumber);
                sum += squareNumber;
            }
            
            num += 1;
        }
        
        if (min == Integer.MAX_VALUE) {
            System.out.print(-1);
            return;
        }
        
        System.out.println(sum);
        System.out.print(min);
        
        br.close();
    }
}
