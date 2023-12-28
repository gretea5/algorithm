import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;
public class Main {
    private static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        Arrays.fill(arr, 0);
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken()) - 1;
            int end = Integer.parseInt(st.nextToken()) - 1;
            int number = Integer.parseInt(st.nextToken());
            putBall(start, end, number);
        }
        for(int n : arr) {
            sb.append(n).append(" ");
        }
        System.out.print(sb);
        br.close();
    }
    private static void putBall(int start, int end, int number) {
        for(int i = start; i <= end; i++) {
            arr[i] = number;
        }
    }
}
