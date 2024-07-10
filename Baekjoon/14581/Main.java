import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String name = br.readLine();
        
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < 3; i++) {
            sb.append(":fan:");
        }
        
        sb.append("\n");
        
        sb.append(":fan:");
        sb.append(":").append(name).append(":");
        sb.append(":fan:");
        
        sb.append("\n");
        
        for(int i = 0; i < 3; i++) {
            sb.append(":fan:");
        }
        
        System.out.print(sb);
        
        br.close();
    }
}
