import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Solution {
    private static char[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = 10;

        StringBuilder sb = new StringBuilder();

        for(int test = 1; test <= T; test++) {
            int len = Integer.parseInt(br.readLine());

            arr = new char[8][8];

            for(int i = 0; i < 8; i++) {
                String s = br.readLine();

                for(int j = 0; j < 8; j++) {
                    arr[i][j] = s.charAt(j);
                }
            }

            int answer = 0;

            for(int i = 0; i < 8; i++) {
                for(int j = 0; j <= 8 - len; j++) {
                    String str = makeStrByLength(i, j, 0, 1, len);
                    String reverse = new StringBuilder(str).reverse().toString();

                    if (str.equals(reverse)) {
                        answer += 1;
                    }
                }
            }

            for(int i = 0; i <= 8 - len; i++) {
                for(int j = 0; j < 8; j++) {
                    String str = makeStrByLength(i, j, 1, 0, len);
                    String reverse = new StringBuilder(str).reverse().toString();

                    if (str.equals(reverse)) {
                        answer += 1;
                    }
                }
            }

            sb.append("#").append(test).append(" ");
            sb.append(answer).append("\n");
        }

        System.out.print(sb);

        br.close();
    }

    private static String makeStrByLength(int curX, int curY, int dx, int dy, int len) {
        StringBuilder sb = new StringBuilder();

        while(len > 0) {
            sb.append(arr[curX][curY]);

            curX += dx;
            curY += dy;

            len -= 1;
        }

        return sb.toString();
    }
}
