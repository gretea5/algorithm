import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.ArrayDeque;

public class Main {
    private static boolean isCycle; 
    
    private static ArrayList<Integer>[] graph;
    private static boolean[] visited;
    private static int[] inDegree;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        graph = new ArrayList[n + 1];
        inDegree = new int[n + 1];
        
        for (int i = 0; i < n + 1; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            
            int size = Integer.parseInt(st.nextToken());
           
            if (size >= 2) {
                int[] arr = new int[size];
                
                for (int j = 0; j < size; j++) {
                    arr[j] = Integer.parseInt(st.nextToken());
                }
                
                for (int j = 0; j < size - 1; j++) {
                    int from = arr[j];
                    int to = arr[j + 1];
                    
                    graph[from].add(to);
                    
                    inDegree[to] += 1;
                }
            }
        }
        
        isCycle = false;
        
        for (int i = 1; i <= n; i++) {
            visited = new boolean[n + 1];
            
            dfs(i, i);
            
            if (isCycle) {
                System.out.print(0);
                return;
            }
        }
        
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        
        for (int i = 1; i <= n; i++) {
            if (inDegree[i] == 0) {
                queue.addLast(i);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        
        while (!queue.isEmpty()) {
            int cur = queue.removeFirst();
            
            sb.append(cur).append("\n");
            
            for (int next : graph[cur]) {
                inDegree[next] -= 1;
                
                if (inDegree[next] == 0) {
                    queue.addLast(next);
                }
            }
        }
        
        System.out.print(sb);

        br.close();
    }
    
    private static void dfs(int start, int cur) {
        visited[cur] = true;
        
        for (int next : graph[cur]) {
            if (start == next) {
                isCycle = true;
                return;
            }
            
            if (!visited[next]) {
                dfs(start, next);
            }
        }
    }
}
