import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < input.length(); i++) {
            sb.append(input.charAt(i));
            if (i % 10 == 9) {
                sb.append("\n");
            }
        }
        System.out.print(sb);
        br.close();
    }
}
