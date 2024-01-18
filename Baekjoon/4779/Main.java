import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    private static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input;
        while((input = br.readLine()) != null) {
            //N 입력
            int N = Integer.parseInt(input);

            //길이
            int length = (int) Math.pow(3, N);

            sb = new StringBuilder();

            //문자열을 만든다.
            for(int i = 0; i < length; i++) {
                sb.append("-");
            }

            recursion(0, length);

            System.out.println(sb);
        }

        br.close();
    }

    private static void recursion(int start, int size) {
        //크기가 1일때, 멈춘다.
        if (size == 1) {
            return;
        }

        //3등분한 크기
        int div = size / 3;

        //중간 부분을 모두 공백으로 처리
        for(int i = start + div; i < start + div * 2; i++) {
            sb.setCharAt(i, ' ');
        }

        //분할할 문자열의 시작 인덱스와 크기 지정
        recursion(start, div);
        recursion(start + div * 2, div);
    }
}
