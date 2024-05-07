import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    private static int n;
    
    private static boolean[] arr;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        
        arr = new boolean[n + 1];
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        for(int i = 1; i <= n; i++) {
            int v = Integer.parseInt(st.nextToken());
            
            if (v == 1) {
                arr[i] = true;
            }
            else {
                arr[i] = false;
            }
        }
        
        int k = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            
            int sex = Integer.parseInt(st.nextToken());
            int number = Integer.parseInt(st.nextToken());
            
            if (sex == 1) {
                changeMaleSwitch(number);
            }
            else {
                changePussySwitch(number);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        
        for(int i = 1; i <= n; i++) {
            if (arr[i]) {
                sb.append(1);
            }
            else {
                sb.append(0);
            }
            
            sb.append(" ");
            
            if (i % 20 == 0) {
                sb.append("\n");
            }
        }
        
        System.out.print(sb);
        
        br.close();
    }
    
    private static void changeMaleSwitch(int number) {
        for(int i = 1; i <= n; i++) {
            if (i % number == 0) {
                arr[i] = !arr[i];
            }
        }
    }
    
    private static void changePussySwitch(int number) {
        int left = number;
        int right = number;
        
        while(left > 0 && right < n + 1){
            if (arr[left] != arr[right])  {
                break;
            }
            
            left -= 1;
            right += 1;
        }
        
        left += 1;
        right -= 1;
        
        for(int i = left; i <= right; i++) {
            arr[i] = !arr[i];
        }
    }
}
