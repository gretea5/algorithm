import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //S입력
        long S = Long.parseLong(br.readLine());

        //long으로 선언한 이유는 int의 범위를 벗어나기 때문,
        long n = 1;

        while(true) {
            //시그마 공식
            if ((n * (n + 1)) / 2 > S) {
                break;
            }
            //1 증가
            n += 1;
        }

        //더 커지는 경우에서 1을 뺀 값이 최댓값
        System.out.print(n - 1);
        br.close();
    }
}
