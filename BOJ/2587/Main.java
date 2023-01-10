import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[] arr = new int[5];
        int sum = 0;
        for(int i = 0; i < 5; i++) {
            int num = Integer.parseInt(br.readLine());
            arr[i] = num;
            sum += num;
        }
        Arrays.sort(arr);
        sb.append(sum / 5).append("\n").append(arr[2]);
        System.out.print(sb);
        br.close();
    }
}
