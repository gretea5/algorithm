import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        String x = st.nextToken();
        String y = st.nextToken();
        
        String revX = new StringBuilder(x).reverse().toString();
        String revY = new StringBuilder(y).reverse().toString();
        
        int n = Integer.parseInt(revX) + Integer.parseInt(revY);
        
        String s = new StringBuilder(String.valueOf(n)).reverse().toString();
        
        int answer = Integer.parseInt(s);
        
        System.out.print(answer);
        
        br.close();
    }
}
