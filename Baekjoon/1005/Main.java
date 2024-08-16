import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int t = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        
        for (int test = 1; test <= t; test++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            
            int[] time = new int[n + 1];
            
            st = new StringTokenizer(br.readLine(), " ");
            
            for (int i = 1; i <= n; i++) {
                time[i] = Integer.parseInt(st.nextToken());
            }
            
            int[] inDegrees = new int[n + 1];
            
            ArrayList<Integer>[] graph = new ArrayList[n + 1];
            
            for (int i = 1; i <= n; i++) {
                graph[i] = new ArrayList<>();
            }
            
            for (int i = 1; i <= k; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                
                graph[from].add(to);
                
                inDegrees[to] += 1;
            }
            
            int w = Integer.parseInt(br.readLine());
            
            int[] maxTime = new int[n + 1];
            
            Arrays.fill(maxTime, Integer.MIN_VALUE);
            
            ArrayDeque<Integer> queue = new ArrayDeque<>();
            
            for (int i = 1; i <= n; i++) {
                if (inDegrees[i] == 0) {
                    queue.addLast(i);
                    
                    maxTime[i] = time[i];
                }
            }
            
            while (!queue.isEmpty()) {
                int cur = queue.removeFirst();
                
                for (int next : graph[cur]) {
                    inDegrees[next] -= 1;
                    
                    maxTime[next] = Math.max(maxTime[next], maxTime[cur] + time[next]);
                    
                    if (inDegrees[next] == 0) {
                        queue.addLast(next);
                    }
                }
            }
            
            sb.append(maxTime[w]).append("\n");
        }
        
        System.out.print(sb);
        
        br.close();
    }
}
