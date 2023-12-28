import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String s = br.readLine();
        int count = 0;
        while(true) {
            if (!input.contains(s)) break;
            input = input.replaceFirst(s, "0");
            count++;
        }
        System.out.print(count);
        br.close();
    }
}
