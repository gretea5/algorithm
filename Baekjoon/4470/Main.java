import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        
        for(int i = 1; i <= n; i++) {
            String s = br.readLine();
            sb.append(i).append(". ").append(s).append("\n");
        }
        
        System.out.print(sb);
        
        br.close();
    }
}
