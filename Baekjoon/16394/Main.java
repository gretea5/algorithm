import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int year = Integer.parseInt(br.readLine());
        
        System.out.print(year - 1946);
        
        br.close();
    }
}
