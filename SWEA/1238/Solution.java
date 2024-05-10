import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayDeque;
import java.util.ArrayList;

public class Solution {
    private static class Pos {
        int node;
        int dist;

        Pos(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }
    }

    private static int[] distance;
    private static boolean[] visited;
    private static ArrayList<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = 10;

        StringBuilder sb = new StringBuilder();

        for(int test = 1; test <= t; test++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            distance = new int[101];
            visited = new boolean[101];
            graph = new ArrayList[101];

            for(int i = 0; i < 101; i++) {
                graph[i] = new ArrayList<>();
            }

            int n = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine(), " ");

            for(int i = 0; i < (n / 2); i++) {
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());

                graph[from].add(to);
            }

            bfs(s);

            int max = Integer.MIN_VALUE;
            int answer = -1;

            for(int i = 100; i > 0; i--) {
                if (max < distance[i]) {
                    max = distance[i];
                    answer = i;
                }
            }

            sb.append("#").append(test).append(" ");
            sb.append(answer).append("\n");
        }

        System.out.print(sb);

        br.close();
    }

    private static void bfs(int s) {
        ArrayDeque<Pos> queue = new ArrayDeque<>();

        queue.addLast(new Pos(s, 0));
        visited[s] = true;

        while(!queue.isEmpty()) {
            Pos cur = queue.removeFirst();

            distance[cur.node] = cur.dist;

            for(int next : graph[cur.node]) {
                if (!visited[next]) {
                    queue.addLast(new Pos(next, cur.dist + 1));
                    visited[next] = true;
                }
            }
        }
    }
}
