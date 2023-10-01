import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        //첫 번째 링 입력
        int first = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N - 1; i++) {
            //다른 링 입력
            int otherRing = Integer.parseInt(st.nextToken());
            //최대공약수 계산
            int max = calMax(first, otherRing);
            //기약 분수 형태
            sb.append(first / max).append("/").append(otherRing / max).append("\n");
        }
        //출력
        System.out.print(sb);
        br.close();
    }
    private static int calMax(int first, int element) {
        int max = 0;
        for(int i = 1; i <= element; i++) {
            if(first % i == 0 && element % i == 0) {
                max = i;
            }
        }
        return max;
    }
}
