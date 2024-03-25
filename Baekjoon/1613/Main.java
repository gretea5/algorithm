import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int kk = Integer.parseInt(st.nextToken());

        boolean[][] arr = new boolean[n + 1][n + 1];

        for(int i = 0; i < kk; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int front = Integer.parseInt(st.nextToken());
            int back = Integer.parseInt(st.nextToken());

            arr[front][back] = true;
        }

        for(int k = 1; k <= n; k++) {
            for(int i = 1; i <= n; i++) {
                for(int j = 1; j <= n; j++) {
                    if(arr[i][k] && arr[k][j]) {
                        arr[i][j] = true;
                    }
                }
            }
        }

        int s = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < s; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int front = Integer.parseInt(st.nextToken());
            int back = Integer.parseInt(st.nextToken());

            if(arr[front][back]) {
                sb.append(-1);
            }
            else if(arr[back][front]) {
                sb.append(1);
            }
            else {
                sb.append(0);
            }

            sb.append("\n");
        }

        System.out.print(sb);

        br.close();
    }
}
