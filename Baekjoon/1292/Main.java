import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        int a = Integer.parseInt(st.nextToken()) - 1;
        int b = Integer.parseInt(st.nextToken()) - 1;
        
        ArrayList<Integer> arr = new ArrayList<>();
        
        int start = 1;
        
        while(arr.size() < 1000) {
            for(int i = 0; i < start; i++) {
                arr.add(start);
            }
            
            start += 1;
        }
        
        int sum = 0;
        
        for(int i = a; i <= b; i++) {
            sum += arr.get(i);
        }
        
        System.out.print(sum);
        
        br.close();
    }
}
