import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
    public static int N, K;
    public static boolean[] visited = new boolean[100001];
    public static int time = 0;
    public static void bfs(int start, int target) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{start, 0});
        visited[start] = true;
        int min  = Integer.MAX_VALUE;
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int pos = cur[0];
            int t = cur[1];
            visited[pos] = true;
            if (pos == target) {
                min = Math.min(min, t);
            }
            if (pos * 2 < 100001 && !visited[pos * 2]) {
                q.offer(new int[]{pos * 2, t});
            }
            if (pos - 1 >= 0 && !visited[pos - 1]) {
                q.offer(new int[]{pos - 1, t + 1});
            }
            if (pos + 1 < 100001 && !visited[pos + 1]) {
                q.offer(new int[]{pos + 1, t + 1});
            }
        }
        time = min;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        bfs(N, K);
        System.out.print(time);
        br.close();
    }
}
