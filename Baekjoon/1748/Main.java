import java.io.BufferedReader; 
import java.io.InputStreamReader;
import java.io.IOException;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String s = br.readLine();
        
        int length = s.length();
        
        int answer = 0;
        
        for(int i = 0; i < length - 1; i++) {
            answer += ((int) Math.pow(10, i)) * 9 * (i + 1);
        }
        
        int minus = (int) Math.pow(10, length - 1);
        
        int n = Integer.parseInt(s);
        
        answer += (n - minus + 1) * length;
        
        System.out.print(answer);
        
        br.close();
    }
}
