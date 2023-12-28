import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Queue<Integer> q = new LinkedList<>();
        for(int i = 1; i <= N; i++) {
            q.offer(i);
        }
        ArrayList<Integer> list = new ArrayList<>();
        while(!q.isEmpty()) {
            for(int i = 0; i < K - 1; i++) {
                q.offer(q.poll());
            }
            list.add(q.poll());
        }
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        for(int i = 0; i < list.size(); i++) {
            if(i == list.size() - 1) {
                sb.append(list.get(i)).append(">");
                continue;
            }
            sb.append(list.get(i)).append(", ");
        }
        System.out.print(sb);
        br.close();
    }
}
