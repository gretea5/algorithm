import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.ArrayDeque;

public class Main {
    private static ArrayList<Integer>[] graph;
    private static int[] inDegree;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        graph = new ArrayList[n + 1];
        inDegree = new int[n + 1];
        
        for(int i = 0; i < n + 1; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            graph[a].add(b);
            
            inDegree[b] += 1;
        }
        
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        
        for(int i = 1; i < n + 1; i++) {
            if (inDegree[i] == 0) {
                queue.addLast(i);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        
        while(!queue.isEmpty()) {
            int cur = queue.removeFirst();
            
            sb.append(cur).append(" ");
            
            for(int next: graph[cur]) {
                inDegree[next] -= 1;
                
                if (inDegree[next] == 0) {
                    queue.addLast(next);
                }
            }
        }
        
        System.out.print(sb);
        
        br.close();
    }
}
