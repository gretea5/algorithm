import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for(int k = 0; k < M; k++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if (a == 1) {
                arr[b - 1] = c;
            }
            else if (a == 2) {
                for(int i = b; i <= c; i++) {
                    if (arr[i - 1] == 1) {
                        arr[i - 1] = 0;
                    }
                    else {
                        arr[i - 1] = 1;
                    }
                }
            }
            else if (a == 3) {
                for(int i = b; i <= c; i++) {
                    arr[i - 1] = 0;
                }
            }
            else {
                for(int i = b; i <= c; i++) {
                    arr[i - 1] = 1;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < arr.length; i++) {
            sb.append(arr[i]).append(" ");
        }
        System.out.print(sb);
        br.close();
    }
}
