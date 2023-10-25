import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        //T입력
        int T = Integer.parseInt(br.readLine());
        for(int test = 1; test <= T; test++) {
            double max = Integer.MIN_VALUE;
            double min = Integer.MAX_VALUE;
            double sum = 0.0;
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            while(st.hasMoreTokens()) {
                //value 입력
                double value = Double.parseDouble(st.nextToken());
                //합, 최대, 최소 값 갱신
                sum += value;
                max = Math.max(max, value);
                min = Math.min(min, value);
            }
            //반올림한 값 구하기
            int answer = (int) Math.round((sum - max - min) / (10 - 2));
            //출력 형식 저장
            sb.append("#").append(test).append(" ").append(answer).append("\n");
        }
        //출력
        System.out.print(sb);
        br.close();
    }
}
