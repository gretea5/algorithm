import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int month = Integer.parseInt(br.readLine());
        int day = Integer.parseInt(br.readLine());
        
        if (month > 2) {
            System.out.print("After");
        }
        else if (month == 2) {
            if (day > 18) {
                System.out.print("After");
            }
            else if (day == 18) {
                System.out.print("Special");
            }
            else {
                System.out.print("Before");
            }
        }
        else {
            System.out.print("Before");
        }
        
        br.close();
    }
}
