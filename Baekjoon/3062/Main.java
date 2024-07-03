import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int t = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        
        for(int test = 1; test <= t; test++) {
            String s = br.readLine();
            String reverseStr = new StringBuilder(s).reverse().toString();
            
            int n = Integer.parseInt(s);
            int reverseNumber = Integer.parseInt(reverseStr);
            
            int sum = n + reverseNumber;
            
            String sumStr = String.valueOf(sum);
            String reverseSumStr = new StringBuilder(sumStr).reverse().toString(); 
            
            if (sumStr.equals(reverseSumStr)) {
                sb.append("YES");
            }
            else {
                sb.append("NO");
            }
            
            sb.append("\n");
        }
        
        System.out.print(sb);
        
        br.close();
    }
}
