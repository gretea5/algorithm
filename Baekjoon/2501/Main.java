import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int count = 0;
        int answer = Integer.MIN_VALUE;
        for(int i = 1; i <= N; i++) {
            if (N % i == 0) {
                count += 1;
            }
            if(K == count) {
                answer = i;
                break;
            }
        }
        if(answer == Integer.MIN_VALUE) {
            System.out.print(0);
        } else {
            System.out.print(answer);
        }
        br.close();
    }
}
