import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    private static class Point {
        int number;
        int distance;

        Point(int number, int distance) {
            this.number = number;
            this.distance = distance;
        }
    }

    private static ArrayList<Point>[] graph;
    private static boolean[] visited;

    private static int startPoint;
    private static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int V = Integer.parseInt(br.readLine());

        graph = new ArrayList[V + 1];
        visited = new boolean[V + 1];

        for(int i = 0; i < V + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int t = 0; t < V; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int start = Integer.parseInt(st.nextToken());

            while(true) {
                int number = Integer.parseInt(st.nextToken());

                if(number == -1) break;

                int distance = Integer.parseInt(st.nextToken());

                graph[start].add(new Point(number, distance));
            }
        }

        answer = Integer.MIN_VALUE;

        visited = new boolean[V + 1];
        dfs(1, 0);

        visited = new boolean[V + 1];
        dfs(startPoint, 0);

        System.out.print(answer);

        br.close();
    }

    private static void dfs(int start, int distance) {
        if(answer < distance) {
            answer = distance;
            startPoint = start;
        }

        visited[start] = true;

        for(Point p : graph[start]) {
            if(!visited[p.number]) {
                dfs(p.number, distance + p.distance);
            }
        }
    }
}
