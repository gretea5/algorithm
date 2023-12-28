import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.PriorityQueue;
import java.util.Comparator;
import java.lang.Math;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer n1, Integer n2) {
                if(Math.abs(n1) ==  Math.abs(n2)) {
                    return (n1 >= n2 ? 1 : -1);
                }
                return Math.abs(n1) - Math.abs(n2);
            }
        });
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num == 0 && pq.size() == 0) {
                sb.append("0").append("\n");
            }
            else if (num == 0) {
                sb.append(pq.poll()).append("\n");
            }
            else {
                pq.offer(num);
            }
        }
        System.out.print(sb);
        br.close();
    }
}
