import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    //리프노드의 시작 인덱스
    private static int startIdx;
    private static long[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        //리프노드 즉 자식이 없는 노드의 개수를 찾는 로직
        startIdx = 1;

        while (startIdx < n) { startIdx = startIdx << 1; }

        //리프노드가 아닌 갯수 startIdx - 1개 즉 2 * startIdx개를 저장해야함
        int nodeCnt = startIdx << 1;

        tree = new long[nodeCnt];

        //1번째 부터 넣으므로, 1을 빼준다.(리프 노드 한단계 위 맨 우측 인덱스)
        startIdx -= 1;

        for (int i = 1; i <= n; i++) {
            long value = Long.parseLong(br.readLine());

            update(i, value);
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < m + k; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (a == 1) {
                long c = Long.parseLong(st.nextToken());

                update(b, c);
            }
            else {
                int c = Integer.parseInt(st.nextToken());

                sb.append(query(b, c)).append("\n");
            }
        }

        System.out.print(sb);

        br.close();
    }

    private static long query(int left, int right) {
        left += startIdx;
        right += startIdx;

        long sum = 0;

        while (left <= right) {
            //홀수라면
            if (left % 2 == 1) {
                sum += tree[left];
            }

            //짝수라면,
            if (right % 2 == 0) {
                sum += tree[right];
            }

            left = (left + 1) / 2;
            right = (right - 1) / 2;
        }

        return sum;
    }

    private static void update(int idx, long value) {
        //리프노드의 인덱스로 움직임
        idx += startIdx;

        //리프노드에 값을 넣어준다.
        tree[idx] = value;

        //2로 나눠줌
        idx >>= 1;

        while (idx >= 1) {
            //루트 노드로 올라가면서 더한 값을 갱신
            tree[idx] = (tree[2 * idx] + tree[(2 * idx) + 1]);

            idx >>= 1;
        }
    }
}
