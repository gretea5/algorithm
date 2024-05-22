import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int t = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        
        for(int test = 1; test <= t; test++) {
            int n = Integer.parseInt(br.readLine());
            
            HashMap<String, Integer> map = new HashMap<>();
            
            for(int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            
                String name = st.nextToken();
                int amount = Integer.parseInt(st.nextToken());
                
                map.put(name, amount);
            }
            
            String answer = "";
            
            int max = Integer.MIN_VALUE;
            
            for(String name : map.keySet()) {
                int amount = map.get(name);
                
                if (max < amount) {
                    max = amount;
                    answer = name;
                }
            }
            
            sb.append(answer + "\n");
        }
        
        System.out.print(sb);
        
        br.close();
    }
}
