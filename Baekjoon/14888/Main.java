import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    private static int N;
    private static int max, min;

    private static int[] arr;
    private static int[] cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        arr = new int[N];
        cnt = new int[4];

        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine(), " ");

        for(int i = 0; i < 4; i++) {
            cnt[i] = Integer.parseInt(st.nextToken());
        }

        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;

        dfs(arr[0], 1);

        System.out.println(max);
        System.out.print(min);

        br.close();
    }

    private static void dfs(int value, int idx) {
        if(idx == N) {
            max = Math.max(max, value);
            min = Math.min(min, value);
            return;
        }

        for(int i = 0; i < 4; i++) {
            if(cnt[i] > 0) {
                cnt[i] -= 1;

                switch (i) {
                    case 0:
                        dfs(value + arr[idx], idx + 1);
                        break;
                    case 1:
                        dfs(value - arr[idx], idx + 1);
                        break;
                    case 2:
                        dfs(value * arr[idx], idx + 1);
                        break;
                    case 3:
                        dfs(value / arr[idx], idx + 1);
                        break;
                }

                cnt[i] += 1;
            }
        }
    }
}
