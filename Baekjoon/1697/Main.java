import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
    public static int N, K;
    public static int[] graph;
    public static boolean[] visited;
    public static int bfs(int cur, int des) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{cur, 0});
        visited[cur] = true;
        while(!q.isEmpty()) {
            int[] loc = q.poll();
            int curPos = loc[0];
            int time = loc[1];
            if (curPos == des) {
                return time;
            }
            if (curPos + 1 < 100001 && !visited[curPos + 1]) {
                q.offer(new int[]{curPos + 1, time + 1});
                visited[curPos + 1] = true;
            }
            if (curPos - 1 >= 0 && !visited[curPos - 1]) {
                q.offer(new int[]{curPos - 1, time + 1});
                visited[curPos - 1] = true;
            }
            if (curPos * 2 < 100001 && !visited[curPos * 2]) {
                q.offer(new int[]{curPos * 2, time + 1});
                visited[curPos * 2] = true;
            }
        }
        return -1;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        graph = new int[100001];
        visited = new boolean[100001];
        System.out.print(bfs(N, K));
        br.close();
    }
}
