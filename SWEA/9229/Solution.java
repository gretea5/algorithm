import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //T 입력
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int test = 1; test <= T; test++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            //N, M 입력
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            //과자 무게 담을 배열
            int[] arr = new int[N];
            st = new StringTokenizer(br.readLine(), " ");
            //배열의 값을 넣는다.
            for(int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            int max = -1;
            for(int i = 0; i < arr.length; i++) {
                for(int j = i + 1; j < arr.length; j++) {
                    //두 봉지의 합을 구한다.
                    int sum = arr[i] + arr[j];
                    //들 수 있는 무게라면, 갱신
                    if(sum <= M) {
                        max = Math.max(sum, max);
                    }
                }
            }
            //출력 형식
            sb.append("#").append(test).append(" ").append(max).append("\n");
        }
        //출력
        System.out.print(sb);
        br.close();
    }
}
