import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        //배열 입력
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        //오름 차순 정렬
        Arrays.sort(arr);

        //출력
        StringBuilder sb = new StringBuilder();

        for (int v : arr) {
            sb.append(v).append(" ");
        }

        System.out.print(sb);

        br.close();
    }
}
