import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;
import java.util.ArrayList;

public class Main {
    public static int computerNum;
    public static boolean visited[];
    public static int answer = 0;
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    public static void dfs(int x) {
        visited[x] = true;
        for(int i = 0; i < graph.get(x).size(); i++) {
            int y = graph.get(x).get(i);
            if(!visited[y]) {
                answer += 1;
                dfs(y);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        computerNum = Integer.parseInt(br.readLine());
        int T = Integer.parseInt(br.readLine());
        visited = new boolean[computerNum + 1];
        for(int i = 0; i < computerNum + 1; i++) {
            graph.add(new ArrayList<>());
        }
        for(int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            graph.get(start).add(end);
            graph.get(end).add(start);
        }
        dfs(1);
        System.out.print(answer);
        br.close();
    }
}
