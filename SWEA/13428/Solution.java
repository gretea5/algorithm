import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for(int test = 1; test <= T; test++) {
            String s = br.readLine();

            sb.append("#").append(test).append(" ");

            if (s.equals("0")) {
                sb.append(0).append(" ").append(0).append("\n");
                continue;
            }

            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;

            char[] arr = s.toCharArray();

            for(int i = 0; i < arr.length; i++) {
                for(int j = 0; j < arr.length; j++) {
                    char temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;

                    //앞자리가 0이 아닐때, 최대 최소 비교를 해야함.
                    if (arr[0] != '0') {
                        StringBuilder sBuilder = new StringBuilder();

                        for(char ch : arr) {
                            sBuilder.append(ch);
                        }

                        int value = Integer.parseInt(sBuilder.toString());

                        max = Math.max(max, value);

                        min = Math.min(min, value);
                    }

                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }

            sb.append(min).append(" ").append(max).append("\n");
        }

        System.out.print(sb);

        br.close();
    }
}
