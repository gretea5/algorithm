import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        long[] arr = new long[n];
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        
        Arrays.sort(arr);
        
        long min = Long.MAX_VALUE;
        
        int[] ans = new int[3];
        
        for(int i = 0; i < n - 2; i++) {
            int left = i + 1;
            int right = n - 1;
            
            while (left < right) {
                long sum = arr[i] + arr[left] + arr[right];
                
                long dist = Math.abs(sum);
                
                if (min > dist) {
                    min = dist;
                    
                    ans[0] = (int) arr[i];
                    ans[1] = (int) arr[left];
                    ans[2] = (int) arr[right];
                }
                
                if (sum > 0) {
                    right -= 1;
                }
                else {
                    left += 1;
                }
            }
        }
        
        System.out.print(ans[0] + " " + ans[1] + " " + ans[2]);
        
        br.close();
    }
}
