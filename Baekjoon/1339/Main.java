import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] alpha = new int['Z' - 'A' + 1];

        for(int i = 0; i < N; i++) {
            String s = br.readLine();

            for(int j = 0; j < s.length(); j++) {
                char ch = s.charAt(j);
                //가중치를 둔다, 즉 1011 막 이런꼴중에 제일 큰 애에 9를 넣는데 유리하다.
                alpha[ch - 'A'] += (int) Math.pow(10, s.length() - 1 - j);
            }
        }

        //오름차순 정렬
        Arrays.sort(alpha);

        int answer = 0;
        int number = 9;

        for(int i = alpha.length - 1; i >= 0; i--) {
            if(alpha[i] == 0) {
                break;
            }

            answer += alpha[i] * number;
            number -= 1;
        }

        System.out.print(answer);

        br.close();
    }
}
