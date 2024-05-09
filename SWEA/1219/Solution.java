import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.ArrayDeque;

public class Solution {
    private static ArrayList<Integer>[] graph;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = 10;

        StringBuilder sb = new StringBuilder();

        for(int test = 1; test <= t; test++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int testNumber = Integer.parseInt(st.nextToken());
            int total = Integer.parseInt(st.nextToken());

            graph = new ArrayList[100];

            for(int i = 0; i < 100; i++) {
                graph[i] = new ArrayList<>();
            }

            st = new StringTokenizer(br.readLine(), " ");

            for(int i = 0; i < total; i++) {
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());

                graph[start].add(end);
            }

            sb.append("#").append(testNumber).append(" ");
            sb.append(bfs()).append("\n");
        }

        System.out.print(sb);

        br.close();
    }

    private static int bfs() {
        boolean[] visited = new boolean[100];

        ArrayDeque<Integer> queue = new ArrayDeque<>();

        queue.addLast(0);
        visited[0] = true;

        while(!queue.isEmpty()) {
            int cur = queue.removeFirst();

            if (cur == 99) {
                return 1;
            }

            for(int next : graph[cur]) {
                if (!visited[next]) {
                    queue.addLast(next);
                    visited[next] = true;
                }
            }
        }

        return 0;
    }
}
