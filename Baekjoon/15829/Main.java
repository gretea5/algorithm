import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int length = Integer.parseInt(br.readLine());
        
        char[] arr = br.readLine().toCharArray();
        
        long answer = 0;
        
        for (int i = 0; i < arr.length; i++) {
            long v = (long) (arr[i] - 'a') + 1;
            
            long p = 1;
            
            for (int j = 0; j < i; j++) {
                p *= 31;
                
                p %= 1234567891;
            }
            
            answer += (v * p) % 1234567891;
        }
        
        System.out.print(answer % 1234567891);
        
        br.close();
    }
}
