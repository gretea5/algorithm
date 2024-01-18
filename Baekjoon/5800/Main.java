import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //K 입력
        int K = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for(int t = 1; t <= K; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            //N 입력
            int N = Integer.parseInt(st.nextToken());
            //배열 선언
            int[] arr = new int[N];

            //배열에 값 입력
            for(int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            //오름 차순 정렬
            Arrays.sort(arr);

            //가장 큰 점수 차이
            int gap = Integer.MIN_VALUE;

            //점수 차이 계산
            for(int i = 0; i < N - 1; i++) {
                gap = Math.max(gap, arr[i + 1] - arr[i]);
            }

            //출력 형식 지정
            sb.append("Class ").append(t).append("\n");
            sb.append("Max ").append(arr[arr.length - 1]).append(", ");
            sb.append("Min ").append(arr[0]).append(", ");
            sb.append("Largest gap ").append(gap).append("\n");
        }
        //출력
        System.out.print(sb);
        br.close();
    }
}
