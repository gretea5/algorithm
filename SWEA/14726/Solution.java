import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Solution {
    private static int startIdx;

    private static int[] minTree;
    private static int[] maxTree;

    private static final int CHANGE = 0;
    private static final int PRINT = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        for (int test = 1; test <= t; test++) {
            sb.append("#").append(test).append(" ");

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int n = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());

            startIdx = 1;

            while (startIdx < n) {
                startIdx <<= 1;
            }

            int nodeCnt = startIdx * 2;

            minTree = new int[nodeCnt];
            maxTree = new int[nodeCnt];

            st = new StringTokenizer(br.readLine(), " ");

            for (int i = 0; i < n; i++) {
                int value = Integer.parseInt(st.nextToken());

                update(i, value);
            }

            for (int i = 0; i < q; i++) {
                st = new StringTokenizer(br.readLine(), " ");

                int mode = Integer.parseInt(st.nextToken());

                if (mode == CHANGE) {
                    int idx = Integer.parseInt(st.nextToken());
                    int value = Integer.parseInt(st.nextToken());

                    update(idx, value);
                }
                else if (mode == PRINT){
                    int left = Integer.parseInt(st.nextToken());
                    int right = Integer.parseInt(st.nextToken()) - 1;

                    int[] arr = query(left, right);

                    sb.append(arr[0] - arr[1]).append(" ");
                }
            }

            sb.append("\n");
        }

        System.out.print(sb);

        br.close();
    }

    private static int[] query(int left, int right) {
        left += startIdx;
        right += startIdx;

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        while (left <= right) {
            if (left % 2 == 1) {
                max = Math.max(max, maxTree[left]);
                min = Math.min(min, minTree[left]);
            }

            if (right % 2 == 0) {
                max = Math.max(max, maxTree[right]);
                min = Math.min(min, minTree[right]);
            }

            left = (left + 1) / 2;
            right = (right - 1) / 2;
        }

        return new int[] {max, min};
    }

    private static void update(int idx, int value) {
        idx += startIdx;

        minTree[idx] = value;
        maxTree[idx] = value;

        idx >>= 1;

        while (idx >= 1) {
            minTree[idx] = Math.min(minTree[2 * idx], minTree[(2 * idx) + 1]);
            maxTree[idx] = Math.max(maxTree[2 * idx], maxTree[(2 * idx) + 1]);

            idx >>= 1;
        }
    }
}
