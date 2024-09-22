import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String s1 = br.readLine();
        String s2 = br.readLine();
        String s3 = br.readLine();
        
        int a = Integer.parseInt(s1);
        int b = Integer.parseInt(s2);
        int c = Integer.parseInt(s3);
        
        System.out.println(a + b - c);
        
        a = Integer.parseInt(s1 + s2);
        b = Integer.parseInt(s3);
        
        System.out.println(a - b);
        
        br.close();
    }
}
