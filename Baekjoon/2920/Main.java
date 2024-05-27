import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String s = br.readLine().trim();
        
        StringBuilder sb = new StringBuilder();
        
        for(int i = 1; i <= 8; i++) {
            sb.append(i).append(" ");
        }
        
        String as = sb.toString().trim();
        String des = sb.reverse().toString().trim();
        
        String answer = "";
        
        if (s.equals(as)) {
            answer = "ascending";
        }
        else if (s.equals(des)) {
            answer = "descending";
        }
        else {
            answer = "mixed";
        }
        
        System.out.print(answer);
        
        br.close();
    }
}
