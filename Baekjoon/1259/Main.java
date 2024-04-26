import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringBuilder sb = new StringBuilder();
        
        while(true) {
            String s = br.readLine();
            if (s.equals("0")) {
                break;
            }
            
            String rs = new StringBuilder(s).reverse().toString();
            
            if(rs.equals(s)) {
                sb.append("yes").append("\n");
            }
            else {
                sb.append("no").append("\n");
            }
        }
        
        System.out.print(sb);
        
        br.close();
    }
}
