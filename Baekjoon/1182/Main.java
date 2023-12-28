import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;

public class Main {
    static int[] arr = new int[21];
    static int N, S;
    static int count = 0;
    public static void func(int cur, int tot) {
        if(cur == N) {
            if(tot == S){
                count += 1;
            }
            return;
        }
        func(cur + 1, tot);
        func(cur + 1, tot + arr[cur]);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        func(0, 0);
        if(S == 0) {
            count -= 1;
        }
        System.out.print(count);
        br.close();
    }
}
