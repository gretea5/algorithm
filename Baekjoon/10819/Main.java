import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    private static int N;

    private static boolean[] isRecorded;
    private static int[] arr, recordArr;

    private static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        isRecorded = new boolean[N];
        arr = new int[N];
        recordArr = new int[N];

        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        answer = Integer.MIN_VALUE;

        dfs(0);

        System.out.print(answer);
        br.close();
    }

    private static void dfs(int depth) {
        if(depth == N) {
            int sum = 0;

            for(int i = 1; i < N; i++) {
                sum += Math.abs(recordArr[i] - recordArr[i - 1]);
            }

            answer = Math.max(answer, sum);
        }

        for(int i = 0; i < N; i++) {
            if(!isRecorded[i]) {
                isRecorded[i] = true;
                recordArr[depth] = arr[i];

                dfs(depth + 1);

                isRecorded[i] = false;
            }
        }
    }
}
