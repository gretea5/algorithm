import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
    public static int binarySearch(int[] arr, int target) {
        int leftIdx = 0;
        int rightIdx = arr.length - 1;
        int result = 0;
        while(leftIdx <= rightIdx) {
            int mid = (leftIdx + rightIdx) / 2;
            if(target < arr[mid]) {
                rightIdx = mid - 1;
            } else if (target > arr[mid]) {
                leftIdx = mid + 1;
            } else {
                result = 1;
                break;
            }
        }
        return result;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < M; i++) {
            int target = Integer.parseInt(st.nextToken());
            sb.append(binarySearch(arr, target)).append("\n");
        }
        System.out.print(sb);
        br.close();
    }
}
