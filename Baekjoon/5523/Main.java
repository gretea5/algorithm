import java.io.BufferedReader;
import java.io.InputStreamReader; 
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        int aWinCount = 0;
        int bWinCount = 0;
        
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            if (a > b) {
                aWinCount += 1;
            }
            else if (a < b) {
                bWinCount += 1;
            }
        }
        
        System.out.print(aWinCount + " " + bWinCount);
        
        br.close();
    }
}
