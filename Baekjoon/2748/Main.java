import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.Arrays;


public class Main {
    public static long[] d;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        if (n == 0) {
            System.out.print(0);
            return;
        }
        else if (n == 1 || n == 2) {
            System.out.print(1);
            return;
        }
        else {
            d = new long[n + 1];
            d[0] = 0;
            d[1] = 1;
            d[2] = 1;
            for(int i = 3; i < n + 1; i++) {
                d[i] = d[i - 1] +  d[i - 2];
            }
            long answer = d[n];
            System.out.print(answer);
        }
        br.close();
    }
}
