import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++) {
            String input = br.readLine();
            int len = input.length();
            sb.append(input.charAt(0)).append(input.charAt(len - 1)).append("\n");
        }
        System.out.print(sb);
        br.close();
    }
}
