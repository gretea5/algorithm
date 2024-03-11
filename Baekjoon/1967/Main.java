import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class Main {
    private static class Point {
        int num;
        int weight;

        Point(int num, int weight) {
            this.num = num;
            this.weight = weight;
        }
    }

    private static ArrayList<Point>[] graph;
    private static boolean[] visited;

    private static int answer;
    private static int startPoint;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        graph = new ArrayList[n + 1];
        visited = new boolean[n + 1];

        for(int i = 0; i < n + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int t = 0; t < n - 1; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph[a].add(new Point(b, weight));
            graph[b].add(new Point(a, weight));
        }

        answer = Integer.MIN_VALUE;

        dfs(1, 0);

        visited = new boolean[n + 1];
        dfs(startPoint, 0);

        System.out.print(answer);

        br.close();
    }

    private static void dfs(int start, int weightSum) {
        if(answer < weightSum) {
            answer = weightSum;
            startPoint = start;
        }

        visited[start] = true;

        for(Point next : graph[start]) {
            if(!visited[next.num]) {
                dfs(next.num, weightSum + next.weight);
            }
        }
    }
}
