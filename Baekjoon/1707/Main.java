import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class Main {
    private static boolean[] record;
    private static boolean[] visited;
    private static ArrayList<Integer>[] graph;
    private static String answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for(int t = 0; t < testCase; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            record = new boolean[V + 1];
            visited = new boolean[V + 1];
            graph = new ArrayList[V + 1];

            for(int i = 0; i < V + 1; i++) {
                graph[i] = new ArrayList<>();
            }

            for(int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine(), " ");

                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());

                graph[u].add(v);
                graph[v].add(u);
            }

            for(int i = 1; i < V + 1; i++) {
                if(!visited[i]) {
                    recordEdges(i, true);
                }
            }

            answer = "YES";

            visited = new boolean[V + 1];

            for(int i = 1; i < V + 1; i++) {
                if(!visited[i]) {
                    check(i);
                }
            }

            sb.append(answer).append("\n");
        }

        System.out.print(sb);

        br.close();
    }

    private static void recordEdges(int start, boolean flag) {
        visited[start] = true;
        record[start] = flag;

        for(int next : graph[start]) {
            if(!visited[next]) {
                recordEdges(next, !flag);
            }
        }
    }

    private static void check(int start) {
        visited[start] = true;

        for(int next : graph[start]) {
            if(record[start] == record[next]) {
                answer = "NO";
            }
            if(!visited[next]) {
                check(next);
            }
        }
    }
}
