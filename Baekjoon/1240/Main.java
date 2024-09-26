import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.ArrayDeque;

public class Main {
    private static class Node {
        int num;
        int cost;
        
        Node(int num, int cost) {
            this.num = num;
            this.cost = cost;
        }
    }
    
    private static int n;
    private static ArrayList<Node>[] graph;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        graph = new ArrayList[n + 1];
        
        for (int i = 0; i < n + 1; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            
            graph[num1].add(new Node(num2, cost));
            graph[num2].add(new Node(num1, cost));
        }
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            
            sb.append(bfs(n1, n2)).append("\n");
        }
        
        System.out.print(sb);
        
        br.close();
    }
    
    private static int bfs(int s, int e) {
        boolean[] visited = new boolean[n + 1];
        
        visited[s] = true;
        
        ArrayDeque<Node> queue = new ArrayDeque<>();
        
        for(Node node : graph[s]) {
            queue.addLast(node);
            visited[node.num] = true;
        }
        
        while (!queue.isEmpty()) {
            Node cur = queue.removeFirst();
            
            int num = cur.num;
            int cost = cur.cost;
            
            if (num == e) {
                return cost;
            }
            
            for (Node node : graph[num]) {
                if (!visited[node.num]) {
                    queue.addLast(new Node(node.num, cost + node.cost));
                    visited[node.num] = true;
                }
            }
        }
        
        return -1;
    }
}
