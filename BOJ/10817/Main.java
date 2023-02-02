import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.Collections;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer[] arr = new Integer[3];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < 3; i++) {
            int y = Integer.parseInt(st.nextToken());
            arr[i] = y;
        }
        Arrays.sort(arr, Collections.reverseOrder());
        System.out.print(arr[1]);
        br.close();
    }
}
