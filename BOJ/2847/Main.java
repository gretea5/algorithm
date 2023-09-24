import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        int max = arr[arr.length - 1];
        int sum = 0;
        for(int i = arr.length - 2; i >= 0; i--) {
            if(arr[i] > max - 1) {
                sum += arr[i] - max + 1;
                max--;
            }
            else {
                max = arr[i];
            }
        }
        System.out.print(sum);
        br.close();
    }
}
