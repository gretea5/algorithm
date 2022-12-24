import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int arr[][] = new int[N][2];
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        //끝나는 시간을 기준으로 오름차순 정렬
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int arr1[], int arr2[]) {
                if(arr1[1] == arr2[1]) {
                    return arr1[0] - arr2[0];
                }
                return arr1[1] - arr2[1];
            }
        });
        int endTime = Integer.MIN_VALUE;
        int count = 0;
        for(int i = 0; i < N; i++) {
            if (endTime <= arr[i][0]) {
                count += 1;
                endTime = arr[i][1];
            }
        }
        System.out.print(count);
        br.close();
    }
}

