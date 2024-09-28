import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.ArrayDeque;

public class Main {
    private static class Node {
        int x;
        int cost;
        
        Node(int x, int cost) {
            this.x = x;
            this.cost = cost;
        }
    }
    
    private static int n, d;
    
    private static ArrayList<Node>[] graph;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        n = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        
        graph = new ArrayList[d + 1];
        
        for (int i = 0; i < d + 1; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            
            if (end <= d) {
                graph[start].add(new Node(end, cost));
            }
        }
        
        ArrayDeque<Node> queue = new ArrayDeque<>();
        
        queue.addLast(new Node(0, 0));
        
        int answer = Integer.MAX_VALUE;
        
        while (!queue.isEmpty()) {
            Node cur = queue.removeFirst();
            
            int x = cur.x;
            int cost = cur.cost;
            
            if (x > d) {
                continue;
            }
            
            if (x == d) {
                answer = Math.min(answer, cost);
                continue;
            }
            
            queue.addLast(new Node(x + 1, cost + 1));
            
            //지름길이 있다면,
            if (!graph[x].isEmpty()) {
                for (Node node : graph[x]) {
                    int next = node.x;
                    int nextCost = node.cost;
                    
                    queue.addLast(new Node(next, cost + nextCost));
                }
            }
        }
        
        System.out.print(answer);
        
        br.close();
    }
}
