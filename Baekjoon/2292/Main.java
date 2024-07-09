import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        int sum = 1;
        
        int dist = 1;
        
        while(sum < n) {
            sum += 6 * dist;
            
            dist += 1;
        }
        
        System.out.print(dist);
        
        br.close();
    }
}
