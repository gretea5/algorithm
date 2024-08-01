import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        int[] arr = new int[n];
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(arr);
        
        int left = 0;
        int right = n - 1;
        
        int answerLeft = -1;
        int answerRight = -1;
        
        int min = Integer.MAX_VALUE;
        
        //left와 right가 같으면 안된다
        while(left < right) {
            int result = arr[left] + arr[right];
            
            if (min > Math.abs(result)) {
                answerLeft = arr[left];
                answerRight = arr[right];
                
                min = Math.abs(result);
            }
            
            if (result > 0) {
                right -= 1;
            }
            else {
                left += 1;
            }
        }
        
        System.out.print(answerLeft + " " + answerRight);
        
        br.close();
    }
}
