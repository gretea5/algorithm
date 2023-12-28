import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long [] arr = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(arr);
        int len = arr.length;
        long max = Long.MIN_VALUE;
        if(len % 2 != 0) {
            len -= 1;
            max = arr[arr.length - 1];
        }
        for(int i = 0; i < (len / 2); i++) {
            long sum = arr[i] + arr[len - i - 1];
            if (max < sum) {
                max = sum;
            }
        }
        System.out.print(max);
        br.close();
    }
}
