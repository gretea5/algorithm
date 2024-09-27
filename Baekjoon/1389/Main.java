import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.util.ArrayDeque;

public class Main {
    private static class Pos {
        int x;
        int dist;
        
        Pos (int x, int dist) {
            this.x = x;
            this.dist = dist;
        }
    }
    
    private static int n, m;
    private static HashSet<Integer>[] graph;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        graph = new HashSet[n + 1];
        
        for (int i = 0; i < n + 1; i++) {
            graph[i] = new HashSet<>();
        }
        
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            graph[a].add(b);
            graph[b].add(a);
        }
        
        int min = Integer.MAX_VALUE;
        int answer = -1;
        
        for (int i = 1; i <= n; i++) {
            int sum = bfs(i);
            
            if (min > sum) {
                min = sum;
                answer = i;
            }
        }
        
        System.out.print(answer);
        
        br.close();
    }
    
    private static int bfs(int start) {
        boolean[] visited = new boolean[n + 1];
        
        ArrayDeque<Pos> queue = new ArrayDeque<>();
        
        visited[start] = true;
        queue.addLast(new Pos(start, 1));
        
        int count = 1;
        
        while (!queue.isEmpty()) {
            Pos cur = queue.removeFirst();
            
            int x = cur.x;
            int dist = cur.dist;
            
            for (int next : graph[x]) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.addLast(new Pos(next, dist + 1));
                    
                    count += (dist + 1);
                }
            }
        }
        
        return count;
    }
}
