import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;
import java.util.ArrayList;

public class Main {
    public static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    public static boolean[] visited;
    public static int N;
    public static void dfs(int start) {
        visited[start] = true;
        for(int i = 0; i < list.get(start).size(); i++) {
            int y = list.get(start).get(i);
            if(!visited[y]) dfs(y);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int k = 0; k < T; k++) {
            int count = 0;
            N = Integer.parseInt(br.readLine());
            list = new ArrayList<>();
            visited = new boolean[N + 1];
            for(int i = 0; i < N + 1; i++) {
                list.add(new ArrayList<>());
            }
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int i = 1; i < N + 1; i++) {
                int end = Integer.parseInt(st.nextToken());
                list.get(i).add(end);
            }
            for(int i = 1; i < N + 1; i++) {
                if(!visited[i]) {
                    dfs(i);
                    count++;
                }
            }
            sb.append(count).append("\n");
        }
        System.out.print(sb.toString());
        br.close();
    }
}
