import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    private static class Pair {
        int num;
        String command;
        
        Pair(int num, String command) {
            this.num = num;
            this.command = command;
        }
    }
    
    private static int a;
    private static int b;
    
    private static boolean[] visited;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int t = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        
        for(int test = 1; test <= t; test++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            
            visited = new boolean[10001];
            
            sb.append(bfs() + "\n");
        }
        
        System.out.print(sb);
        
        br.close();
    }
    
    private static String bfs() {
        ArrayDeque<Pair> queue = new ArrayDeque<>();
            
        visited[a] = true;
        
        queue.addLast(new Pair(a, ""));
        
        while(!queue.isEmpty()) {
            Pair cur = queue.removeFirst();
            
            int num = cur.num;
            String command = cur.command;
            
            if (num == b) {
                return command;
            }
            
            int d = (num * 2) % 10000;
            int s = num - 1;
            
            if (s == -1) {
                s = 9999;
            }
            
            int l = (num % 1000) * 10 + (num / 1000);
            int r = (num % 10) * 1000 + (num / 10);
            
            if (!visited[d]) {
                visited[d] = true;
                queue.addLast(new Pair(d, command + "D"));
            }
            
            if (!visited[s]) {
                visited[s] = true;
                queue.addLast(new Pair(s, command + "S"));
            }
            
            if (!visited[l]) {
                visited[l] = true;
                queue.addLast(new Pair(l, command + "L"));
            }
            
            if (!visited[r]) {
                visited[r] = true;
                queue.addLast(new Pair(r, command + "R"));
            }
        }
        
        return "";
    }
}
