import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int[] arr = new int[10];
        for(int i = 0; i < input.length(); i++) {
            int idx = input.charAt(i) - '0';
            if (idx == 6) {
                arr[9] += 1;
            }
            else {
                arr[idx] += 1;
            }
        }
        int answer = (arr[9] / 2) + (arr[9] % 2);
        for(int i = 0; i < 9; i++) {
            answer = Math.max(answer, arr[i]);
        }
        System.out.print(answer);
        br.close();
    }
}
