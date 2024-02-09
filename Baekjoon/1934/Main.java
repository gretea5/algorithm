import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for(int test = 0; test < T; test++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            BigInteger A = new BigInteger(st.nextToken());
            BigInteger B = new BigInteger(st.nextToken());

            sb.append(A.multiply(B).divide(A.gcd(B)).intValue()).append("\n");
        }

        System.out.print(sb);

        br.close();
    }
}
