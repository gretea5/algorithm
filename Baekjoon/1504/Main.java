import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.PriorityQueue;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    private static class Pos {
        int number;
        int cost;

        Pos(int number, int cost) {
            this.number = number;
            this.cost = cost;
        }
    }

    private static int n;

    private static ArrayList<Pos>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n + 1];

        for (int i = 0; i < n + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        while (e > 0) {
            st = new StringTokenizer(br.readLine(), " ");

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph[a].add(new Pos(b, c));
            graph[b].add(new Pos(a, c));

            e -= 1;
        }

        st = new StringTokenizer(br.readLine(), " ");

        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        //1 -> v1 -> v2 -> n
        int[] arr = new int[4];

        arr[0] = 1;
        arr[1] = v1;
        arr[2] = v2;
        arr[3] = n;

        int case1 = 0;

        for (int i = 0; i < 3; i++) {
            int dist = bfs(arr[i], arr[i + 1]);

            //경로가 없다는 의미
            if (dist == Integer.MAX_VALUE) {
                case1 = Integer.MAX_VALUE;
                break;
            }

            case1 += dist;
        }

        //1 -> v2 -> v1 -> n
        arr = new int[4];

        arr[0] = 1;
        arr[1] = v2;
        arr[2] = v1;
        arr[3] = n;

        int case2 = 0;

        for (int i = 0; i < 3; i++) {
            int dist = bfs(arr[i], arr[i + 1]);

            if (dist == Integer.MAX_VALUE) {
                case2 = Integer.MAX_VALUE;
                break;
            }

            case2 += dist;
        }

        //모든 경로가 없을 경우,
        if (case1 == Integer.MAX_VALUE && case2 == Integer.MAX_VALUE) {
            System.out.print(-1);
            return;
        }

        //둘중 하나의 경로가 존재할 경우 ,
        int answer = Math.min(case1, case2);

        System.out.print(answer);

        br.close();
    }

    private static int bfs(int start, int dest) {
        int[] dist = new int[n + 1];

        //모든 정점 무한으로 채우기
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<Pos> pq = new PriorityQueue<>((n1, n2) -> n1.cost - n2.cost);

        pq.add(new Pos(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Pos cur = pq.remove();

            int number  = cur.number;

            //목적지의 거리보다 현재 거리가 크다면 볼 필요도 없음
            if (dist[dest] < dist[number]) {
                continue;
            }

            for (Pos p : graph[number]) {
                int next = p.number;

                //다음 비용가 현재 정점에서 다음정점으로 비용을 더한 비용을 비교
                if (dist[next] > dist[number] + p.cost) {
                    dist[next] = dist[number] + p.cost;
                    pq.add(new Pos(next, dist[next]));
                }
            }
        }

        return dist[dest];
    }
}
