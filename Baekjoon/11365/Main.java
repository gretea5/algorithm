import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true) {
            String input = br.readLine();
            if(input.equals("END")) break;
            StringBuilder s = new StringBuilder(input);
            sb.append(s.reverse()).append("\n");
        }
        System.out.print(sb);
        br.close();
    }
}
