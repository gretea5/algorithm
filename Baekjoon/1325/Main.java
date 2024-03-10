import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.ArrayDeque;

public class Main {
    private static int[] cnt;
    private static ArrayList<Integer>[] graph;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        cnt = new int[N + 1];

        for(int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
        }

        for(int i = 1; i <= N; i++) {
            visited = new boolean[N + 1];
            bfs(i);
        }

        int max = Integer.MIN_VALUE;

        for(int i = 0; i < cnt.length; i++) {
            max = Math.max(max, cnt[i]);
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < cnt.length; i++) {
            if(max == cnt[i]) sb.append(i).append(" ");
        }

        System.out.print(sb);

        br.close();
    }

    private static void bfs(int start) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();

        queue.addLast(start);
        visited[start] = true;

        while(!queue.isEmpty()) {
            int cur = queue.removeFirst();

            for(int i = 0; i < graph[cur].size(); i++) {
                int next = graph[cur].get(i);

                if(!visited[next]) {
                    cnt[next] += 1;
                    visited[next] = true;
                    queue.addLast(next);
                }
            }
        }
    }
}
