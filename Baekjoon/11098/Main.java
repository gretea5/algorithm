import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int t = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        
        for(int test = 1; test <= t; test++) {
            int p = Integer.parseInt(br.readLine());
            
            HashMap<Integer, String> map = new HashMap<>();
            
            for(int i = 0; i < p; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                
                int price = Integer.parseInt(st.nextToken());
                String name = st.nextToken();
                
                map.put(price, name);
            }
            
            int max = Integer.MIN_VALUE;
            
            for(int price : map.keySet()) {
                max = Math.max(max, price);
            }
            
            sb.append(map.get(max)).append("\n");
        }
        
        System.out.print(sb);
        
        br.close();
    }
}
