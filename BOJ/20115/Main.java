import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        double arr[] = new double[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) {
            arr[i] = Double.parseDouble(st.nextToken());
        }
        Arrays.sort(arr);
        double answer = arr[arr.length - 1];
        for(int i = 0; i < arr.length - 1; i++) {
            answer += (arr[i] / 2);
        }
        System.out.print(answer);
        br.close();
    }
}
