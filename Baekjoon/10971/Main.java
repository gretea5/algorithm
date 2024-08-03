import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    private static int answer;
    private static int n;
    
    private static int[][] costs;
    private static boolean[] visited;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        
        costs = new int[n + 1][n + 1];
        visited = new boolean[n + 1];
        
        for(int i = 1; i < n + 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            for(int j = 1; j < n + 1; j++) {
                costs[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        answer = Integer.MAX_VALUE;
        
        for(int i = 1; i < n + 1; i++)  {
            visited = new boolean[n + 1];
            
            dfs(i, i, 1, 0);
        }
        
        System.out.print(answer);
        
        br.close();
    }
    
    private static void dfs(int start, int cur, int dist, int cost) {
        visited[cur] = true;
        
        //거리가 n을 왔으면서
        if (dist == n) {
            //현재에서 시작점이 인접하다면,
            if (costs[cur][start] != 0) {
                int minCost = cost + costs[cur][start];
                
                answer = Math.min(minCost, answer);
            }
            
            return;
        }
        
        for(int j = 1; j < n + 1; j++) {
            if (cur == j) {
                continue;
            }
            
            int nextCost = costs[cur][j];
            
            if (nextCost != 0 && !visited[j]) {
                dfs(start, j, dist + 1, cost + nextCost);
                
                visited[j] = false;
            }
        }
    }
}
