import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        if (n == 0) {
            System.out.print(0);
            return;
        }
        else if (n == 1) {
            System.out.print(1);
            return;
        }
        int count = 1;
        int beforeNum = 0;
        int answer = 1;
        while(count != n) {
            int sum = beforeNum + answer;
            beforeNum = answer;
            answer = sum;
            count += 1;
        }
        System.out.print(answer);
        br.close();
    }
}
