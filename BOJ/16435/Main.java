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
        int L = Integer.parseInt(st.nextToken());
        int arr[] = new int[N];
        boolean check[] = new boolean[N];
        Arrays.fill(check, false);
        st = new StringTokenizer(br.readLine(), " ");
        //배열 입력
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int result = L;
        Arrays.sort(arr);
        for(int i = 0; i < arr.length; i++) {
            if(result >= arr[i]) {
                result += 1;
            }
        }
        System.out.print(result);
        br.close();
    }
}
