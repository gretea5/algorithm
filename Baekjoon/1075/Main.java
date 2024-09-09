import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String n = br.readLine();
        int f = Integer.parseInt(br.readLine());

        String common = n.substring(0, n.length() - 2);

        int start = Integer.parseInt(common + "99");
        int end = Integer.parseInt(common + "00");

        String answer = "";

        for (int i = start; i >= end; i--) {
            if (i % f == 0) {
                String s = String.valueOf(i);

                answer = s.substring(s.length() - 2);
            }
        }

        System.out.print(answer);

        br.close();
    }
}
