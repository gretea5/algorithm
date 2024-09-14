import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        long rowCnt = 0;
        long colCnt = 0;
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        
        rowCnt += (r / n);
        
        if (r % n != 0) {
            rowCnt += 1;
        }
        
        colCnt += (c / n);
        
        if (c % n != 0) {
            colCnt += 1;
        }
        
        System.out.print(rowCnt * colCnt);
        
        br.close();
    }
}
