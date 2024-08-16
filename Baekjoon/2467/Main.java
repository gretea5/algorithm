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
        
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int left = 0;
        int right = n - 1;
        
        long min = Long.MAX_VALUE;
        
        int leftFluid = -1;
        int rightFluid = -1;
        
        while (left < right) {
            long sum = arr[left] + arr[right];
            
            long dist = Math.abs(sum);
            
            //절댓값으로 차이가 제일 작다는 것은 0보다 가까워진다는 의미
            if (min > dist) {
                min = dist;
                
                leftFluid = arr[left];
                rightFluid = arr[right];
            }
            
            if (sum > 0) {
                right -= 1;
            }
            else {
                left += 1;
            }
        }
        
        System.out.print(leftFluid + " " + rightFluid);
        
        br.close();
    }
}
