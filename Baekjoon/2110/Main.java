import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        //오름차순 정렬
        Arrays.sort(arr);

        int start = 1;
        int end = arr[n - 1];

        while(start <= end) {
            //이동 거리
            int dist = (start + end) / 2;

            //집 시작 인덱스
            int cur = 0;

            //공유기의 개수
            int count = 1;

            for(int i = 1; i < n; i++) {
                //dist보다 같거나 클때,
                if (arr[i] - arr[cur] >= dist) {
                    cur = i;
                    count += 1;
                }
            }

            //공유기를 덜 설치할 수 밖에 없을 경우,
            if (count < c) {
                end = dist - 1;
            }
            else {
                start = dist + 1;
            }
        }

        System.out.print(start - 1);

        br.close();
    }
}
