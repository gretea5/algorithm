import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.Comparator;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int h = 0; h < T; h++) {
            int N = Integer.parseInt(br.readLine());
            int arr[][] = new int[N][2];
            for(int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                arr[i][0] = Integer.parseInt(st.nextToken());
                arr[i][1] = Integer.parseInt(st.nextToken());
            }
            //서류 심사를 기준으로 오름차순 정렬을 한다.
            Arrays.sort(arr, new Comparator<int[]>() {
                @Override
                public int compare(int[] arr1, int[] arr2) {
                    if(arr1[0] == arr2[0]) {
                        return arr1[1] - arr2[1];
                    }
                    return arr1[0] - arr2[0];
                }
            });
            //1등인 지원자는 무조건 하나는 뛰어나므로,
            int count = 1;
            int faceScore = arr[0][1];
            for(int i = 0; i < N; i++) {
                if (faceScore > arr[i][1]) {
                    faceScore = arr[i][1];
                    count += 1;
                }
                //1등인 경우에는 밑에 있는 애들은 다 못했다고 할 수 있다.
                if(arr[i][1] == 1) {
                    break;
                }
            }
            System.out.println(count);
        }
        br.close();
    }
}
