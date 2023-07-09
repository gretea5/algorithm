import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    static int inputNumber = 3;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for(int k = 0; k < inputNumber; k++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int num_0 = 0;
            int num_1 = 0;
            for(int i = 0; i < 4; i++) {
                int num = Integer.parseInt(st.nextToken());
                if (num == 0) {
                    num_0 += 1;
                }
                else if (num == 1) {
                    num_1 += 1;
                }
            }
            if (num_0 == 1 && num_1 == 3) {
                sb.append('A');
            }
            else if (num_0 == 2 && num_1 == 2) {
                sb.append('B');
            }
            else if (num_0 == 3 && num_1 == 1) {
                sb.append('C');
            }
            else if (num_0 == 4) {
                sb.append('D');
            }
            else if (num_1 == 4) {
                sb.append('E');
            }
            sb.append('\n');
        }
        System.out.print(sb);
        br.close();
    }
}
