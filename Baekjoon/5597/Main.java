import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[] submit = new boolean[31];
        Arrays.fill(submit, false);
        for(int i = 1; i <= 28; i++) {
            int num = Integer.parseInt(br.readLine());
            submit[num] = true;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i < submit.length; i++) {
            if(!submit[i]) {
                sb.append(i).append("\n");
            }
        }
        System.out.print(sb);
        br.close();
    }
}
