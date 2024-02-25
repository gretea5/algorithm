import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
    private static class Node {
        int end;
        int cost;

        Node(int end, int cost) {
            this.end = end;
            this.cost = cost;
        }
    }

    private static int INF = 987654321;

    private static ArrayList<ArrayList<Node>> graph;
    private static int[] distance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //N, M 입력
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());


        //배열과, 인접 정점 담을 리스트 초기화
        graph = new ArrayList<>();
        distance = new int[N + 1];

        //인접 리스트 생성
        for(int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }

        //인접 정보 넣기
        for(int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph.get(s).add(new Node(e, c));
        }

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        //시작점과 끝점 입력
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        //다익스트라 알고리즘 호출
        dijkstra(start);

        //end의 최단거리 출력
        System.out.print(distance[end]);

        br.close();
    }

    private static void dijkstra(int start) {
        Arrays.fill(distance, INF);

        PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) -> {
            return n1.cost - n2.cost;
        });

        pq.add(new Node(start, 0));

        while(!pq.isEmpty()) {
            Node now = pq.remove();

            if(distance[now.end] < now.cost) continue;

            for(int i = 0; i < graph.get(now.end).size(); i++) {
                Node next = graph.get(now.end).get(i);

                if(distance[next.end] > now.cost + next.cost) {
                    distance[next.end] = now.cost + next.cost;
                    pq.add(new Node(next.end, distance[next.end]));
                }
            }
        }
    }
}
