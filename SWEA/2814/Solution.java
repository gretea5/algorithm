import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
    private static ArrayList<Integer>[] graph;
    private static boolean[] visited;

    private static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for(int test = 1; test <= t; test++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            visited = new boolean[n + 1];
            graph = new ArrayList[n + 1];


            for(int i = 0; i < n + 1; i++) {
                graph[i] = new ArrayList<>();
            }

            for(int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine(), " ");

                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                graph[x].add(y);
                graph[y].add(x);
            }

            answer = Integer.MIN_VALUE;

            for(int i = 1; i < n + 1; i++) {
                visited = new boolean[n + 1];

                dfs(i, 1);
            }

            sb.append("#").append(test).append(" ");
            sb.append(answer).append("\n");
        }

        System.out.print(sb);

        br.close();
    }

    private static void dfs(int start, int dist) {
        visited[start] = true;

        answer = Math.max(answer, dist);

        for(int next : graph[start]) {
            if(!visited[next]) {
                dfs(next, dist + 1);
                visited[next] = false;
            }
        }
    }
}
