import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        
        for (int t = 1; t <= n; t++) {
            String str = "";
            
            if (t % 2 == 1) {
                str = "* ";
            }
            else {
                str = " *";
            }
            
            for(int i = 0; i < n; i++) {
                sb.append(str);
            }
            
            sb.append("\n");
        }
        
        System.out.print(sb);
        
        br.close();
    }
}
