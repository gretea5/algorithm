import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        int[] arr = new int[n];
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        int left = 1;
        int right = Integer.MIN_VALUE;
        
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            
            right = Math.max(arr[i], right);
        }
        
        int m = Integer.parseInt(br.readLine());
        
        while(left <= right) {
            int mid = (left + right) / 2;
            
            if (check(arr, m, mid)) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        
        System.out.print(left - 1);
        
        br.close();
    }
    
    private static boolean check(int[] arr, int total, int money) {
        int sum = 0;
        
        for(int v : arr) {
            if (v > money) {
                sum += money;
            }
            else {
                sum += v;
            }
        }
        
        return total >= sum;
    }
}
