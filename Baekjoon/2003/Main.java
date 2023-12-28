import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int count = 0;
        int start = 0, end = 0;
        int len = arr.length;
        int sum = 0;
        while(true) {
            //합이 M보다 같거나 클 경우,
            if (sum >= M) {
                sum -= arr[start++];
            }
            //인덱스 범위를 벗어날 경우,
            else if (end >= len) {
                break;
            }
            //합이 M이 되지 않을 경우,
            else {
                sum += arr[end++];
            }
            if (sum == M) {
                count += 1;
            }
        }
        System.out.print(count);
        br.close();
    }
}
