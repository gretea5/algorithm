import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    private static int N, M;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];

        st = new StringTokenizer(br.readLine(), " ");

        int left = Integer.MIN_VALUE;
        int right = 0;

        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            right += arr[i];
            left = Math.max(left, arr[i]);
        }

        int answer = Integer.MAX_VALUE;

        while(left <= right) {
            int mid = (left + right) / 2;

            if(check(mid)) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }

        System.out.print(left);

        br.close();
    }

    private static boolean check(int target) {
        int cnt = 0;
        int sum = 0;

        for(int i = 0; i < N; i++) {
            if(sum + arr[i] > target) {
                cnt += 1;
                sum = 0;
            }
            sum += arr[i];
        }

        if(sum != 0) cnt += 1;
        return cnt > M;
    }
}
