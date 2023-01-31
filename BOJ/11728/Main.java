import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        String[] arr1 = br.readLine().split(" ");
        String[] arr2 = br.readLine().split(" ");
        int[] result = new int[N + M];
        int i = 0;
        int j = 0;
        int idx = 0;
        while(i < N || j < M) {
            if (i < N) {
                result[idx++] = Integer.parseInt(arr1[i++]);
            }
            if (j < M) {
                result[idx++] = Integer.parseInt(arr2[j++]);
            }
        }
        Arrays.sort(result);
        StringBuilder sb = new StringBuilder();
        for(int k = 0; k < result.length; k++) {
            sb.append(result[k]).append(" ");
        }
        System.out.print(sb);
        br.close();

    }
}
