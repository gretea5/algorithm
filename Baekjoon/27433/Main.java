import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        long answer = 1;
        
        long[] fact = new long[21];
        
        fact[0] = 1;
        fact[1] = 1;
        
        for (int i = 2; i < 21; i++) {
            fact[i] = i * fact[i - 1];
        }
        
        System.out.print(fact[n]);
        
        br.close();
    }
}
