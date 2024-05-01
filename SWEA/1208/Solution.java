import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        for(int test = 1; test <= 10; test++) {
            //평탄화 횟수
            int n = Integer.parseInt(br.readLine());

            int[] arr = new int[100];

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            for(int i = 0; i < 100; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;

            int minIdx = -1;
            int maxIdx = -1;

            //평탄화 작업
            for(int i = 1; i <= n; i++) {
                min = Integer.MAX_VALUE;
                max = Integer.MIN_VALUE;

                minIdx = -1;
                maxIdx = -1;

                //1회의 평탄화에서 최대 최소 인덱스 기록
                for(int j = 0; j < 100; j++) {
                    if (min > arr[j]) {
                        min = arr[j];
                        minIdx = j;
                    }

                    if (max < arr[j]) {
                        max = arr[j];
                        maxIdx = j;
                    }
                }

                //평탄화 수행
                arr[maxIdx] -= 1;
                arr[minIdx] += 1;

                //평탄화 수행후, 최소, 최대 찾기 최댓값이 여러개를 가졌는데 1을 뺀다고해서 최댓값이 달라지는게 아님.
                min = Integer.MAX_VALUE;
                max = Integer.MIN_VALUE;

                for(int h : arr) {
                    min = Math.min(min, h);
                    max = Math.max(max, h);
                }

                if (max - min <= 1) {
                    break;
                }
            }

            sb.append("#").append(test).append(" ");
            sb.append(max - min).append("\n");
        }

        System.out.print(sb);

        br.close();
    }
}
