import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
    public static int n, m, start, target;
    public static int countArr[];
    public static boolean visited[];
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    public static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;
        countArr[start] = 0;
        while(!q.isEmpty()) {
            int x = q.poll();
            for(int i = 0; i < graph.get(x).size(); i++) {
                int y = graph.get(x).get(i);
                if(!visited[y]) {
                    q.offer(y);
                    visited[y] = true;
                    countArr[y] = countArr[x] + 1;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        start = Integer.parseInt(st.nextToken());
        target = Integer.parseInt(st.nextToken());
        countArr = new int[n + 1];
        visited = new boolean[n + 1];
        Arrays.fill(countArr, -1);
        Arrays.fill(visited, false);
        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        m = Integer.parseInt(br.readLine());
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            graph.get(s).add(e);
            graph.get(e).add(s);
        }
        bfs(start);
        System.out.print(countArr[target]);
        br.close();
    }
}
