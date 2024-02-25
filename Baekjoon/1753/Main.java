import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
    private static class Node {
        int end;
        int weight;

        Node(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }
    }

    private static int INF = 987654321;

    private static ArrayList<ArrayList<Node>> graph;
    private static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        dist = new int[V + 1];

        for(int i = 0; i < V + 1; i++) {
            graph.add(new ArrayList<>());
        }

        int start = Integer.parseInt(br.readLine());

        for(int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph.get(u).add(new Node(v, w));
        }

        dijkstra(start);

        StringBuilder sb = new StringBuilder();

        for(int i = 1; i < dist.length; i++) {
            if(dist[i] == INF) sb.append("INF");
            else sb.append(dist[i]);
            sb.append("\n");
        }

        System.out.print(sb);

        br.close();
    }

    private static void dijkstra(int start) {
        Arrays.fill(dist, INF);

        PriorityQueue<Node> pq  = new PriorityQueue<>((n1, n2) -> { return n1.weight - n2.weight; });

        pq.add(new Node(start, 0));
        dist[start] = 0;

        while(!pq.isEmpty()) {
            Node now = pq.remove();

            //현재 가중치 합보다 더 크면 갱신이 필요 없다.
            if(dist[now.end] < now.weight) continue;

            for(int i = 0; i < graph.get(now.end).size(); i++) {
                //인접한 노드의 정보를 가져온다.
                Node next = graph.get(now.end).get(i);

                //기록된 거리보다, 현재 가중치 최소 + 인접 노드까지 가는데 가중치를 더한 값이 더 작으면
                if(dist[next.end] > now.weight + next.weight) {
                    //갱신
                    dist[next.end] = now.weight + next.weight;
                    //우선순위 큐에 가중치 최솟값을 넣는다.
                    pq.add(new Node(next.end, dist[next.end]));
                }
            }
        }
    }
}
