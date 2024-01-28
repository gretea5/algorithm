import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        //a, b, c 입력
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        long c = Long.parseLong(st.nextToken());

        //출력
        System.out.print(remainder(a, b, c));

        br.close();
    }

    private static long remainder(long a, long b, long c) {
        //지수가 1일 경우
        if(b == 1) {
            return a % c;
        }
        else {
            //절반 제곱의 값을 구한다.
            long halfRemainder = remainder(a, b / 2, c);

            //지수가 홀수일 경우
            if(b % 2 == 1) {
                return (halfRemainder * halfRemainder % c) * a % c;
            }

            //지수가 짝수일 경우
            return halfRemainder * halfRemainder % c;
        }
    }
}
