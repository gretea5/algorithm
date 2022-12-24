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
        int K = Integer.parseInt(st.nextToken());
        int arr[] = new int[N];
        int distanceArr[] = new int[N-1];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for(int i = 0; i < N - 1; i++) {
            distanceArr[i] = arr[i + 1] - arr[i];
        }
        Arrays.sort(distanceArr);
        int answer = 0;
        for(int i = 0; i < N - K; i++) {
            answer += distanceArr[i];
        }
        System.out.print(answer);
        br.close();
    }
}
