import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        int[] arr = new int[n];
        
        int sum = 0;
        
        StringBuilder sb = new StringBuilder();
         
        for(int i = 0; i < n; i++) {
            int value = Integer.parseInt(st.nextToken());
            
            if (i == 0) {
                arr[i] = value;
            }
            else {
                arr[i] = (value * (i + 1)) - sum;
            }
            
            sum += arr[i];
        }
        
        for(int v : arr) {
            sb.append(v).append(" ");
        }
        
        System.out.print(sb);
        
        br.close();
    }
}
