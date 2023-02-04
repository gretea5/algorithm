import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int count = 0;
        int start = 1, end = 1;
        int sum = 0;
        while(true) {
            //합이 M보다 같거나 클 경우,
            if (sum >= N) {
                sum -= start++;
            }
            //인덱스 범위를 벗어날 경우,
            else if (end > 10000000) {
                break;
            }
            //합이 M이 되지 않을 경우,
            else {
                sum += end++;
            }
            if (sum == N) {
                count += 1;
            }
        }
        System.out.print(count);
        br.close();
    }
}
