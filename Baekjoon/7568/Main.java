import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] countArr = new int[N];
        int[][] info = new int[N][2];
        Arrays.fill(countArr, 1);
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int weight = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());
            info[i][0] = weight;
            info[i][1] = height;
        }
        for(int i = 0; i < N; i++) {
            int myWeight = info[i][0];
            int myHeight = info[i][1];
            for(int j = 0; j < N; j++) {
                if (myWeight < info[j][0] && myHeight < info[j][1]) {
                    countArr[i] += 1;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int n : countArr) {
            sb.append(n).append(" ");
        }
        System.out.print(sb);
        br.close();
    }
}
