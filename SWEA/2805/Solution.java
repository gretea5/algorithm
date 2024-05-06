import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for(int test = 1; test <= t; test++) {
            int n = Integer.parseInt(br.readLine());

            int[][] arr = new int[n][n];

            for(int i = 0; i < n; i++) {
                String s = br.readLine();

                for(int j = 0; j < n; j++) {
                    arr[i][j] = s.charAt(j) - '0';
                }
            }

            int length = 1;
            int sum = 0;

            int mx = 0;
            int my = (n / 2);

            for(int i = 0; i < (n / 2); i++) {
                for(int j = 0; j < length; j++) {
                    sum += arr[mx][my + j];
                }

                mx += 1;
                my -= 1;

                length += 2;
            }

            length = n;

            mx = (n / 2);
            my = 0;

            for(int i = 0; i < length; i++) {
                sum += arr[mx][my + i];
            }

            mx = (n / 2) + 1;
            my = 1;

            length -= 2;

            for(int i = 0; i < (n / 2); i++) {
                for(int j = 0; j < length; j++) {
                    sum += arr[mx][my + j];
                }

                mx += 1;
                my += 1;

                length -= 2;
            }

            sb.append("#").append(test).append(" ");
            sb.append(sum).append("\n");
        }

        System.out.print(sb);

        br.close();
    }
}
