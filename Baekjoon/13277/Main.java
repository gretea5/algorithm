import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        String a = st.nextToken();
        String b = st.nextToken();
        
        BigInteger a1 = new BigInteger(a);
        BigInteger b1 = new BigInteger(b);
        
        System.out.print(a1.multiply(b1).toString());
        
        br.close();
    }
}
