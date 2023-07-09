import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sum = 0;
        for(int i = 0; i < 5; i++) {
            int num = Integer.parseInt(br.readLine());
            if(num < 40) {
                num = 40;
            }
            sum += num;
        }
        System.out.print(sum / 5);
        br.close();
    }
}
