import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		for (int test = 1; test <= t; test++) {
		    int k = Integer.parseInt(br.readLine());
		    
		    TreeMap<Integer, Integer> map = new TreeMap<>();
		    
		    while (k > 0) {
		        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		        
		        String command = st.nextToken();
		        int n = Integer.parseInt(st.nextToken());
		        
		        if (command.equals("I")) {
		            map.put(n, map.getOrDefault(n, 0) + 1);
		        }
		        else {
		            if (!map.keySet().isEmpty()) {
		                //최댓값
    		            if (n == 1) {
    		                int key = map.lastKey();
    		                
    		                int value = map.get(key);
    		                
    		                if (value == 1) {
    		                    map.remove(key);
    		                }
    		                else {
    		                    map.put(key, value - 1);
    		                }
    		            }
    		            //최솟값
    		            else {
    		               int key = map.firstKey();
    		               
    		               int value = map.get(key);
    		                
        	                if (value == 1) {
        	                    map.remove(key);
        	                }
        	                else {
        	                    map.put(key, value - 1);
        	                }
    		            }
		            }
		        }
		        
		        k -= 1;
		    }
		    
		    if (map.keySet().isEmpty()) {
		        sb.append("EMPTY");
		    }
		    else {
		        sb.append(map.lastKey()).append(" ").append(map.firstKey());
		    }
		    
		    sb.append("\n");
		}
		
		System.out.print(sb);
		
		br.close();
	}
}
