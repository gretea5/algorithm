import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[3];
        for(int i = 0; i < 3; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int answer = 0;
        if(arr[0] == arr[1] && arr[1] == arr[2]) {
            answer = 10000 + (arr[1] * 1000);
        }
        else if (arr[0] == arr[1] || arr[1] == arr[2]) {
            answer = 1000 + (arr[1] * 100);
        }
        else if (arr[0] != arr[1] && arr[1] != arr[2]) {
            answer = arr[2] * 100;
        }
        System.out.print(answer);
        br.close();
    }
}
