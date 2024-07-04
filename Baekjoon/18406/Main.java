import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String n = br.readLine();
        
        int half = n.length() / 2;
        
        String front = n.substring(0, half);
        String back = n.substring(half);
        
        int frontSum = 0;
        
        for(char ch : front.toCharArray()) {
            frontSum += ch - '0';
        }
        
        int backSum = 0;
        
        for(char ch : back.toCharArray()) {
            backSum += ch - '0';
        }
        
        String result = frontSum == backSum ? "LUCKY" : "READY";
        
        System.out.print(result);
        
        br.close();
    }
}
