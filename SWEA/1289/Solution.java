import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for(int test = 1; test <= t; test++) {
            String origin = br.readLine();

            StringBuilder builder = new StringBuilder();

            for(int i = 0; i < origin.length(); i++) {
                builder.append("0");
            }

            //초기 메모리
            String init = builder.toString();

            int count = 0;

            while(true) {
                if (origin.equals(init)) {
                    break;
                }

                for(int i = 0; i < origin.length(); i++) {
                    if (init.charAt(i) != origin.charAt(i)) {
                        //i번째 부터 문자를 변경
                        init = changeStr(i, origin.charAt(i), init);
                        break;
                    }
                }

                count += 1;
            }

            sb.append("#").append(test).append(" ");
            sb.append(count).append("\n");
        }

        System.out.print(sb);

        br.close();
    }

    private static String changeStr(int idx, char ch, String init) {
        StringBuilder builder = new StringBuilder(init.substring(0, idx));

        for(int i = idx; i < init.length(); i++) {
            builder.append(ch);
        }

        return builder.toString();
    }
}
