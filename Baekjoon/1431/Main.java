import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

/*
    시간복잡도: NlogN
    알고리즘 분류: 정렬
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //N 입력
        int N = Integer.parseInt(br.readLine());

        //문자열 배열 선언
        String[] arr = new String[N];

        //문자열 입력
        for(int i = 0; i < N; i++) {
            arr[i] = br.readLine();
        }

        //정렬
        Arrays.sort(arr, (s1, s2) -> {
            if(s1.length() != s2.length()) {
                //길이가 다르다면 (오름차순)
                return s1.length() - s2.length();
            }
            else {
                if(calNumber(s1) == calNumber(s2)) {
                    //사전순으로 비교
                    return s1.compareTo(s2);
                }
                //작은 합을 가지는 순(오름차순)
                return calNumber(s1) - calNumber(s2);
            }
        });

        //출력
        StringBuilder sb = new StringBuilder();

        for(String s: arr) {
            sb.append(s + "\n");
        }

        System.out.print(sb);

        br.close();
    }

    //숫자인 문자의 합을 구하는 함수
    private static int calNumber(String str) {
        int sum = 0;

        for(int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if('1' <= c && c <= '9') {
                sum += c - '0';
            }
        }

        return sum;
    }
}
