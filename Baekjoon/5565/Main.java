import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int answer = Integer.parseInt(br.readLine()); 
        
        for(int i = 0; i < 9; i++) {
            int v = Integer.parseInt(br.readLine());
            
            answer -= v;
        }
        
        System.out.print(answer);
        
        br.close();
    }
}
