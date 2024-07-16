import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        String n = st.nextToken();
        int b = Integer.parseInt(st.nextToken());
        
        HashMap<Character, Integer> map = new HashMap<>();
        
        for(char ch = '0'; ch <= '9'; ch++) {
            map.put(ch, ch - '0');
        }
        
        for(char ch = 'A'; ch <= 'Z'; ch++) {
            int dist = (ch - 'A') + 10;
            
            map.put(ch, dist);
        }
        
        int count = n.length() - 1;
        
        int sum = 0;
        
        for(char ch : n.toCharArray()) {
            int num1 = map.get(ch);
            int num2 = (int) Math.pow(b, count);
            
            sum += (num1 * num2);
            
            count -= 1;
        }
        
        System.out.print(sum);
        
        br.close();
    }
}
