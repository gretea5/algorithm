import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int t = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        
        for(int test = 1; test <= t; test++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
            int c = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            
            int childCandy = c / v;
            int dadCandy = c % v;
            
            sb.append("You get " + childCandy + " piece(s) and your dad gets "+ dadCandy + " piece(s).");
            sb.append("\n");
        }
        
        System.out.print(sb);
        
        br.close();
    }
}
