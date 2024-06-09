import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int sum = 0;
        
        for(int i = 0; i < 4; i++) {
            int v = Integer.parseInt(br.readLine());
            
            sum += v;
        }
        
        int x = sum / 60;
        int y = sum % 60;
        
        System.out.println(x);
        System.out.print(y);
        
        br.close();
    }
}
