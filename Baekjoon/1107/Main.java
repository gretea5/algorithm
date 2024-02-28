import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    private static final int startChannel = 100;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        HashSet<Integer> set = new HashSet<>();

        if(m > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            //집합에 고장난 버튼의 정보를 넣기
            for(int i = 0; i < m; i++) {
                set.add(Integer.parseInt(st.nextToken()));
            }
        }
        //전부 +, - 버튼을 누를 경우,
        int answer = Math.abs(n - startChannel);

        for(int i = 0; i <= 999999; i++) {
            String s = String.valueOf(i);
            int length = s.length();

            boolean flag = false;

            for(int j = 0; j < length; j++) {
                if(set.contains(s.charAt(j) - '0')) {
                    flag = true;
                    break;
                }
            }

            if(!flag) {
                answer = Math.min(answer, length + Math.abs(n - i));
            }
        }

        //출력
        System.out.print(answer);

        br.close();
    }
}
