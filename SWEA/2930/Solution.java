import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int test = 1; test <= t; test++) {
            sb.append("#").append(test).append(" ");

            PriorityQueue<Integer> pq = new PriorityQueue<>((n1, n2) -> n2 - n1);

            int n = Integer.parseInt(br.readLine());

            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");

                int command = Integer.parseInt(st.nextToken());

                if (command == 1) {
                    int x = Integer.parseInt(st.nextToken());

                    pq.add(x);
                }
                else {
                    sb.append(pq.isEmpty() ? -1 : pq.remove()).append(" ");
                }
            }

            sb.append("\n");
        }

        System.out.print(sb);

        br.close();
    }
}
