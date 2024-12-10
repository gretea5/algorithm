import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Solution {
    private static int startIdx;
    private static long[] tree;

    private static final int CHANGE = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int test = 1; test <= t; test++) {
            sb.append("#").append(test).append(" ");

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int n = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());

            startIdx = 1;

            while (startIdx < n) { startIdx <<= 1; }

            int nodeCnt = startIdx * 2;

            tree = new long[nodeCnt * 2];

            st = new StringTokenizer(br.readLine(), " ");

            for (int i = 0; i < n; i++) {
                long value = Long.parseLong(st.nextToken());

                if (i % 2 == 1) { value *= -1; }

                update(i, value);
            }

            for (int i = 0; i < q; i++) {
                st = new StringTokenizer(br.readLine(), " ");

                int mode = Integer.parseInt(st.nextToken());

                if (mode == CHANGE) {
                    int idx = Integer.parseInt(st.nextToken());
                    long value = Long.parseLong(st.nextToken());

                    //idx가 홀수라면, 마이너스를 붙이기
                    if (idx % 2 == 1) { value *= -1; }

                    update(idx, value);
                }
                else {
                    int left = Integer.parseInt(st.nextToken());
                    int right = Integer.parseInt(st.nextToken()) - 1;

                    if (left % 2 == 1) {
                        sb.append(reverseQuery(left, right));
                    }
                    else {
                        sb.append(query(left, right));
                    }

                    sb.append(" ");
                }
            }

            sb.append("\n");
        }

        System.out.print(sb);

        br.close();
    }

    private static void update(int idx, long value) {
        idx += startIdx;

        tree[idx] = value;

        idx >>= 1;

        while (idx >= 1) {
            tree[idx] = tree[(2 * idx)] + tree[(2 * idx) + 1];

            idx >>= 1;
        }
    }

    /* left가 홀 수 일때 query*/
    private static long query(int left, int right) {
        left += startIdx;
        right += startIdx;

        long sum = 0;

        while (left <= right) {
            if (left % 2 == 1) {
                sum += tree[left];
            }

            if (right % 2 == 0) {
                sum += tree[right];
            }

            left = (left + 1) / 2;
            right = (right - 1) / 2;
        }

        return sum;
    }

    private static long reverseQuery(int left, int right) {
        left += startIdx;
        right += startIdx;

        long sum = 0;

        while (left <= right) {
            if (left % 2 == 1) {
                sum += (-1 * tree[left]);
            }

            if (right % 2 == 0) {
                sum += (-1 * tree[right]);
            }

            left = (left + 1) / 2;
            right = (right - 1) / 2;
        }

        return sum;
    }
}
