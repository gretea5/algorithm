import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int t = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        
        for(int test = 1; test <= t; test++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " "); 
        
            int n = Integer.parseInt(st.nextToken());
            
            double[] scores = new double[n];
            
            double sum = 0.0;
            
            for(int i = 0; i < n; i++) {
                scores[i] = Double.parseDouble(st.nextToken());
                
                sum += scores[i];
            }
            
            double avg = sum / n;
            
            int count = 0;
            
            for(double score : scores) {
                if (avg < score) {
                    count += 1;
                }
            }
            
            double persent = (count * 100.0) / n;
            
            double result = Math.round(persent * 1000.0) / 1000.0;
            
            String resultStr = String.format("%.3f", result);
            
            sb.append(resultStr).append("%").append("\n");
        }
        
        System.out.print(sb);
        
        br.close(); 
    }
}
