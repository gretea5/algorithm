import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    private static int[] arr;

    private static int n;
    private static int s;
    private static int min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for(int test = 1; test <= T; test++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            n = Integer.parseInt(st.nextToken());
            s = Integer.parseInt(st.nextToken());

            arr = new int[n];

            st = new StringTokenizer(br.readLine(), " ");

            for(int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr);

            min = Integer.MAX_VALUE;

            for(int i = 0; i < n; i++) {
                backTrack(arr[i], i);
            }

            sb.append("#").append(test).append(" ");
            sb.append(min - s).append("\n");
        }

        System.out.print(sb);

        br.close();
    }

    private static void backTrack(int sum, int idx) {
        if (sum >= s) {
            min = Math.min(min, sum);
            return;
        }

        for(int i = idx + 1; i < n; i++) {
            backTrack(sum + arr[i], i);
        }
    }
}
