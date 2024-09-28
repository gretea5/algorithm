import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
    //간선 클래스 생성
    private static class Edge {
        int from;
        int to;
        int cost;

        Edge(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Edge[] edges = new Edge[m];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            edges[i] = new Edge(from, to, cost);
        }

        long[] dist = new long[n + 1];

        Arrays.fill(dist, Long.MAX_VALUE);

        dist[1] = 0;

        //from -> to로 갈때 cost를 더한 값이 더 작으면 갱신을 해봄, 대신 from이라는 곳이 값이 기록되어져 있어야함
        for (int i = 0; i < n - 1; i++) {
            for (Edge edge : edges) {
                if (dist[edge.from] != Long.MAX_VALUE && dist[edge.to] > dist[edge.from] + edge.cost) {
                    dist[edge.to] = dist[edge.from] + edge.cost;
                }
            }
        }

        //n번째에서 cycle이 갱신이 된다느 것은 싸이클이 된다는 의미,
        for (Edge edge : edges) {
            if (dist[edge.from] != Long.MAX_VALUE && dist[edge.to] > dist[edge.from] + edge.cost) {
                dist[edge.to] = dist[edge.from] + edge.cost;

                System.out.print(-1);
                return;
            }
        }

        StringBuilder sb = new StringBuilder();

        //해당 도시로 가는 경로가 없을 경우,
        for (int i = 2; i <= n; i++) {
            sb.append(dist[i] == Long.MAX_VALUE ?  -1 : dist[i]);
            sb.append("\n");
        }

        System.out.print(sb);

        br.close();
    }
}
