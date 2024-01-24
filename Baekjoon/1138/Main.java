import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //N 입력 및 배열 선언
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        //배열에 값 입력
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        //ArrayList 선언 및 인덱스에 해당하는 값 넣기
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = N - 1; i >= 0; i--) {
            list.add(arr[i], i + 1);
        }

        //출력
        StringBuilder sb = new StringBuilder();
        for(int v : list) {
            sb.append(v + " ");
        }

        System.out.print(sb);
        br.close();
    }
}
