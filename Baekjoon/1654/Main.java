import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

    private static long[] arr;

    private static int K, N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        //K, N 입력
        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        //배열 선언
        arr = new long[K];

        long left = 1;
        long right = 0;

        for(int i = 0; i < K; i++) {
            arr[i] = Long.parseLong(br.readLine());
            //길이의 최댓값 구하기
            right = Math.max(right, arr[i]);
        }

        long answer = 0;

        while(left <= right) {
            //여기서 overflow가 나올 수 있으므로, long값을 넣어야함.
            long mid = (left + right) / 2;

            //개수 충족한다면,
            if(checkLength(mid)) {
                //최댓값 갱신
                answer = Math.max(answer, mid);
                //1을 더해준다.
                left = mid + 1;
            }
            else {
                //개수에 충족하지 않는다면 길이를 줄인다.
                right = mid - 1;
            }
        }

        //출력
        System.out.print(answer);

        br.close();
    }

    private static boolean checkLength(long mid) {
        long cnt = 0;

        for (long length : arr) {
            cnt += (length / mid);
        }

        return cnt >= N;
    }
}
