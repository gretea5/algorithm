import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int k = 0; k < T; k++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int candyCount = Integer.parseInt(st.nextToken());
            int boxCount = Integer.parseInt(st.nextToken());
            Integer[] arr = new Integer[boxCount];
            for(int i = 0; i < boxCount; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int n1 = Integer.parseInt(st.nextToken());
                int n2 = Integer.parseInt(st.nextToken());
                arr[i] = n1 * n2;
            }
            Arrays.sort(arr, Collections.reverseOrder());
            int count = 0;
            for(int i = 0; i < arr.length; i++) {
                if (candyCount <= 0) {
                    break;
                }
                candyCount -= arr[i];
                count += 1;
            }
            sb.append(count).append("\n");
        }
        System.out.print(sb);
        br.close();
    }
}
