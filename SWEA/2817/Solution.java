import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Solution {
    private static int answer;
    private static int n;
    private static int k;

    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for(int test = 1; test <= T; test++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            arr = new int[n];

            st = new StringTokenizer(br.readLine(), " ");

            for(int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr);

            answer = 0;

            for(int i = 0; i < n; i++) {
                backTrack(arr[i], i);
            }

            sb.append("#").append(test).append(" ");
            sb.append(answer).append("\n");
        }

        System.out.print(sb);

        br.close();
    }

    private static void backTrack(int sum, int idx) {
        if (sum > k) {
            return;
        }
        else if (sum == k) {
            answer += 1;
            return;
        }

        for(int i = idx + 1; i < n; i++) {
            backTrack(sum + arr[i], i);
        }
    }
}
