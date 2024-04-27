import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int q1 = 0;
        int q2 = 0;
        int q3 = 0;
        int q4 = 0;
        int axis = 0;
        
        int n = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            
            if (x > 0 && y > 0) {
                q1 += 1;
            }
            else if (x < 0 && y > 0) {
                q2 += 1;
            }
            else if (x < 0 && y < 0) {
                q3 += 1;
            }
            else if (x > 0 && y < 0) {
                q4 += 1;
            }
            else {
                axis += 1;
            }
        }
        
        System.out.println("Q1: " + q1);
        System.out.println("Q2: " + q2);
        System.out.println("Q3: " + q3);
        System.out.println("Q4: " + q4);
        System.out.print("AXIS: " + axis);
        
        br.close();
    }
}
