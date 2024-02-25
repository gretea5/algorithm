import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
    private static class Edge {
        int a;
        int b;
        int c;

        Edge(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }

    private static int[] parent;
    private static Edge[] edges;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        parent = new int[N + 1];
        edges = new Edge[M];

        for(int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }

        for(int i = 0; i < edges.length; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            edges[i] = new Edge(a, b, c);
        }

        Arrays.sort(edges, (e1, e2) -> { return e1.c - e2.c; });

        System.out.print(kruskal());

        br.close();
    }

    private static int kruskal() {
        int sum = 0;

        for(Edge edge : edges) {
            if(find(edge.a) != find(edge.b)) {
                sum += edge.c;
                union(edge.a, edge.b);
            }
        }

        return sum;
    }

    private static void union(int a, int b) {
        int x = find(a);
        int y = find(b);

        parent[x] = y;
    }

    private static int find(int a) {
        if(parent[a] == a) return a;

        parent[a] = find(parent[a]);

        return parent[a];
    }
}
