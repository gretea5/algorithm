import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    private static class Pos {
        int x;
        int y;
        
        Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int t = Integer.parseInt(br.readLine());
        
        for (int test = 1; test <= t; test++) {
            Pos[] arr = new Pos[4];
            
            for (int i = 0; i < 4; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                
                arr[i] = new Pos(x, y);
            }
            
            double[] sumArr = new double[6];
            int idx = 0;
            
            for (int i = 0; i < 3; i++) {
                for (int j = i + 1; j < 4; j++) {
                    int xDist = arr[i].x - arr[j].x;
                    int yDist = arr[i].y - arr[j].y;
                    
                    sumArr[idx++] = Math.sqrt(Math.pow(xDist, 2) + Math.pow(yDist, 2)) ;
                }
            }
            
            Arrays.sort(sumArr);
            
            boolean isSquare = true;
            
            for (int i = 0; i < 3; i++) {
                if (sumArr[i] != sumArr[i + 1]) {
                    isSquare = false;
                    break;
                }
            }
            
            if (sumArr[4] != sumArr[5]) {
                isSquare = false;
            }
            
            if (isSquare) {
                System.out.println(1);
            }
            else {
                System.out.println(0);
            }
        }
        
        br.close();
    }
}
