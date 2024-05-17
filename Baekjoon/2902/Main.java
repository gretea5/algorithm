import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] arr = br.readLine().split("-");
        
        StringBuilder sb = new StringBuilder();
        
        for(String s : arr) {
            sb.append(s.charAt(0));
        }
        
        System.out.print(sb);
        
        br.close();
    }
}
