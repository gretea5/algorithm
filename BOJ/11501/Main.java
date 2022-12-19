import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int h = 0; h < T; h++) {
            int N = Integer.parseInt(br.readLine());
            long arr[] = new long[N];
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int i = 0; i < N; i++) {
                arr[i] = Long.parseLong(st.nextToken());
            }
            long result = 0;
            long max = Long.MIN_VALUE;
            //반대로 최댓값을 찾아서 최댓값이 아닐 경우, 이익을 볼 수 있으므로 더해준다
            //(하루에 한장씩이므로)
            for(int i = N - 1; i >= 0; i--) {
                if (max < arr[i]) {
                    max = arr[i];
                } else {
                    result += (max - arr[i]);
                }
            }
            System.out.println(result);
        }
        br.close();
    }
}
