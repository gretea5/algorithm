import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        char[] alpha = new char[26];
        //배열 초기화
        for(int i = 0; i < 26; i++) {
            alpha[i] = (char) ('a' + i);
        }
        StringBuilder sb = new StringBuilder();
        for(int test = 1; test <= T; test++) {
            String str = br.readLine();
            int answer = 0;
            //같은 알파벳의 개수를 센다.
            for(int i = 0; i < str.length(); i++) {
                if(str.charAt(i) == alpha[i]) answer += 1;
                else break;
            }
            sb.append("#").append(test).append(" ").append(answer).append("\n");
        }
        //출력
        System.out.print(sb);
        br.close();
    }
}
