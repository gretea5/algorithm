import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        int ax = Integer.parseInt(st.nextToken());
        int ay = Integer.parseInt(st.nextToken());
        int az = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine(), " ");
        
        int cx = Integer.parseInt(st.nextToken());
        int cy = Integer.parseInt(st.nextToken());
        int cz = Integer.parseInt(st.nextToken());
        
        int bx = cx - az;
        int by = cy / ay;
        int bz = cz - ax;
        
        StringBuilder sb = new StringBuilder();
        
        sb.append(bx).append(" ");
        sb.append(by).append(" ");
        sb.append(bz).append(" ");
        
        System.out.print(sb);
        
        br.close();
    }
}
