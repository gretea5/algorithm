import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        BigInteger a = new BigInteger("1");
        
        for(int i = 1; i <= n; i++) {
            BigInteger b = new BigInteger(String.valueOf(i));
            
            a = a.multiply(b);
        }
        
        char[] arr = a.toString().toCharArray();
        
        int answer = 0;
        
        for(int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] != '0') {
                break;
            }
            
            answer += 1;
        }
        
        System.out.print(answer);
        
        br.close();
    }
}
