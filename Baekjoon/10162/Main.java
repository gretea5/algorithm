import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int t = Integer.parseInt(br.readLine());
        
        if (t % 10 != 0) {
            System.out.print(-1);
            return;
        }
        
        int[] time = new int[3];
        
        time[0] = 300;
        time[1] = 60;
        time[2] = 10;
        
        int[] count = new int[3];
        
        for(int i = 0; i < 3; i++) {
            count[i] = t / time[i];
            
            t = t % time[i];
        }
        
        StringBuilder sb = new StringBuilder();
        
        for(int v : count) {
            sb.append(v).append(" ");
        }
        
        System.out.print(sb);
        
        br.close();
    }
}
