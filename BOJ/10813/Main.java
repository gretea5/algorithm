import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
public class Main {
    private static int[] bucket;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        bucket = new int[N + 1];
        for(int i = 1; i <= N; i++) {
            bucket[i] = i;
        }
        for(int k= 0; k < M; k++) {
            st = new StringTokenizer(br.readLine(), " ");
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            exchange(i , j);
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i < bucket.length; i++) {
            sb.append(bucket[i]).append(" ");
        }
        System.out.print(sb);
        br.close();
    }
    private static void exchange(int i, int j) {
        int temp = bucket[i];
        bucket[i] = bucket[j];
        bucket[j] = temp;
    }
}
