import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        
        int answer = Integer.MAX_VALUE;
        
        answer = Math.min(answer, Math.abs(x - 0));
        answer = Math.min(answer, Math.abs(y - 0));
        
        answer = Math.min(answer, Math.abs(w - x));
        answer = Math.min(answer, Math.abs(h - y));
        
        System.out.print(answer);
        
        br.close();
    }
}
