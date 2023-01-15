import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
    public static int N, M;
    public static boolean visited[];
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    public static void dfs(int x) {
        visited[x] = true;
        for(int i = 0; i < graph.get(x).size(); i++) {
            int y = graph.get(x).get(i);
            if (!visited[y])  dfs(y);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N + 1];
        Arrays.fill(visited, false);
        for(int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            graph.get(s).add(e);
            graph.get(e).add(s);
        }
        int count = 0;
        for(int i = 1; i <= N; i++) {
            if(!visited[i]) {
                dfs(i);
                count += 1;
            }
        }
        System.out.print(count);
        br.close();
    }
}
