import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String input = br.readLine();
        int sum = 0;
        for(int i = 0; i < input.length(); i++) {
            sum += (input.charAt(i) - '0');
        }
        System.out.print(sum);
        br.close();
    }
}
