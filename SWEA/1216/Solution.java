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
            int test_case = Integer.parseInt(br.readLine());

            arr = new char[100][100];

            for(int i = 0; i < 100; i++) {
                String s = br.readLine();

                for(int j = 0; j < 100; j++) {
                    arr[i][j] = s.charAt(j);
                }
            }

            int answer = Integer.MIN_VALUE;

            for(int len = 1; len <= 100; len++) {
                for (int i = 0; i < 100; i++) {
                    for (int j = 0; j <= 100 - len; j++) {
                        String str = makeStrByLength(i, j, 0, 1, len);
                        String reverse = new StringBuilder(str).reverse().toString();

                        if (str.equals(reverse)) {
                            answer = Math.max(answer, len);
                        }
                    }
                }

                for (int i = 0; i <= 100 - len; i++) {
                    for (int j = 0; j < 100; j++) {
                        String str = makeStrByLength(i, j, 1, 0, len);
                        String reverse = new StringBuilder(str).reverse().toString();

                        if (str.equals(reverse)) {
                            answer = Math.max(answer, len);
                        }
                    }
                }
            }

            sb.append("#").append(test_case).append(" ");
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
