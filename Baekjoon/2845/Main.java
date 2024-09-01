import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        int l = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        
        int person = l * p;
        
        StringBuilder sb = new StringBuilder();
        
        st = new StringTokenizer(br.readLine(), " ");
        
        for (int i = 0; i < 5; i++) {
            int paper = Integer.parseInt(st.nextToken());
            
            sb.append(paper - person).append(" ");
        }
        
        System.out.print(sb);
        
        br.close();
    }
}
