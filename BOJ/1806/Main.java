import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;

public class Main {
    public static int N, S, total;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int min = Integer.MAX_VALUE;
        total = arr[0];
        int end = 0;
        for(int start = 0; start < N; start++) {
            while(end < N && total < S) {
                end += 1;
                if (end != N) total += arr[end];
            }
            if(end == N) {
                break;
            }
            min = Math.min(min, end - start + 1);
            total -= arr[start];
        }
        if(min == Integer.MAX_VALUE) {
            min = 0;
        }
        System.out.print(min);
        br.close();
    }
}
