import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int test_case = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for(int test = 1; test <= test_case; test++) {
            int n = Integer.parseInt(br.readLine());

            StringBuilder stringBuilder = new StringBuilder();

            //입력받은 숫자를 문자열로 붙인다.
            while(true) {
                String[] arr = br.readLine().split(" ");

                n -= arr.length;

                for(int i = 0; i < arr.length; i++) {
                    stringBuilder.append(arr[i]);
                }

                if(n == 0) break;
            }

            String numStr = stringBuilder.toString();

            int answer = 0;

            while(true) {
                String num = String.valueOf(answer);

                if (!numStr.contains(num)) {
                    break;
                }

                answer += 1;
            }
            
            sb.append("#").append(test).append(" ").append(answer).append("\n");
        }

        System.out.print(sb.toString());

        br.close();
    }
}
