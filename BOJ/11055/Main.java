import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] value = new int[N];
        int[] sum = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) {
            value[i] = Integer.parseInt(st.nextToken());
            sum[i] = value[i];
        }
        //arr[i]가 기준점
        for(int i = 0; i < N; i++) {
            for(int j = 0; j <= i; j++) {
                if (value[j] < value[i] && sum[i] < sum[j] + value[i]) {
                    sum[i] = sum[j] + value[i];
                }
            }
        }
        int answer = Integer.MIN_VALUE;
        for(int i = 0; i < N; i++) {
            answer = Math.max(answer, sum[i]);
        }
        System.out.print(answer);
        br.close();
    }
}
