import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;
import java.util.ArrayDeque;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int j = 0; j < T; j++) {
            int K = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            PriorityQueue<Long> pq = new PriorityQueue<>();
            for(int i = 0; i < K; i++) {
                pq.offer(Long.parseLong(st.nextToken()));
            }
            long answer = 0;
            while(true) {
                long n1 = pq.poll();
                long n2 = pq.poll();
                long sum = n1 + n2;
                answer += sum;
                if (pq.size() == 0) break;
                pq.offer(sum);
            }
            System.out.println(answer);
        }
        br.close();
    }
}
