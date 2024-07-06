import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for(int test = 1; test <= t; test++) {
            sb.append("#").append(test).append("\n");

            int n = Integer.parseInt(br.readLine());

            int[][] arr = new int[n][n];

            for(int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");

                for(int j = 0; j < n; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int[][][] rotationArr = new int[3][n][n];

            rotationArr[0] = rotate(arr);
            rotationArr[1] = rotate(rotationArr[0]);
            rotationArr[2] = rotate(rotationArr[1]);

            for(int i = 0; i < n; i++) {
                for(int j = 0; j < 3; j++) {
                    for(int k = 0; k < n; k++) {
                        sb.append(rotationArr[j][i][k]);
                    }
                    sb.append(" ");
                }
                sb.append("\n");
            }
        }

        System.out.print(sb);

        br.close();
    }

    private static int[][] rotate(int[][] arr) {
        int length = arr.length;

        int[][] copyArr = new int[length][length];

        for(int i = 0; i < length; i++) {
            for(int j = 0; j < length; j++) {
                copyArr[i][j] = arr[length - 1 - j][i];
            }
        }

        return copyArr;
    }
}
