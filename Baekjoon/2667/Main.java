import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static int N;
    public static boolean visited[][];
    public static int graph[][];
    public static int totalCount;
    public static int houseCount;
    public static int dx[] = {1, -1, 0, 0};
    public static int dy[] = {0, 0, 1, -1};
    public static ArrayList<Integer> list = new ArrayList<>();

    public static void dfs(int x, int y) {
        visited[x][y] = true;
        graph[x][y] = 0;
        houseCount += 1;
        for(int i = 0; i < 4; i++) {
            int v1 = x + dx[i];
            int v2 = y + dy[i];
            if(v1 < 0 || v1 > N - 1 || v2 < 0 || v2 > N - 1) {
                continue;
            }
            if(graph[v1][v2] == 1 && !visited[v1][v2]) {
                dfs(v1, v2);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        visited = new boolean[N][N];
        graph = new int[N][N];
        totalCount = 0;
        houseCount = 0;
        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            for(int j = 0; j < N; j++) {
                graph[i][j] = (int) str.charAt(j) - '0';
            }
        }
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(graph[i][j] == 1 && !visited[i][j]) {
                    totalCount += 1;
                    dfs(i, j);
                    list.add(houseCount);
                    houseCount = 0;
                }
            }
        }
        Collections.sort(list);
        System.out.println(totalCount);
        for(int n : list) {
            System.out.println(n);
        }
        br.close();
    }
}
