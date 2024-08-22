import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        ArrayList<Integer> arr = new ArrayList<>();
        
        arr.add(0);
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        for (int i = 0; i < n; i++) {
            int value = Integer.parseInt(st.nextToken());
            
            if (arr.get(arr.size() - 1) < value) {
                arr.add(value);
            }
            else if (arr.get(arr.size() - 1) > value) {
                int left = 0;
                int right = arr.size() - 1;
                
                while(left <= right) {
                    int mid = (left + right) / 2;
                    
                    if (value <= arr.get(mid)) {
                        right = mid - 1;
                    }
                    else {
                        left = mid + 1;
                    }
                }
                
                arr.set(left, value);
            }
        }
        
        System.out.print(arr.size() - 1);
        
        br.close();
    }
}
