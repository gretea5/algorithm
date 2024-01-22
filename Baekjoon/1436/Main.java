import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //N 입력
        int N = Integer.parseInt(br.readLine());

        //최소 종말의 수
        int number = 666;
        //번째 수
        int idx = 1;

        //number를 더하면서, 666이 포함될때 번째수를 더해준다.
        while(N != idx) {
            number += 1;

            if(String.valueOf(number).contains("666")) {
                idx += 1;
            }
        }

        //숫자 출력
        System.out.print(number);

        br.close();
    }
}
