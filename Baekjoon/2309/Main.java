import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int arr[] = new int[9];
        int sum = 0;
        for(int i = 0; i < 9; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }
        Arrays.sort(arr);
        int spy1 = Integer.MIN_VALUE;
        int spy2 = Integer.MIN_VALUE;
        for(int i = 0; i < arr.length; i++) {
            for(int j = i + 1; j < arr.length; j++) {
                if (sum - arr[i] - arr[j] == 100) {
                    spy1 = i;
                    spy2 = j;
                    break;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < arr.length; i++) {
            if(i == spy1 || i == spy2) {
                continue;
            }
            sb.append(arr[i]).append("\n");
        }
        System.out.print(sb.toString());
        br.close();
    }
}
