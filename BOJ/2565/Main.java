import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;
public class Main {
    private static class Line {
        int a;
        int b;
        Line(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }

    private static Line[] arr;
    private static int[] dp;
    private static int N;
    private static int answer;

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new Line[N];
        dp = new int[N];
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[i] = new Line(a, b);
        }
        Arrays.fill(dp, 1);
        br.close();
    }

    private static void solve() {
        Arrays.sort(arr, (o1, o2) -> {
            return o1.a - o2.a;
        });
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < i; j++) {
                if(arr[j].b < arr[i].b) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        answer = Integer.MIN_VALUE;
        for(int i = 0; i < N; i++) {
            answer = Math.max(answer, dp[i]);
        }
        System.out.print(N - answer);
    }
}
