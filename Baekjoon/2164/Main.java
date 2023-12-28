import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.Queue;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> q = new LinkedList<>();
        int N = Integer.parseInt(br.readLine());
        for(int i = 1; i <= N; i++) {
            q.offer(i);
        }
        while(true) {
            if(q.size() == 1) break;
            q.poll();
            q.offer(q.poll());
        }
        System.out.print(q.poll());
        br.close();
    }
}
