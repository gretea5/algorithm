import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        long[] fact = new long[n + 1];
        
        fact[0] = 1;
        
        for(int i = 1; i < n + 1; i++) {
            fact[i] = i * fact[i - 1];
        }
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        int command = Integer.parseInt(st.nextToken()); 
        
        boolean[] visited = new boolean[n + 1];
        
        StringBuilder sb = new StringBuilder();
        
        if (command == 1) {
            long k = Long.parseLong(st.nextToken());
            
            ArrayList<Integer> ans = new ArrayList<>();
            
            //각 자릿수에 대해서, 숫자를 넣는다.
            for(int i = n - 1; i >= 0; i--) {
                for(int j = 1; j < n + 1; j++) {
                    if (visited[j]) continue;
                    
                    if (k - fact[i] > 0) {
                        k -= fact[i];
                    }
                    else {
                        ans.add(j);
                        visited[j] = true;
                        break;
                    }
                }
            }
            
            for(int v : ans) {
                sb.append(v).append(" ");
            }
        }
        else {
            int[] arr = new int[n];
            
            for(int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            
            long answer = 1;
            
            for(int i = 0; i < n; i++) {
                for(int j = 1; j < arr[i]; j++) {
                    if (visited[j]) continue;
                    
                    answer += fact[n - 1 - i];
                }
                
                visited[arr[i]] = true;
            }
            
            sb.append(answer);
        }
        
        System.out.print(sb);
        
        br.close();
    }
}
