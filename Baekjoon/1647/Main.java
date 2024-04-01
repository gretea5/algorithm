import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
    private static class Road {
        int n1;
        int n2;
        int weight;
        
        Road(int n1, int n2, int weight) {
            this.n1 = n1;
            this.n2 = n2;
            this.weight = weight;
        }
    }
    
    private static int[] parent;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        parent = new int[N + 1];
        
        for(int i = 1; i <= N; i++) {
            parent[i] = i;
        }
        
        Road[] arr = new Road[M];
        
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            
            arr[i] = new Road(n1, n2, weight);
        }
        
        Arrays.sort(arr, (r1, r2) -> {
            return r1.weight - r2.weight;
        });
        
        int max = Integer.MIN_VALUE;
        
        int answer = 0;
        
        for(Road r : arr) {
            if (find(r.n1) != find(r.n2)) {
                union(r.n1, r.n2);
                
                answer += r.weight;
                
                max = Math.max(max, r.weight);
            }
        }
        
        System.out.print(answer - max);
        
        br.close();
    }
    
    private static void union(int a, int b) {
        int p1 = find(a);
        int p2 = find(b);
        
        parent[p1] = p2;
    }
    
    private static int find(int a) {
        if (parent[a] == a) {
            return a;
        }
        
        parent[a] = find(parent[a]);
        
        return parent[a];
    }
}
