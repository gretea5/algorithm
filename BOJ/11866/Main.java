import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 1; i <= N; i++) {
            queue.offer(i);
        }
        while(!queue.isEmpty()) {
            for(int i = 0; i < K - 1; i++) {
                queue.offer(queue.poll());
            }
            list.add(queue.poll());
        }
        sb.append("<");
        for(int i = 0; i < list.size(); i++) {
            if(i == list.size() - 1) {
                sb.append(list.get(i));
                continue;
            }
            sb.append(list.get(i)).append(", ");
        }
        sb.append(">");
        System.out.print(sb.toString());
        br.close();
    }
}
