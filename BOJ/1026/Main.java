import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int A[] = new int[N];
        int B[] = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);
        int result = 0;
        int max = Integer.MIN_VALUE;
        int maxIdx = -1;
        for(int j = 0; j < N; j++) {
            for(int i = 0; i < N; i++) {
                if(max < B[i]) {
                    max = B[i];
                    maxIdx = i;
                }
            }
            result += (A[j] * max);
            B[maxIdx] = Integer.MIN_VALUE;
            max = Integer.MIN_VALUE;
            maxIdx = -1;
        }
        System.out.print(result);
        br.close();
    }
}

