import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    private static class Ingredient {
        int n1;
        int n2;
        Ingredient(int n1, int n2) {
            this.n1 = n1;
            this.n2 = n2;
        }
    }

    private static int N;
    private static long answer;

    private static Ingredient[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        arr = new Ingredient[N];

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            //입력
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());

            //배열에 넣기
            arr[i] = new Ingredient(n1, n2);
        }

        answer = Long.MAX_VALUE;

        //처음 재료를 사용할 경우부터 dfs 호출
        for(int i = 0; i < N; i++) {
            dfs(i, arr[i].n1, arr[i].n2);
        }

        //출력
        System.out.print(answer);

        br.close();
    }

    private static void dfs(int i, long n1, long n2) {
        //차이의 최솟값을 갱신
        answer = Math.min(answer, Math.abs(n1 - n2));

        //다음 재료들을 사용한다.
        for(int j = i + 1; j < N; j++) {
            dfs(j, n1 * arr[j].n1, n2 + arr[j].n2);
        }
    }
}
