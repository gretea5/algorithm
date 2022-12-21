import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.Arrays;


public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int arr[] = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        int result = Integer.MIN_VALUE;
        int maxWeight = -1;
        for(int i = 0; i < N; i++) {
            maxWeight = arr[i] * (N - i);
            if(result < maxWeight) {
                result = maxWeight;
            }
        }
        System.out.print(result);
        br.close();
    }
}
