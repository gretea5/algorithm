import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.LinkedHashMap;
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int t = 1; t <= T; t++) {
            //테스트 숫자 스킵
            String tc = br.readLine();
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int[] count = new int[101];
            //개수 입력
            for(int i = 0; i < 1000; i++) {
                int score = Integer.parseInt(st.nextToken());
                count[score] += 1;
            }
            int answer = 0;
            int max = Integer.MIN_VALUE;
            for(int i = 0; i < 101; i++) {
                if(max <= count[i]) {
                    max = count[i];
                    answer = i;
                }
            }
            //출력 형식 저장
            sb.append("#").append(t).append(" ").append(answer).append("\n");
        }
        //출력
        System.out.print(sb);
        br.close();
    }
}
