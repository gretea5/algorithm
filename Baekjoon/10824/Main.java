import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        String a = st.nextToken();
        String b = st.nextToken();
        String c = st.nextToken();
        String d = st.nextToken();
        
        long ab = Long.parseLong(a + b);
        long cd = Long.parseLong(c + d);
        
        System.out.print(ab + cd);
        
        br.close();
    }
}
