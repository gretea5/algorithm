import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        int v1, v2;

        if (s.length() == 3) {
            if (s.charAt(1) == '0') {
                v1 = Integer.parseInt(s.substring(0, 2));
                v2 = Integer.parseInt(s.substring(2));
            }
            else {
                v1 = Integer.parseInt(s.substring(0, 1));
                v2 = Integer.parseInt(s.substring(1));
            }
        }
        else if (s.length() == 4) {
            v1 = Integer.parseInt(s.substring(0, 2));
            v2 = Integer.parseInt(s.substring(2));
        }
        else {
            v1 = Integer.parseInt(s.substring(0, 1));
            v2 = Integer.parseInt(s.substring(1));
        }

        System.out.print(v1 + v2);

        br.close();
    }
}
