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

            //a, b입력
            BigInteger a = new BigInteger(st.nextToken());
            BigInteger b = new BigInteger(st.nextToken());

            //최대 공약수
            BigInteger gcd = a.gcd(b);

            //최소공배수 구하기
            sb.append(a.multiply(b).divide(gcd).longValue()).append("\n");
        }

        //출력
        System.out.print(sb);

        br.close();
    }
}
