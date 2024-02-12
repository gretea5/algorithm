import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        while(true) {
            //n을 입력
            int n = Integer.parseInt(br.readLine());

            //-1일 경우 입력의 마지막
            if(n == -1) break;

            //ArrayList 선언
            ArrayList<Integer> arr = new ArrayList<>();

            //합계
            int sum = 0;

            for(int i = 1; i < n; i++) {
                if(n % i == 0) {
                    arr.add(i);
                    sum += i;
                }
            }

            //완전수일 경우
            if(sum == n) {
                sb.append(n).append(" = ");

                for(int i = 0; i < arr.size() - 1; i++) {
                    sb.append(arr.get(i)).append(" + ");
                }

                sb.append(arr.get(arr.size() - 1)).append("\n");

            } else {
                sb.append(n).append(" is NOT perfect.").append("\n");
            }
        }

        System.out.print(sb);

        br.close();
    }
}
